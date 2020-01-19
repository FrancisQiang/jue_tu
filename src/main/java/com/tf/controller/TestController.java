package com.tf.controller;

import com.tf.exception.GlobalException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgq
 * @date 2020/1/19
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello world!";
    }

    @GetMapping(value = "/exception")
    public String exception() throws GlobalException{
        throw new GlobalException("错误", 1);
    }

}
