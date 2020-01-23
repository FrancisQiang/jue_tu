package com.tf.advice;

import com.tf.exception.GlobalException;
import com.tf.vo.BaseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lgq
 * @date 2020/1/19
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = GlobalException.class)
    public BaseResult<String> handlerAdException(HttpServletRequest request,
                                                 GlobalException ex) {
        BaseResult<String> response = new BaseResult<>();
        response.setCode(ex.getCodeMessage().getCode());
        response.setMsg(ex.getMessage());
        return response;
    }

}
