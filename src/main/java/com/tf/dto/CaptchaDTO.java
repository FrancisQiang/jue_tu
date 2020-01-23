package com.tf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Wei yuyaung
 * @date 2020.01.23 16:23
 */
@Data
@AllArgsConstructor
public class CaptchaDTO {
    private String captcha;
    private String image;
}
