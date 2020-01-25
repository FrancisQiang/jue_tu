package com.tf.entity;

import java.util.Date;

public class Blog {
    private Integer blogId;

    private String blogTitle;

    private String blogSummary;

    private Date blogCreateTime;

    private Date blogUpdateTime;

    private Integer blogThumb;

    private Integer blogView;

    private Integer blogReply;

    private String blogTag;

    private Integer blogCategoryId;

    private String blogCover;

    private Boolean blogRecommend;

    private Integer blogAuthorId;

    private String blogAuthorAvatar;

    private String blogContent;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getBlogSummary() {
        return blogSummary;
    }

    public void setBlogSummary(String blogSummary) {
        this.blogSummary = blogSummary == null ? null : blogSummary.trim();
    }

    public Date getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(Date blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
    }

    public Date getBlogUpdateTime() {
        return blogUpdateTime;
    }

    public void setBlogUpdateTime(Date blogUpdateTime) {
        this.blogUpdateTime = blogUpdateTime;
    }

    public Integer getBlogThumb() {
        return blogThumb;
    }

    public void setBlogThumb(Integer blogThumb) {
        this.blogThumb = blogThumb;
    }

    public Integer getBlogView() {
        return blogView;
    }

    public void setBlogView(Integer blogView) {
        this.blogView = blogView;
    }

    public Integer getBlogReply() {
        return blogReply;
    }

    public void setBlogReply(Integer blogReply) {
        this.blogReply = blogReply;
    }

    public String getBlogTag() {
        return blogTag;
    }

    public void setBlogTag(String blogTag) {
        this.blogTag = blogTag == null ? null : blogTag.trim();
    }

    public Integer getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Integer blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public String getBlogCover() {
        return blogCover;
    }

    public void setBlogCover(String blogCover) {
        this.blogCover = blogCover == null ? null : blogCover.trim();
    }

    public Boolean getBlogRecommend() {
        return blogRecommend;
    }

    public void setBlogRecommend(Boolean blogRecommend) {
        this.blogRecommend = blogRecommend;
    }

    public Integer getBlogAuthorId() {
        return blogAuthorId;
    }

    public void setBlogAuthorId(Integer blogAuthorId) {
        this.blogAuthorId = blogAuthorId;
    }

    public String getBlogAuthorAvatar() {
        return blogAuthorAvatar;
    }

    public void setBlogAuthorAvatar(String blogAuthorAvatar) {
        this.blogAuthorAvatar = blogAuthorAvatar == null ? null : blogAuthorAvatar.trim();
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}