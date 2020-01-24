package com.tf.vo.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;

/**
 * @author lgq
 * @date 2020/1/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEditVO {

    @NotNull(message = "博客ID不能为空")
    private Integer blogId;

    @Length(max = 32, message = "长度不能超过32")
    private String blogTitle;

    @Length(max = 250, message = "长度不能超过250")
    private String blogSummary;

    @Length(max = 16, message = "长度不能超过16")
    private String blogTag;

    private Integer blogCategoryId;

    @Length(max = 256)
    @URL(message = "文章封面地址不是合法的URL")
    private String blogCover;

    private String blogContent;

}
