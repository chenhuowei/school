package com.fireway.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.ScoreRecordMapper;
import com.fireway.entity.ScoreRecord;
import com.fireway.entity.ScoreRecordExample;
import com.fireway.sys.service.ScoreRecordService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("scoreRecordService")
public class ScoreRecordServiceImpl implements ScoreRecordService {

	@Resource
	private ScoreRecordMapper scoreRecordMapper;
	
	public void save(ScoreRecord record) {
		scoreRecordMapper.insertSelective(record);
	}

	public void delete(String id) {
		scoreRecordMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(ScoreRecord record) {
		scoreRecordMapper.updateByPrimaryKeySelective(record);
		
	}

	public void updateById(ScoreRecord record) {
		scoreRecordMapper.updateByPrimaryKey(record);
	}

	public ScoreRecord findById(String id) {

		return scoreRecordMapper.selectByPrimaryKey(id);
	}

	public boolean isRepeat(String key) {

		return false;
	}

	public void updateSelectByExample(ScoreRecord record, ScoreRecordExample example) {
		scoreRecordMapper.updateByExampleSelective(record, example);
	}

	public void updateByExample(ScoreRecord record, ScoreRecordExample example) {
	}

	public List<ScoreRecord> findByExample(ScoreRecordExample example) {
		
		return scoreRecordMapper.selectByExample(example);
	}

	public PageBean<ScoreRecord> findByPage(int page, int limit, ScoreRecordExample example) {
		
		PageHelper.startPage(page, limit);
		List<ScoreRecord> list = findByExample(example);
		
		return new PageBean<ScoreRecord>(list);
	}

}
