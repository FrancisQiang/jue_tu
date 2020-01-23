package com.tf.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginVO {

    @NotNull(message = "用户名不能为空")
    private String userAccount;

    @NotNull(message = "密码不能为空")
    private String password;
}
