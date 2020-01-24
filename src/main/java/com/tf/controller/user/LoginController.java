package com.tf.controller.user;

import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.constant.CodeMessage;
import com.tf.dto.CaptchaDTO;
import com.tf.dto.LoginDTO;
import com.tf.exception.GlobalException;
import com.tf.service.UserService;
import com.tf.util.ValidateUtil;
import com.tf.vo.LoginVO;
import com.tf.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    /**
     * description: 登录
     *
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.23
     */
    @PostMapping("sign_in")
    public LoginDTO login(@RequestBody @Valid LoginVO loginInfo, BindingResult results) throws GlobalException {
        ValidateUtil.paramValidate(results);
        Integer userId = userService.login(loginInfo);
        String sign = jwtUtil.sign(String.valueOf(userId));
        return new LoginDTO(sign);
    }

    /**
     * description: 获取验证码
     *
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.23
     */
    @GetMapping("captcha")
    public CaptchaDTO captcha() throws GlobalException {
        return userService.generateVerificationCode();
    }

    /**
     * description: 用户注册
     *
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.23
     */
    @PostMapping("register")
    public String register(@RequestBody @Valid RegisterVO registerInfo, BindingResult results) throws GlobalException {
        ValidateUtil.paramValidate(results);
        boolean register = userService.register(registerInfo);
        if (register) {
            return "注册成功";
        } else {
            throw new GlobalException(CodeMessage.INTERNAL_SERVER_ERROR);
        }
    }
}
