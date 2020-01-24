package com.tf.utils;

import com.tf.exception.GlobalException;
import org.springframework.util.DigestUtils;

import java.util.Random;


/**
 * 密码加密解密
 *
 * @author Wei yuyaung
 * @date 2020.01.24 11:14
 */
public class PasswordUtil {


    /**
     * description: 输入盐值和密码，根据盐值和密码生成加密的密码
     *
     * @return: 加密后的密码
     * @author: Wei Yuyang
     * @time: 2020.01.24
     */
    public static String encodeWithSalt(String password, String salt) throws GlobalException {
        String passwordSalt = password + salt;
        return DigestUtils.md5DigestAsHex(passwordSalt.getBytes());
    }

    /**
     * description: 验证密码是否正确
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.24
     */
    public static boolean isPasswordCorrect(String password,String salt,String correctPassword){
        String passwordSalt = password + salt;
        String digest = DigestUtils.md5DigestAsHex(passwordSalt.getBytes());
        return digest.equals(correctPassword);
    }

    /**
     * description: 生成盐值
     * @return: 返回生成的盐值
     * @author: Wei Yuyang
     * @time: 2020.01.24
     */
    public static String generateSalt(){
        String seed = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-+=";
        Random randomLength = new Random(15);
        int length = randomLength.nextInt();
        Random random = new Random(seed.length());
        int value = random.nextInt();
        StringBuilder salt = new StringBuilder();
        for (int i = 0; i < length ; i++) {
            value = random.nextInt();
            salt.append(seed.charAt(value));
        }
        return salt.toString();
    }
}
