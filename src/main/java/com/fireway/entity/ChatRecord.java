package com.fireway.entity;

public class ChatRecord {
	
	private String id;
	private String fromUserId;
	private String fromUserName;
	private String toUserId;
	private String message;
	private String sendTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	@Override
	public String toString() {
		return "ChatRecord [id=" + id + ", fromUserId=" + fromUserId + ", fromUserName=" + fromUserName + ", toUserId="
				+ toUserId + ", message=" + message + ", sendTime=" + sendTime + "]";
	}
	
	
	

}
