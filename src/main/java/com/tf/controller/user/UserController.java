package com.tf.controller.user;

import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.constant.CodeMessage;
import com.tf.dto.UserInfoDTO;
import com.tf.exception.GlobalException;
import com.tf.service.UserService;
import com.tf.utils.ValidateUtil;
import com.tf.vo.ChangePasswordVO;
import com.tf.vo.ModifyUserInfoVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Wei yuyaung
 * @date 2020.01.28 19:03
 */
@RestController
public class UserController {
    private JwtUtil jwtUtil;
    private UserService userService;

    @Autowired
    public UserController(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    /**
     * description: 获取用户个人信息
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.28
     */
    @GetMapping("/userInfo")
    @RequiresPermissions("user:base")
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
    @RequiresPermissions("user:base")
    public String modifyUserOwnInfo(@RequestBody ModifyUserInfoVO modifyUserInfoVO) throws GlobalException {
        modifyUserInfoVO.setUserId(Integer.valueOf(jwtUtil.getUserId()));
        boolean success = userService.modifyUserInfo(modifyUserInfoVO);
        if(success){
            return "";
        }else {
            throw new GlobalException(CodeMessage.ERROR_MODIFY_USER_INFO);
        }
    }

    /**
     * description: 修改密码
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.02.03
     */
    @PostMapping("/user/password")
    @RequiresPermissions("user:info")
    public String changePassword(@RequestBody @Valid ChangePasswordVO changePasswordVO, BindingResult results) throws GlobalException {
        ValidateUtil.paramValidate(results);
        boolean success = userService.changePassword(changePasswordVO, Integer.valueOf(jwtUtil.getUserId()));
        if(success){
            return "";
        }else {
            throw new GlobalException(CodeMessage.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * description: 用户排行榜
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.02.11
     */
    @GetMapping("/user/rank")
    public List<UserInfoDTO> userRank(){
        List<UserInfoDTO> userRank = userService.getUserRank();
        //TODO 返回信息尚未完善
        return userRank;
    }

}
