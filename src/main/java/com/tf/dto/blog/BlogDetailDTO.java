package com.tf.dto.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lgq
 * @date 2020/1/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDetailDTO {

    private Integer blogId;

    private String blogTitle;

    private String blogSummary;

    private String blogContent;

    private Date blogCreateTime;

    private Date blogUpdateTime;

    private Integer blogThumb;

    private Integer blogView;

    private Integer blogReply;

    private String blogTag;

    private String blogCategoryName;

    private String blogCover;

    private Boolean blogRecommend;

    private Integer blogAuthorId;

    private String blogAuthorAvatar;

}
