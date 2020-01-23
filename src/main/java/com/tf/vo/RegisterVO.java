package com.tf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Wei yuyaung
 * @date 2020.01.23 19:04
 */
@Data
public class RegisterVO {

    @NotNull(message = "账号不能为空！")
    private String userAccount;
    @NotNull(message = "用户名不能为空！")
    private String userName;
    @NotNull(message = "密码不能为空！")
    private String password;
    @NotNull(message = "校验失败，请重试")
    private String key;
    @NotNull(message = "验证码不能为空")
    private String captcha;
}
