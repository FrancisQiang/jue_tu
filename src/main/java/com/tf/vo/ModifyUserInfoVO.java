package com.tf.vo;

import lombok.Data;

/**
 * @author Wei yuyaung
 * @date 2020.02.01 23:32
 */
@Data
public class ModifyUserInfoVO {

    private Integer userId;
    private String userName;
    private String userJob;
    private String userCompany;
    private String userDescription;
    private String userAvatar;
    private String userMobile;
    private String userEmail;
    private String userWeibo;
    private String userGithub;

}
