package com.fireway.sys.service;

import java.util.List;

import com.fireway.base.BaseService;
import com.fireway.entity.TestRecord;
import com.fireway.entity.TestRecordExample;
import com.fireway.utils.PageBean;

public interface TestRecordService extends BaseService<TestRecord> {

	void updateSelectByExample(TestRecord record , TestRecordExample example);
	void updateByExample(TestRecord record , TestRecordExample example);
	List<TestRecord> findByExample(TestRecordExample example);
	
	PageBean<TestRecord> findByPage(int page,Integer limit,TestRecordExample example);
	
	
}
