package com.tf.constant;

import lombok.Getter;

/**
 * @author lgq
 * @date 2020/1/23
 */
@Getter
public enum CodeMessage {

    /**
     * 响应码和对应信息
     */
    SUCCESS(0, "成功"),
    ERROR_INPUT(1, "输入的数据有误"),
    GENERATE_CAPTCHA_FAIL(2, "生成验证码失败"),
    CLOSE_IMAGE_OUTPUT_STREAM_FAIL(3, "关闭图像输出流失败"),
    USER_ACCOUNT_LOCKED(4,"该账号已被冻结"),
    USERNAME_PASSWORD_ERROR(1001, "用户名或密码错误"),
    INCORRECT_VERIFICATION_CODE(1002, "验证码错误"),
    BLOG_ADD_ERROR(1001, "添加博客失败"),
    SAME_USER_ACCOUNT(1003,"该用户名已经被使用"),
    ERROR_VERIFICATION(1004,"验证码不正确");

    private Integer code;
    private String message;

     CodeMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}