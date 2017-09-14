package com.fireway.entity;

import java.util.Date;

public class Opinion {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String operatorNum;

    /**
     * 
     */
    private String operator;

    /**
     * 
     */
    private Boolean status;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String context;

    /**
     * 
     */
    private Date sendTime;

    /**
     * 
     */
    private String author;

    /**
     * 
     */
    private String authorNum;

    /**
     * 
     */
    private Boolean isAnonymous;

    /**
     * 
     */
    private String authorMobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperatorNum() {
        return operatorNum;
    }

    public void setOperatorNum(String operatorNum) {
        this.operatorNum = operatorNum;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(String authorNum) {
        this.authorNum = authorNum;
    }

    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public String getAuthorMobile() {
        return authorMobile;
    }

    public void setAuthorMobile(String authorMobile) {
        this.authorMobile = authorMobile;
    }
}