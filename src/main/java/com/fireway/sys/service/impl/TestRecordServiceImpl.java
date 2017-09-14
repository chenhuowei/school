package com.fireway.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.fireway.dao.TestRecordMapper;
import com.fireway.entity.TestRecord;
import com.fireway.entity.TestRecordExample;
import com.fireway.sys.service.TestRecordService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("testRecordService")
public class TestRecordServiceImpl implements TestRecordService {

	@Resource
	private TestRecordMapper testRecordMapper;
	
	
	public void save(TestRecord record) {
		testRecordMapper.insert(record);
	}

	public void delete(String id) {
		testRecordMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(TestRecord record) {
		testRecordMapper.updateByPrimaryKeySelective(record);
	}

	public void updateById(TestRecord record) {
		testRecordMapper.updateByPrimaryKey(record);
	}

	public TestRecord findById(String id) {

		return testRecordMapper.selectByPrimaryKey(id);
	}

	public boolean isRepeat(String key) {
		TestRecordExample example = new TestRecordExample();
		example.createCriteria().andTestCodeEqualTo(key);
		int count = testRecordMapper.countByExample(example);
		if (count == 0){
			return false;
		}
		return true;
	}

	public void updateSelectByExample(TestRecord record, TestRecordExample example) {
		testRecordMapper.updateByExampleSelective(record, example);
	}

	public void updateByExample(TestRecord record, TestRecordExample example) {
		testRecordMapper.updateByExample(record, example);
	}

	public List<TestRecord> findByExample(TestRecordExample example) {
		
		return testRecordMapper.selectByExample(example);
	}

	public PageBean<TestRecord> findByPage(int page, Integer limit, TestRecordExample example) {
		
		PageHelper.startPage(page, limit);
		List<TestRecord> list = findByExample(example);
		return new PageBean<TestRecord>(list);
	}

}
