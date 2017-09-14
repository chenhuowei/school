package com.fireway.entity;

import java.util.Date;

public class Comments {
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
    private Date replyTime;

    /**
     * 
     */
    private String replyMan;

    /**
     * 
     */
    private Integer replyManNum;

    /**
     * 
     */
    private String replyManMobile;

    /**
     * 
     */
    private Integer opinionId;

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

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyMan() {
        return replyMan;
    }

    public void setReplyMan(String replyMan) {
        this.replyMan = replyMan;
    }

    public Integer getReplyManNum() {
        return replyManNum;
    }

    public void setReplyManNum(Integer replyManNum) {
        this.replyManNum = replyManNum;
    }

    public String getReplyManMobile() {
        return replyManMobile;
    }

    public void setReplyManMobile(String replyManMobile) {
        this.replyManMobile = replyManMobile;
    }

    public Integer getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Integer opinionId) {
        this.opinionId = opinionId;
    }
}