package com.fireway.entity;

public class Location {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String createTime;

    /**
     * 
     */
    private String updateTime;

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
    private String building;

    /**
     * 
     */
    private String roomNum;

    /**
     * 
     */
    private Boolean isOffic;

    /**
     * 
     */
    private Integer capacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Boolean getIsOffic() {
        return isOffic;
    }

    public void setIsOffic(Boolean isOffic) {
        this.isOffic = isOffic;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}