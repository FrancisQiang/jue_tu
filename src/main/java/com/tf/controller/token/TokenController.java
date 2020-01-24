package com.tf.controller.token;

import com.qiniu.util.Auth;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgq
 * @date 2020/1/23
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/token")
public class TokenController {

    @RequestMapping(value = "/qiniu", method = RequestMethod.GET)
    public String getToken(){
        // 公钥
        String accessKey = "VxHyI0oEEQapsj7PjTDxE9ydhduF1AbyAjExc7ry";
        // 秘钥
        String secretKey = "dbelSqf9Zrs48b5hT6upq4xVr35n-sCiKCCd52fO";
        String bucket = "juetu";
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket, null, 36000, null, true);
    }

}
