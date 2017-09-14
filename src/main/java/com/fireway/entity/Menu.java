package com.fireway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Menu {
	
	
	
    public Menu() {
		super();
		id = UUID.randomUUID().toString();
		createTime = new Date();
	}

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
    private String operatorId;

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
    private String text;

    /**
     * 
     */
    private String url;

    /**
     * 
     */
    private String icon;

    /**
     * 
     */
    private String iconCls;

    /**
     * 
     */
    private String pid;

    /**
     * 
     */
    private Boolean leaf;

    
    private List<Menu> children = new ArrayList<Menu>(0);
	
    
    public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

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

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }
}