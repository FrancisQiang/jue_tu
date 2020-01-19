package com.tf.exception;

import lombok.Data;
import lombok.Getter;

/**
 * @author lgq
 * @date 2020/1/19
 */
@Getter
public class GlobalException extends Exception {

    private static final long serialVersionUID = -3655264493408473309L;

    private int code;

    public GlobalException(String message, int code) {
        super(message);
        this.code = code;
    }



}

