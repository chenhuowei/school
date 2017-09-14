package com.fireway.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.AcademyMapper;
import com.fireway.entity.Academy;
import com.fireway.entity.AcademyExample;
import com.fireway.sys.service.AcademyService;
import com.fireway.utils.PageBean;
import com.fireway.utils.StringUtils;
import com.github.pagehelper.PageHelper;

@Service("academyService")
public class AcademyServiceImpl implements AcademyService {

	@Resource
	private AcademyMapper academyMapper;
	
	public void saveAcademy(Academy a) {
		academyMapper.insertSelective(a);
	}

	public void deleteyId(String id) {
		academyMapper.deleteByPrimaryKey(id);
	}

	public void deleteByExample(AcademyExample example) {
		academyMapper.deleteByExample(example);
	}

	public void updateByExample(Academy a, AcademyExample example) {
		academyMapper.updateByExampleSelective(a, example);
	}

	public List<Academy> findByExample(AcademyExample example) {

		return academyMapper.selectByExample(example);
	}

	public Academy findById(String id) {

		return academyMapper.selectByPrimaryKey(id);
	}

	public PageBean<Academy> findByPage(int page, int rows, AcademyExample example) {

		PageHelper.startPage(page, rows);
		List<Academy> list = findByExample(example);
		
		return new PageBean<Academy>(list);
	}

	public boolean isRepeat(String code) {

		if (StringUtils.isNotBlank(code)){
			AcademyExample example = new AcademyExample();
			example.createCriteria().andCodeEqualTo(code);
			int count = academyMapper.countByExample(example);
			if (count<=0){
				return false;
			}
		}
		
		return true;
	}

	public List<Map<String, String>> findIdnName(int page,int limit,AcademyExample example) {
		
		PageHelper.startPage(page, limit);
		List<Map<String, String>> list = academyMapper.findIdnName(example);
		
		return list;
	}

	public List<Map<String, String>> findTreeList(AcademyExample example) {
		
		return academyMapper.findTreeList(example);
	}

}
