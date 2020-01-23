package com.tf.util;

import com.tf.constant.CodeMessage;
import com.tf.exception.GlobalException;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author lgq
 * @date 2020/1/23
 */
public class ValidateUtil {


    public static void paramValidate(BindingResult result) throws GlobalException {
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            if (fieldError != null) {
                throw new GlobalException(new CodeMessage(CodeMessage.PARAM_ERROR, fieldError.getDefaultMessage()));
            } else {
                throw new GlobalException(new CodeMessage(CodeMessage.PARAM_ERROR, ""));
            }
        }
    }

}
