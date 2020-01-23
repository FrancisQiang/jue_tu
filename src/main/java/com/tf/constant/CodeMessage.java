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
    BLOG_ADD_ERROR(1001, "添加博客失败");

    private Integer code;
    private String message;

    CodeMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}