package com.tf.entity;

import java.util.Date;

public class Log {
    private Integer logId;

    private Integer logAdminId;

    private String logOperateIp;

    private Byte logOperateType;

    private Date logOperateAt;

    private String logOperateComment;

    private String logOperateTable;

    private String logOpeateContent;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogAdminId() {
        return logAdminId;
    }

    public void setLogAdminId(Integer logAdminId) {
        this.logAdminId = logAdminId;
    }

    public String getLogOperateIp() {
        return logOperateIp;
    }

    public void setLogOperateIp(String logOperateIp) {
        this.logOperateIp = logOperateIp == null ? null : logOperateIp.trim();
    }

    public Byte getLogOperateType() {
        return logOperateType;
    }

    public void setLogOperateType(Byte logOperateType) {
        this.logOperateType = logOperateType;
    }

    public Date getLogOperateAt() {
        return logOperateAt;
    }

    public void setLogOperateAt(Date logOperateAt) {
        this.logOperateAt = logOperateAt;
    }

    public String getLogOperateComment() {
        return logOperateComment;
    }

    public void setLogOperateComment(String logOperateComment) {
        this.logOperateComment = logOperateComment == null ? null : logOperateComment.trim();
    }

    public String getLogOperateTable() {
        return logOperateTable;
    }

    public void setLogOperateTable(String logOperateTable) {
        this.logOperateTable = logOperateTable == null ? null : logOperateTable.trim();
    }

    public String getLogOpeateContent() {
        return logOpeateContent;
    }

    public void setLogOpeateContent(String logOpeateContent) {
        this.logOpeateContent = logOpeateContent == null ? null : logOpeateContent.trim();
    }
}