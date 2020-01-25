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
public class BlogBriefListDTO {

    private Integer blogId;

    private String blogTitle;

    private String blogSummary;

    private Date blogCreateTime;

    private Integer blogThumb;

    private Integer blogView;

    private Integer blogReply;

    private String blogTag;

    private String blogCategoryName;

    private String blogCover;

    private Double blogRecommend;

    private Integer blogAuthorId;

    private String blogAuthorAvatar;

}
