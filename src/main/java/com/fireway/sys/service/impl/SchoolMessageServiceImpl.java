package com.fireway.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import com.fireway.dao.SchoolMessageMapper;
import com.fireway.entity.SchoolMessage;
import com.fireway.entity.SchoolMessageExample;
import com.fireway.sys.service.SchoolMessageService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("schoolMessageService")
public class SchoolMessageServiceImpl implements SchoolMessageService {

	@Resource
	private SchoolMessageMapper schoolMessageMapper;
	
	public void save(SchoolMessage record) {
		schoolMessageMapper.insert(record);
	}

	public void delete(String id) {
		schoolMessageMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(SchoolMessage record) {
		schoolMessageMapper.updateByPrimaryKeySelective(record);
	}

	public void updateById(SchoolMessage record) {
		schoolMessageMapper.updateByPrimaryKey(record);
	}

	public SchoolMessage findById(String id) {

		return schoolMessageMapper.selectByPrimaryKey(id);
	}

	public boolean isRepeat(String key) {

		return false;
	}

	public List<SchoolMessage> findByExample(SchoolMessageExample example) {
		
		return schoolMessageMapper.selectByExample(example);
	}

	public PageBean<SchoolMessage> findByPage(int page, int limit, SchoolMessageExample example) {
		PageHelper.startPage(page, limit);
		List<SchoolMessage> list = findByExample(example);
		return new PageBean<SchoolMessage>(list);
	}

}
