package com.tf.dto.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lgq
 * @date 2020/1/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogCommentListDTO {

    private Integer blogCommentId;

    private Integer blogCommentPid;

    private Integer userId;

    private String userName;

    private String userAvatar;

    private Date blogCommentCreateTime;

    private String blogCommentContent;

}
