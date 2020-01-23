package com.tf.controller.user;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.louislivi.fastdep.shirojwt.jwt.JwtUtil;
import com.tf.constant.Code;
import com.tf.dto.CaptchaDTO;
import com.tf.dto.LoginDTO;
import com.tf.exception.GlobalException;
import com.tf.service.RedisService;
import com.tf.service.UserService;
import com.tf.utils.GenerateRandomKey;
import com.tf.vo.BaseResult;
import com.tf.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    /**
     * description: 登录
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.23
     */
    @PostMapping("sign_in")
    public BaseResult<LoginDTO> login(@RequestBody @Valid LoginVO loginInfo, BindingResult results) throws GlobalException {
        if(results.hasErrors()){
            return new BaseResult<>(1,results.getFieldError().getDefaultMessage());
        }
        Integer userId = userService.login(loginInfo);

        String sign = jwtUtil.sign(String.valueOf(userId));
        LoginDTO loginDTO = new LoginDTO(sign);
        return new BaseResult<LoginDTO>(Code.SUCCESS_CODE,"登录成功",loginDTO);
    }

    /**
     * description: 获取验证码
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.01.23
     */
    @GetMapping("captcha")
    public BaseResult<CaptchaDTO> captcha() throws GlobalException {
        CaptchaDTO captchaDTO = userService.generateVerificationCode();
        return new BaseResult<CaptchaDTO>(Code.SUCCESS_CODE,"获取验证码成功",captchaDTO);
    }
}
