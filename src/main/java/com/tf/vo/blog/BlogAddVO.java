package com.tf.vo.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lgq
 * @date 2020/1/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAddVO {

    private String blogTitle;

    private String blogSummary;

    private String blogTag;

    private Integer blogCategoryId;

    private String blogCover;

    private String blogContent;

}
