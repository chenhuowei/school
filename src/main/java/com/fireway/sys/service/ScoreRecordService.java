package com.fireway.sys.service;

import java.util.List;

import com.fireway.base.BaseService;
import com.fireway.entity.ScoreRecord;
import com.fireway.entity.ScoreRecordExample;
import com.fireway.utils.PageBean;

public interface ScoreRecordService extends BaseService<ScoreRecord> {
	
	void updateSelectByExample(ScoreRecord record, ScoreRecordExample example);
	
	void updateByExample(ScoreRecord record, ScoreRecordExample example);
	
	List<ScoreRecord> findByExample(ScoreRecordExample example);
	
	PageBean<ScoreRecord> findByPage(int page,int limit,ScoreRecordExample example);
	

}
