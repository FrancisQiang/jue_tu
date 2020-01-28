package com.tf.controller.user;

import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.dto.UserInfoDTO;
import com.tf.exception.GlobalException;
import com.tf.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wei yuyaung
 * @date 2020.01.28 19:03
 */
@RestController
public class UserController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;


    /**
     * description: 获取用户个人信息
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.28
     */
    @GetMapping("/userInfo")
    @RequiresPermissions("user:info")
    public UserInfoDTO userInfo() throws GlobalException {
        return userService.userInfo(Integer.valueOf(jwtUtil.getUserId()));
    }

    /**
     * description: TODO 字段待确认
     * @return: 获取其它用户的信息
     * @author: Wei Yuyang
     * @time: 2020.01.28
     */
    @GetMapping("/userInfo/{userId}")
    public UserInfoDTO otherUserInfo(@PathVariable String userId) throws GlobalException {
        return userService.userInfo(Integer.valueOf(userId));
    }
}
