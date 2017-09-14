package com.fireway.dao;

import java.util.List;

import com.fireway.entity.ChatRecord;

public interface ChatRecordMapper {

	void save(ChatRecord record);
	
	List<ChatRecord> findAll();
	List<ChatRecord> findByGroupChat();
	List<ChatRecord> findByFromUserId(String fromUserId);
	List<ChatRecord> findByToUserId(String toUserId);
	
	
	
}
