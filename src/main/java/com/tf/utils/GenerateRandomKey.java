package com.tf.utils;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Random;
import java.util.Timer;

/**
 * 生成随机数的工具类
 * @author Wei yuyaung
 * @date 2020.01.23 16:38
 */
public class GenerateRandomKey {

    /**
     * description: 生成随机的验证码key
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.23
     */
    public static String generateRandomVerificationKey(){
        Date date = new Date();
        Random random = new Random();
        return String.valueOf(date.getTime() + random.nextInt());
    }

}
