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
    USERNAME_PASSWORD_ERROR(1001, "用户名或密码错误"),
    INCORRECT_VERIFICATION_CODE(1002, "验证码错误"),
    BLOG_ADD_ERROR(1001, "添加博客失败");

    private Integer code;
    private String message;

    CodeMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}