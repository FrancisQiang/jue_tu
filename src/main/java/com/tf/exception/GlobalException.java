package com.tf.exception;

import com.tf.constant.CodeMessage;
import lombok.Data;
import lombok.Getter;

/**
 * @author lgq
 * @date 2020/1/19
 */
@Getter
public class GlobalException extends Exception {

    private static final long serialVersionUID = -3655264493408473309L;

    private CodeMessage codeMessage;

    public GlobalException(CodeMessage codeMessage) {
        super(codeMessage.getMessage());
        this.codeMessage = codeMessage;
    }



}

