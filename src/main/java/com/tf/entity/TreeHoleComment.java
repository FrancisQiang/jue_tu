package com.tf.entity;

import java.util.Date;

public class TreeHoleComment {
    private Integer treeHoleCommentId;

    private Integer treeHoleCommentPid;

    private Integer treeHoleCommentUserId;

    private Date treeHoleCommentCreateTime;

    private Integer treeHoleId;

    private String treeHoleCommentContent;

    public Integer getTreeHoleCommentId() {
        return treeHoleCommentId;
    }

    public void setTreeHoleCommentId(Integer treeHoleCommentId) {
        this.treeHoleCommentId = treeHoleCommentId;
    }

    public Integer getTreeHoleCommentPid() {
        return treeHoleCommentPid;
    }

    public void setTreeHoleCommentPid(Integer treeHoleCommentPid) {
        this.treeHoleCommentPid = treeHoleCommentPid;
    }

    public Integer getTreeHoleCommentUserId() {
        return treeHoleCommentUserId;
    }

    public void setTreeHoleCommentUserId(Integer treeHoleCommentUserId) {
        this.treeHoleCommentUserId = treeHoleCommentUserId;
    }

    public Date getTreeHoleCommentCreateTime() {
        return treeHoleCommentCreateTime;
    }

    public void setTreeHoleCommentCreateTime(Date treeHoleCommentCreateTime) {
        this.treeHoleCommentCreateTime = treeHoleCommentCreateTime;
    }

    public Integer getTreeHoleId() {
        return treeHoleId;
    }

    public void setTreeHoleId(Integer treeHoleId) {
        this.treeHoleId = treeHoleId;
    }

    public String getTreeHoleCommentContent() {
        return treeHoleCommentContent;
    }

    public void setTreeHoleCommentContent(String treeHoleCommentContent) {
        this.treeHoleCommentContent = treeHoleCommentContent == null ? null : treeHoleCommentContent.trim();
    }
}