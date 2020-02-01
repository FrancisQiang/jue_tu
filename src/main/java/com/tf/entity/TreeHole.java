package com.tf.entity;

import org.dozer.Mapping;

import java.util.Date;

public class TreeHole {
    @Mapping("id")
    private Integer treeHoleId;

    private Integer treeHoleUserId;

    @Mapping("time")
    private Date treeHoleCreateTime;

    private String treeHoleContent;

    public Integer getTreeHoleId() {
        return treeHoleId;
    }

    public void setTreeHoleId(Integer treeHoleId) {
        this.treeHoleId = treeHoleId;
    }

    public Integer getTreeHoleUserId() {
        return treeHoleUserId;
    }

    public void setTreeHoleUserId(Integer treeHoleUserId) {
        this.treeHoleUserId = treeHoleUserId;
    }

    public Date getTreeHoleCreateTime() {
        return treeHoleCreateTime;
    }

    public void setTreeHoleCreateTime(Date treeHoleCreateTime) {
        this.treeHoleCreateTime = treeHoleCreateTime;
    }

    public String getTreeHoleContent() {
        return treeHoleContent;
    }

    public void setTreeHoleContent(String treeHoleContent) {
        this.treeHoleContent = treeHoleContent == null ? null : treeHoleContent.trim();
    }
}