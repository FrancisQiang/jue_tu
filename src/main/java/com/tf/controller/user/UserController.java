package com.tf.controller.user;

import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.constant.CodeMessage;
import com.tf.dto.UserInfoDTO;
import com.tf.exception.GlobalException;
import com.tf.service.UserService;
import com.tf.vo.ModifyUserInfoVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * description: 获取其它用户的信息
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.28
     */
    @GetMapping("/userInfo/{userId}")
    public UserInfoDTO otherUserInfo(@PathVariable String userId) throws GlobalException {
        return userService.userInfo(Integer.valueOf(userId));
    }

    /**
     * description: 修改用户个人信息
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.02.01
     */
    @PatchMapping("/user/info")
    @RequiresPermissions("user:info")
    public String modifyUserOwnInfo(@RequestBody ModifyUserInfoVO modifyUserInfoVO) throws GlobalException {
        modifyUserInfoVO.setUserId(Integer.valueOf(jwtUtil.getUserId()));
        boolean success = userService.modifyUserInfo(modifyUserInfoVO);
        if(success){
            return "";
        }else {
            throw new GlobalException(CodeMessage.ERROR_MODIFY_USER_INFO);
        }
    }


}
