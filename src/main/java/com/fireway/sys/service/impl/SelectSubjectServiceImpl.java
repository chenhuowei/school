package com.fireway.sys.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.SelectSubjectMapper;
import com.fireway.entity.Location;
import com.fireway.entity.SelectSubject;
import com.fireway.entity.SelectSubjectExample;
import com.fireway.request.dto.AutoLayoutParams;
import com.fireway.sys.service.SelectSubjectService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("selectSubjectService")
public class SelectSubjectServiceImpl implements SelectSubjectService {

	@Resource
	private SelectSubjectMapper selectSubjectMapper;
	
	public void save(SelectSubject record) {
		selectSubjectMapper.insert(record);
	}

	public void delete(String id) {
		selectSubjectMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(SelectSubject record) {
		selectSubjectMapper.updateByPrimaryKeySelective(record);
	}

	public void updateById(SelectSubject record) {
		selectSubjectMapper.updateByPrimaryKey(record);
	}

	public SelectSubject findById(String id) {
		

		return selectSubjectMapper.selectByPrimaryKey(id);
	}

	public boolean isRepeat(String key) {

		return false;
	}

	public void updateByExample(SelectSubject record, SelectSubjectExample example) {
	}

	public void updateSelectByExample(SelectSubject record, SelectSubjectExample example) {
		selectSubjectMapper.updateByExampleSelective(record, example);
	}

	public List<SelectSubject> findByExample(SelectSubjectExample example) {
		
		return selectSubjectMapper.selectByExample(example);
	}

	public PageBean<SelectSubject> findByPage(int page, int limit, SelectSubjectExample example) {
		PageHelper.startPage(page, limit);
		List<SelectSubject> list = findByExample(example);
		return new PageBean<SelectSubject>(list);
	}

	public void autoLayout(String[] classWeek, String classTime, List<SelectSubject> selectSubjects,
			List<Location> locations) {
		
		
		try {
			Random random = new Random();
			int length = classWeek.length;
			for (int i = 0; i < selectSubjects.size(); i++) {
				for (int j = 0; j < locations.size(); j++) {
					SelectSubject selectSubject = selectSubjects.get(i);
					Location location = locations.get(j);
					
					int week = random.nextInt(length);
					int hasCount = selectSubjectMapper.countByLayoutParams(
							new AutoLayoutParams(classWeek[week], classTime, selectSubject.getTeacherId(), null, 
									location.getId(), null, 
									selectSubject.getSchoolYear(), selectSubject.getTerm())
							);
					if (hasCount ==0){
						autoConstractor(classWeek, classTime, selectSubject, location, week);
					}
					
				}
			}
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void deleteLayout(boolean sure,List<SelectSubject> selectSubjects) {
		if (sure){
			for (int i = 0; i < selectSubjects.size(); i++) {
				SelectSubject selectSubject = selectSubjects.get(i);
				selectSubject.setClassTime(null);
				selectSubject.setClassWeek(null);
				selectSubject.setLocationId(null);
				selectSubject.setLocationName(null);
				selectSubjectMapper.updateByPrimaryKeySelective(selectSubject);
			}
		}
	}
	
	private void autoConstractor(String[] classWeek, String classTime, SelectSubject selectSubject, Location location,
			int week) {
		selectSubject.setClassTime(classTime);
		selectSubject.setClassWeek(classWeek[week]);
		selectSubject.setLocationId(location.getId());
		selectSubject.setLocationName(location.getBuilding()+location.getRoomNum());
		selectSubjectMapper.updateByPrimaryKeySelective(selectSubject);
	}

	public List<SelectSubject> selectByStudentId(String studentId,String schoolYear,String term) {
		
		return selectSubjectMapper.selectByStudentId(studentId,schoolYear,term);
	}

	public List<SelectSubject> selectByTeacherId(String teacherId, String schoolYear, String term) {
		
		return selectSubjectMapper.selectByTeacherId(teacherId, schoolYear, term);
	}

	public PageBean<SelectSubject> selectByStudentIdAndPage(int page, int limit, String studentId, String schoolYear,
			String term) {
		PageHelper.startPage(page, limit);
		List<SelectSubject> list = selectSubjectMapper.selectByStudentIdAndPage(studentId, schoolYear, term);
		
		return new PageBean<SelectSubject>(list);
	}

	public List<Map<String, String>> selectByIdAndName(String teacherId, String schoolYear, String term) {
		
		return selectSubjectMapper.selectByIdAndName(teacherId, schoolYear, term);
	}

	

	

}
