package com.tf.vo;

import lombok.Data;

/**
 * @author Wei yuyaung
 * @date 2020.02.03 20:23
 */
@Data
public class ChangePasswordVO {
    private String oldPassword;
    private String newPassword;
}
