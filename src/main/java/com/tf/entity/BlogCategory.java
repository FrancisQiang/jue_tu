package com.tf.entity;

public class BlogCategory {
    private Integer blogCategoryId;

    private String blogCategoryName;

    private String blogCategoryDescription;

    public Integer getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Integer blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName == null ? null : blogCategoryName.trim();
    }

    public String getBlogCategoryDescription() {
        return blogCategoryDescription;
    }

    public void setBlogCategoryDescription(String blogCategoryDescription) {
        this.blogCategoryDescription = blogCategoryDescription == null ? null : blogCategoryDescription.trim();
    }
}