package com.tf.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.tf.constant.CodeMessage;
import com.tf.constant.RedisKey;
import com.tf.dao.UserMapper;
import com.tf.dto.CaptchaDTO;
import com.tf.dto.UserInfoDTO;
import com.tf.entity.User;
import com.tf.entity.UserExample;
import com.tf.exception.GlobalException;
import com.tf.service.RedisService;
import com.tf.service.UserService;
import com.tf.utils.GenerateRandomKey;
import com.tf.utils.PasswordUtil;
import com.tf.utils.ValidateUtil;
import com.tf.vo.ChangePasswordVO;
import com.tf.vo.LoginVO;
import com.tf.vo.ModifyUserInfoVO;
import com.tf.vo.RegisterVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private RedisService redisService;
    private DefaultKaptcha defaultKaptcha;
    private DozerBeanMapper dozerBeanMapper;

    private static final String BASE_AVATAR_URL = "http://juetu.francisqiang.top/config/default_avatar.jpg";
    private static final int EXPIRE_TIME = 300;

    @Autowired
    @SuppressWarnings("all")
    public UserServiceImpl(UserMapper userMapper, RedisService redisService, DefaultKaptcha defaultKaptcha, DozerBeanMapper dozerBeanMapper) {
        this.userMapper = userMapper;
        this.redisService = redisService;
        this.defaultKaptcha = defaultKaptcha;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @Override
    public Integer login(LoginVO loginInfo) throws GlobalException {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserAccountEqualTo(loginInfo.getUserAccount());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() == 0){
            throw new GlobalException(CodeMessage.USER_NOT_EXIST);
        }
        if(users.get(0).getUserStatus().equals(1)){
            throw new GlobalException(CodeMessage.USER_ACCOUNT_LOCKED);
        }
        if(PasswordUtil.isPasswordCorrect(loginInfo.getPassword(),users.get(0).getUserSalt(),users.get(0).getUserPassword())){
            return users.get(0).getUserId();

        }else {
            throw new GlobalException(new CodeMessage(1,"密码不正确"));
        }
    }

    @Override
    public CaptchaDTO generateVerificationCode() throws GlobalException {
        //生成文字
        String codeText = defaultKaptcha.createText();
        //将生成的文字和随机数字存入redis
        String key = GenerateRandomKey.generateRandomVerificationKey();
        redisService.setex(key,(String)codeText,EXPIRE_TIME);
        String s = redisService.get(key, String.class);
        System.out.println(s);
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = defaultKaptcha.createImage(codeText);

        byte[] imagesToBytes;
        outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", outputStream);
            imagesToBytes = outputStream.toByteArray();
        } catch (IOException e) {
            throw new GlobalException(CodeMessage.GENERATE_CAPTCHA_FAIL);
        }finally {
            try {
                outputStream.close();
            }catch (IOException e){
                throw new GlobalException(CodeMessage.CLOSE_IMAGE_OUTPUT_STREAM_FAIL);
            }
        }
        String codeImage = Base64.getEncoder().encodeToString(imagesToBytes);
        return new CaptchaDTO(key,"data:image/jpeg;base64," + codeImage.replaceAll("\r\n", ""));
    }

    @Override
    public boolean register(RegisterVO registerVO) throws GlobalException {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserAccountEqualTo(registerVO.getUserAccount());
        List<User> users = userMapper.selectByExample(userExample);
        //检查是否已注册
        if(users.size() != 0){
            throw new GlobalException(CodeMessage.SAME_USER_ACCOUNT);
        }
        userExample.clear();
        //校验验证码
        if(! (registerVO.getCaptcha().equals(redisService.get(registerVO.getKey(),String.class)))){
            throw new GlobalException(CodeMessage.ERROR_VERIFICATION);
        }else {
            redisService.del(registerVO.getKey());
        }
        User insertUserInfo = new User();
        insertUserInfo.setUserAccount(registerVO.getUserAccount());
        insertUserInfo.setUserName(registerVO.getUserName());
        insertUserInfo.setUserAvatar(BASE_AVATAR_URL);
        //生成盐值
        String salt = PasswordUtil.generateSalt();
        //加密
        String encodePassword = PasswordUtil.encodeWithSalt(registerVO.getPassword(), salt);
        //存储加密的密码
        insertUserInfo.setUserPassword(encodePassword);
        //存储盐值
        insertUserInfo.setUserSalt(salt);
        insertUserInfo.setUserCreateTime(new Date());
        int insertResult = userMapper.insertSelective(insertUserInfo);
        return insertResult > 0;
    }

    @Override
    public UserInfoDTO userInfo(Integer userId) throws GlobalException {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() == 0){
            throw new GlobalException(CodeMessage.USER_NOT_EXIST);
        }
        User userInfo = users.get(0);
        return dozerBeanMapper.map(userInfo,UserInfoDTO.class);
    }

    @Override
    public boolean modifyUserInfo(ModifyUserInfoVO modifyUserInfoVO) {
        return userMapper.updateByPrimaryKeySelective(dozerBeanMapper.map(modifyUserInfoVO,User.class)) > 0;
    }

    @Override
    public boolean changePassword(ChangePasswordVO changePasswordVO, Integer userId) throws GlobalException {
        UserExample userExample = new UserExample();
        User user = userMapper.selectByPrimaryKey(userId);
        if(user == null){
            throw new GlobalException(CodeMessage.USER_NOT_EXIST);
        }

        if(user.getUserPassword().equals(PasswordUtil.encodeWithSalt(changePasswordVO.getOldPassword(),user.getUserSalt()))){
            User changePassword = new User();
            changePassword.setUserId(user.getUserId());
            changePassword.setUserPassword(PasswordUtil.encodeWithSalt(changePasswordVO.getNewPassword(),user.getUserSalt()));
            return userMapper.updateByPrimaryKeySelective(changePassword) > 0;
        }else {
            throw new GlobalException(CodeMessage.ENTER_OLD_PASSWORD_ERROR);
        }
    }

    @Override
    public List<UserInfoDTO> getUserRank() {
        //第一次访问初始化redis列表
        Long size = redisService.zlen(RedisKey.USER_BLOG_SUBSCRIBE_LIST);
        if(size == 0){
            initialUserRankList();
        }
        //从redis中获取实时的点赞数和浏览量
        Set<String> userIdSet = redisService.zrange(RedisKey.USER_BLOG_SUBSCRIBE_LIST, 0, 99);
        List<Integer> userIdList = new ArrayList<>();
        for (String id:
             userIdSet) {
            userIdList.add(Integer.valueOf(id));
        }
        //处理返回数据
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdIn(userIdList);
        List<User> users = userMapper.selectByExample(userExample);
        List<UserInfoDTO> userInfos = new ArrayList<>();
        for (User user:
             users) {
            UserInfoDTO map = dozerBeanMapper.map(user, UserInfoDTO.class);
            userInfos.add(map);
        }
        return userInfos;
    }

    private void initialUserRankList(){
        //TODO 初始化点赞数列表
    }
}
