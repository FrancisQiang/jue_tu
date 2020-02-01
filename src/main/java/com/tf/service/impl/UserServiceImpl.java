package com.tf.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.tf.constant.CodeMessage;
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
import com.tf.vo.LoginVO;
import com.tf.vo.ModifyUserInfoVO;
import com.tf.vo.RegisterVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    private static final String BASE_AVATAR_URL = "http://juetu.francisqiang.top/config/default_avatar.jpg";
    private static final int EXPIRE_TIME = 300;

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
}
