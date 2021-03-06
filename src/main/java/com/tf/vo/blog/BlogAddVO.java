package com.tf.vo.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author lgq
 * @date 2020/1/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAddVO {

    @NotNull(message = "文章标题不能为空")
    @NotEmpty(message = "文章标题不能为空")
    @Length(max = 32, message = "长度不能超过32")
    private String blogTitle;

    @Length(max = 250, message = "长度不能超过250")
    private String blogSummary;

    @NotNull(message = "文章标签不能为空")
    @NotEmpty(message = "文章标签不能为空")
    @Length(max = 16, message = "长度不能超过16")
    private String blogTag;

    @NotNull(message = "文章分类不能为空")
    private Integer blogCategoryId;

    @NotNull(message = "文章内容不能为空")
    @NotEmpty(message = "文章内容不能为空")
    private String blogContent;

    @Length(max = 256)
    @URL(message = "文章封面地址不是合法的URL")
    private String blogCover;

}
