package com.tf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Wei yuyaung
 * @date 2020.01.28 19:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {

    private Integer userId;

    private String userName;

    private String job;

    private String company;

    private String description;

    private String avatar;

    private Integer juetuValue;

    private Integer blogViews;

    private Integer blogThumbs;

    private String home;

    private String weibo;

    private String github;

    private Integer blogNum;

    private Integer bookNum;

    private Integer treeholeNum;

    private Date createTime;
}
