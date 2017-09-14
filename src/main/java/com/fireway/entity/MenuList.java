package com.fireway.entity;

import java.util.ArrayList;
import java.util.List;

public class MenuList {
	
	private List<MenuList> children = new ArrayList<MenuList>(0);
	
    public List<MenuList> getChildren() {
		return children;
	}

	public void setChildren(List<MenuList> children) {
		this.children = children;
	}

	/**
     * 
     */
    private String id;

    /**
     * 
     */
    private String text;

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
    private String url;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private Double width;

    /**
     * 
     */
    private Double height;

    /**
     * 
     */
    private String pid;

    /**
     * 
     */
    private Boolean leaf;

    /**
     * 
     */
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}