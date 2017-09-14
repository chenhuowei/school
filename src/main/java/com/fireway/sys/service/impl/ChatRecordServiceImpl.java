package com.fireway.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.ChatRecordMapper;
import com.fireway.entity.ChatRecord;
import com.fireway.sys.service.ChatRecordService;

@Service("chatRecordService")
public class ChatRecordServiceImpl implements ChatRecordService {

	@Resource
	private ChatRecordMapper chatRecordMapper;
	
	public void save(ChatRecord record) {
		chatRecordMapper.save(record);
	}

	public List<ChatRecord> findAll() {

		return chatRecordMapper.findAll();
	}

	public List<ChatRecord> findByGroupChat() {

		return chatRecordMapper.findByGroupChat();
	}

	public List<ChatRecord> findByFormUserId(String fromUserId) {

		return chatRecordMapper.findByFromUserId(fromUserId);
	}

	public List<ChatRecord> findByToUserId(String toUserId) {

		return chatRecordMapper.findByToUserId(toUserId);
	}

}
