package com.tf.controller;

import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.exception.GlobalException;
import com.tf.service.RedisService;
import com.tf.vo.BaseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lgq
 * @date 2020/1/19
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    RedisService redisService;

    /**
     * description: 模拟登录获取JWT令牌
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.22
     */
    @PostMapping("/login")
    public BaseResult<String> login(String id){
        //真实情况：输入账号密码进行校验，成功返回id再获取JWT令牌
        String sign = jwtUtil.sign(id);
        BaseResult<String> baseResult = new BaseResult<>(200,"success");
        baseResult.setData(sign);
        return baseResult;
    }

    /**
     * description: 权限测试
     * @return: 
     * @author: Wei Yuyang
     * @time: 2020.01.22
     */
    @RequiresPermissions("testpermission")
    @GetMapping("/permission")
    public BaseResult<String> permission(){
        String userId = jwtUtil.getUserId();
        return new BaseResult<>(200,"该用户拥有测试权限");
    }

    @GetMapping(value = "/{redisKey}")
    public boolean removeKey(@PathVariable(value = "redisKey") String rediskey) {
        return redisService.del(rediskey);
    }

}
