package com.tf.dto.treehole;

import lombok.Data;

import java.util.Date;

/**
 * @author Wei yuyaung
 * @date 2020.02.03 18:09
 */
@Data
public class TreeHoleCommentDTO {
    private Integer id;
    private Integer pid;
    private String content;
    private String userId;
    private Date createTime;
}
