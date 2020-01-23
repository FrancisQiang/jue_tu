package com.tf.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.tf.constant.CodeMessage;
import com.tf.dao.UserMapper;
import com.tf.dto.CaptchaDTO;
import com.tf.entity.User;
import com.tf.entity.UserExample;
import com.tf.exception.GlobalException;
import com.tf.service.RedisService;
import com.tf.service.UserService;
import com.tf.utils.GenerateRandomKey;
import com.tf.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Override
    public Integer login(LoginVO loginInfo) throws GlobalException {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserAccountEqualTo(loginInfo.getUsername()).andUserPasswordEqualTo(loginInfo.getPassword());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() == 0){
            throw new GlobalException(CodeMessage.USERNAME_PASSWORD_ERROR);
        }
        return users.get(0).getUserId();
    }

    @Override
    public CaptchaDTO generateVerificationCode() throws GlobalException {
        //生成文字
        String codeText = defaultKaptcha.createText();
        //将生成的文字和随机数字存入redis
        String key = GenerateRandomKey.generateRandomVerificationKey();
        //TODO 时间应该设置为常量
        redisService.setex(key,codeText,300);

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
        return new CaptchaDTO(key,codeImage);
    }
}
