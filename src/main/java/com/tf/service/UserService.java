package com.tf.service;

import com.tf.dto.CaptchaDTO;
import com.tf.dto.UserInfoDTO;
import com.tf.exception.GlobalException;
import com.tf.vo.ChangePasswordVO;
import com.tf.vo.LoginVO;
import com.tf.vo.ModifyUserInfoVO;
import com.tf.vo.RegisterVO;

public interface UserService {
    /**
     * description: 登录
     * @return 返回用户id
     * @author: Wei Yuyang
     * @time: 2020.01.23
     */
    Integer login(LoginVO loginInfo) throws GlobalException;

    /**
     * description: 生成验证码
     * @author: Wei Yuyang
     * @time: 2020.01.23
     */
    CaptchaDTO generateVerificationCode() throws GlobalException;

    /**
     * description: 用户注册
     * @author: Wei Yuyang
     * @time: 2020.01.23
     */
    boolean register(RegisterVO registerVO) throws GlobalException;

    /**
     * description: 获取用户信息
     * @author: Wei Yuyang
     * @time: 2020.01.28
     */
    UserInfoDTO userInfo(Integer userId) throws GlobalException;

    /**
     * description: 修改用户信息
     * @author: Wei Yuyang
     * @time: 2020.02.01
     */
    boolean modifyUserInfo(ModifyUserInfoVO modifyUserInfoVO);

    /**
     * description:
     * @author: Wei Yuyang
     * @time: 2020.02.03
     */
    boolean changePassword(ChangePasswordVO changePasswordVO,Integer userId) throws GlobalException;

}
