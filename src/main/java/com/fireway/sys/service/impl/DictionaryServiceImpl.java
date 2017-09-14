package com.fireway.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.DictionaryMapper;
import com.fireway.entity.Dictionary;
import com.fireway.entity.DictionaryExample;
import com.fireway.sys.service.DictionaryService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

	@Resource
	private DictionaryMapper dictionaryMapper;
	
	public void save(Dictionary record) {
		dictionaryMapper.insert(record);
	}

	public void deleteById(String id) {
		dictionaryMapper.deleteByPrimaryKey(id);
	}

	
	
	public void updateByExample(Dictionary record,DictionaryExample example) {
		dictionaryMapper.updateByExampleSelective(record, example);
	}

	public Dictionary findById(String id) {

		return dictionaryMapper.selectByPrimaryKey(id);
	}
	
	public List<Dictionary> findByExample(DictionaryExample example) {
		
		return dictionaryMapper.selectByExample(example);
	}

	public PageBean<Dictionary> findByPage(int page, int limit, DictionaryExample example) {
		
		PageHelper.startPage(page, limit);
		List<Dictionary> list = findByExample(example);
		
		return new PageBean<Dictionary>(list);
	}

	public List<Map<String, String>> findByType(int page,int limit,String type) {
		DictionaryExample example = new DictionaryExample();
		example.createCriteria().andTypeEqualTo(type).andStatusEqualTo(true);
		PageHelper.startPage(page, limit);
		List<Map<String, String>> list = dictionaryMapper.selectByType(example);
		
		return list;
	}

	public List<Map<String, String>> findTreeList(String type) {
		DictionaryExample example = new DictionaryExample();
		example.createCriteria().andTypeEqualTo(type).andStatusEqualTo(true);
		example.setOrderByClause(type);
		return dictionaryMapper.findTreeList(example);
	}
	

}
