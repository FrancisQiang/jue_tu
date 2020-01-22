package com.tf.controller;

import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.exception.GlobalException;
import com.tf.vo.BaseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgq
 * @date 2020/1/19
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello world!";
    }

    @GetMapping(value = "/exception")
    public String exception() throws GlobalException{
        throw new GlobalException("错误", 1);
    }

    @PostMapping("/login")
    public BaseResult<String> login(String id){
        String sign = jwtUtil.sign(id);
        BaseResult<String> baseResult = new BaseResult<>(200,"success");
        baseResult.setData(sign);
        return baseResult;
    }

    @RequiresPermissions("testpermission")
    @GetMapping("/permission")
    public BaseResult<String> permission(){
        return new BaseResult<>(200,"该用户拥有测试权限");
    }

}
