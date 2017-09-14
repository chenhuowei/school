package com.fireway.sys.service;

import java.util.List;

import com.fireway.entity.ChatRecord;

public interface ChatRecordService {

	void save(ChatRecord record);
	List<ChatRecord> findAll();
	List<ChatRecord> findByGroupChat();
	List<ChatRecord> findByFormUserId(String fromUserId);
	List<ChatRecord> findByToUserId(String toUserId);
}
