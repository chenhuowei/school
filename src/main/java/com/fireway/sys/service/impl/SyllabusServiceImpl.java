package com.fireway.sys.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.ClassSubjectMapper;
import com.fireway.dao.ClassesMapper;
import com.fireway.dao.SyllabusMapper;
import com.fireway.entity.ClassSubject;
import com.fireway.entity.ClassSubjectExample;
import com.fireway.entity.Classes;
import com.fireway.entity.Location;
import com.fireway.entity.SubjectArrangement;
import com.fireway.entity.Syllabus;
import com.fireway.entity.SyllabusExample;
import com.fireway.request.dto.AutoLayoutParams;
import com.fireway.sys.service.SyllabusService;
import com.fireway.utils.LogUtil;
import com.fireway.utils.PageBean;
import com.fireway.utils.Utils;
import com.github.pagehelper.PageHelper;

@Service("syllabusService")
public class SyllabusServiceImpl implements SyllabusService {

	
	@Resource
	private SyllabusMapper syllabusMapper;
	@Resource
	private ClassSubjectMapper classSubjectMapper;
	@Resource
	private ClassesMapper classesMapper;
	
	private final static String[] weeks = new String[]{"星期一","星期二","星期三","星期四","星期五"};
	private final static String[] times = new String[]{"1-2","3-4","5-6","7-8"};
	
	
	//自动排课简单实现
	/**
	 * 班级课程按2节为一次
	 */
	public void autoLayoutCourse(String schoolYear,String term,
			List<SubjectArrangement> subjectArrangements,List<Location> locations) {
		
		final int maxClassLessionOfWeek = 8;
	// final int miniClassLessionOfWeek = 5;
		final int maxClassLessionOfDay = 3;
 		
		Random random = new Random();
		Syllabus syllabus = null;
			//获取科目安排
			if (subjectArrangements.size()==0){
				return ;
			}
			//获取教室
			if (locations.size()==0){
				return ;
			}
			SyllabusExample syllabusExample = new SyllabusExample();
			syllabusExample.createCriteria().andSchoolYearEqualTo(schoolYear).andTermEqualTo(term);
			Iterator<SubjectArrangement> subjectArrangementItems = subjectArrangements.iterator();
				while (subjectArrangementItems.hasNext()) {
					
					SubjectArrangement subjectArrangement1 = (SubjectArrangement) subjectArrangementItems.next();
					String teacherNum = subjectArrangement1.getTeacherNum();//teacher 
					String subjectCode = subjectArrangement1.getSubjectCode();//subject
					
					ClassSubjectExample classSubjectExample = new ClassSubjectExample();
					classSubjectExample.createCriteria().andSubjectArrangementIdEqualTo(subjectArrangement1.getId());
					ClassSubject classSubject = classSubjectMapper.selectByExample(classSubjectExample).get(0);
					Classes classes = classesMapper.selectByPrimaryKey(classSubject.getClassId());//class
					for (int k=0;k<subjectArrangement1.getWeekTimes();k++){
						SubjectArrangement subjectArrangement = subjectArrangement1;
						boolean flag = true;
						while(flag){
							int locationIndex = random.nextInt(locations.size());
							Location location = locations.get(locationIndex);
							// 随机获取时间点
							int weekIndex = random.nextInt(weeks.length);
							int timeIndex = random.nextInt(times.length);
							String classWeek = weeks[weekIndex];
							String classTime = times[timeIndex];
							if (syllabusMapper.selectByExample(syllabusExample).size() == 0){
								syllabus = syllabusConstructor(new Syllabus(), location, classes, 
										subjectArrangement, classWeek, classTime, schoolYear, term);
								save(syllabus);
								flag = false;
							}else {
								//查找当前时间点的唯一性
								int itemAmount = syllabusMapper.countByLayoutParams(
										new AutoLayoutParams(classWeek, classTime, teacherNum, 
												classes.getId(), location.getId(), null, schoolYear, term));
								if (itemAmount == 0){
									// 班级 一天最多有三次课
									int classDayCount = syllabusMapper.countClassLessionOfDay(
											new AutoLayoutParams(classWeek, null, null, classes.getId(), null, null, schoolYear, term)
											);
									//班级一门科目一天最多一次		
									int classSubjectDayCount = syllabusMapper.countClassSubjectOfDay(
											new AutoLayoutParams(classWeek, null, null, classes.getId(), null, subjectCode, schoolYear, term)
											);
									//教师一天最多3次课	
									int countTeacherDayCount = syllabusMapper.countTeacherLessionOfDay(
											new AutoLayoutParams(classWeek, null, teacherNum, null, null, null, schoolYear, term)
											);
									//检查教师当前科目，时间点是否有课	
									if(classDayCount < maxClassLessionOfDay && countTeacherDayCount < 3
											&& classSubjectDayCount < 1	){
										syllabus = syllabusConstructor(new Syllabus(), location, classes, 
												subjectArrangement, classWeek, classTime, schoolYear, term);
										save(syllabus);
										flag=false;
									}
								}
							}
							
						}
					}
			}
			
	}



	private Syllabus syllabusConstructor(Syllabus syllabus, Location location,Classes classes,
			SubjectArrangement subjectArrangement, String week, String time,
			String schoolYear,String term) {
		syllabus.setId(Utils.uuid());
		syllabus.setLocationId(location.getId());
		syllabus.setClassTime(time);
		syllabus.setClassWeek(week);
		syllabus.setClassId(classes.getId());
		syllabus.setSubjectCode(subjectArrangement.getSubjectCode());
		syllabus.setLocationName(location.getBuilding()+location.getRoomNum());
		syllabus.setSubjectName(subjectArrangement.getSubjectName()+subjectArrangement.getSubjectVolumes());
		syllabus.setTeacherName(subjectArrangement.getTeacherName());
		syllabus.setTeacherNum(subjectArrangement.getTeacherNum());
		syllabus.setSchoolYear(schoolYear);
		syllabus.setTerm(term);
		syllabus.setAcademyName(classes.getAcademyName());
		syllabus.setClassName(classes.getName());
		
		return syllabus;
	}



	public void save(Syllabus record) {
		syllabusMapper.insert(record);
	}



	public void deleteById(String id) {
		syllabusMapper.deleteByPrimaryKey(id);
	}



	public void updateSelectById(Syllabus record) {
		syllabusMapper.updateByPrimaryKeySelective(record);
	}



	public void updateById(Syllabus record) {
		syllabusMapper.updateByPrimaryKey(record);
	}



	public List<Syllabus> findByExample(SyllabusExample example) {
		
		return syllabusMapper.selectByExample(example);
	}



	public PageBean<Syllabus> findByPage(int page, int limit, SyllabusExample example) {
		
		PageHelper.startPage(page, limit);
		List<Syllabus> list = findByExample(example);
		return new PageBean<Syllabus>(list);
	}



	public void deleteByExample(SyllabusExample example) {
		syllabusMapper.deleteByExample(example);
	}



	public void updateByExample(Syllabus record,SyllabusExample example) {
		syllabusMapper.updateByExampleSelective(record, example);
	}
	
	
	
	
	
	
	
	
	

}
