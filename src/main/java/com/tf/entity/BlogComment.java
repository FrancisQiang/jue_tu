package com.tf.entity;

import java.util.Date;

public class BlogComment {
    private Integer blogCommentId;

    private Integer blogCommentPid;

    private Integer blogId;

    private Integer userId;

    private String userName;

    private String userAvatar;

    private Date blogCommentCreateTime;

    private Boolean blogCommentDeleteFlag;

    private String blogCommentContent;

    public Integer getBlogCommentId() {
        return blogCommentId;
    }

    public void setBlogCommentId(Integer blogCommentId) {
        this.blogCommentId = blogCommentId;
    }

    public Integer getBlogCommentPid() {
        return blogCommentPid;
    }

    public void setBlogCommentPid(Integer blogCommentPid) {
        this.blogCommentPid = blogCommentPid;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public Date getBlogCommentCreateTime() {
        return blogCommentCreateTime;
    }

    public void setBlogCommentCreateTime(Date blogCommentCreateTime) {
        this.blogCommentCreateTime = blogCommentCreateTime;
    }

    public Boolean getBlogCommentDeleteFlag() {
        return blogCommentDeleteFlag;
    }

    public void setBlogCommentDeleteFlag(Boolean blogCommentDeleteFlag) {
        this.blogCommentDeleteFlag = blogCommentDeleteFlag;
    }

    public String getBlogCommentContent() {
        return blogCommentContent;
    }

    public void setBlogCommentContent(String blogCommentContent) {
        this.blogCommentContent = blogCommentContent == null ? null : blogCommentContent.trim();
    }
}