package com.tf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThumbUserBlog {
    private Integer thumbUserBlogId;

    private Integer userId;

    private Integer blogId;

    public Integer getThumbUserBlogId() {
        return thumbUserBlogId;
    }

    public void setThumbUserBlogId(Integer thumbUserBlogId) {
        this.thumbUserBlogId = thumbUserBlogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}