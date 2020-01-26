package com.tf.vo.blog;

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
public class PostBlogCommentVO {

    private Integer blogCommentPid;

    private Integer blogId;

    private String blogCommentContent;

}
