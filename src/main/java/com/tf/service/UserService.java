package com.tf.service;

import com.tf.dto.CaptchaDTO;
import com.tf.exception.GlobalException;
import com.tf.vo.LoginVO;

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
}
