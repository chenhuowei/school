package com.fireway.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.ResultsStatisticalMapper;
import com.fireway.dao.ScoreRecordMapper;
import com.fireway.entity.ResultsStatistical;
import com.fireway.entity.ResultsStatisticalExample;
import com.fireway.entity.ResultsStatisticalExample.Criteria;
import com.fireway.entity.ScoreRecord;
import com.fireway.entity.ScoreRecordExample;
import com.fireway.sys.service.ResultsStatisticalService;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;

@Service("resultsStatisticalService")
public class ResultsStatisticalServiceImpl implements ResultsStatisticalService {

	
	@Resource
	private ResultsStatisticalMapper resultsStatisticalMapper;
	@Resource
	private ScoreRecordMapper scoreRecordMapper;
	
	
	public List<ResultsStatistical> findByStudentId(int page, int limit, String studentId, String schoolYear,
			Integer term, String keyWord) {

		ResultsStatisticalExample  example = new ResultsStatisticalExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		if (StringUtils.isNotBlank(schoolYear)){
			criteria.andSchoolYearEqualTo(schoolYear);
		}
		if (term != null && term !=0){
			criteria.andTermEqualTo(term);
		}
		return resultsStatisticalMapper.selectByExample(example);
	}
	
	
	private Map<String, Double> countBySchoolyearAndTerm(String studentId,String schoolYear,Integer term){
		Map<String, Double> map = new HashMap<String, Double>();
		double totalCredits = 0.0;
		double totalPoint = 0.0;
		double averagePoint = 0.0;
		ScoreRecordExample example = new ScoreRecordExample();
		com.fireway.entity.ScoreRecordExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(studentId)){
			criteria.andStudentIdEqualTo(studentId);
			if (StringUtils.isNotBlank(schoolYear)){
				criteria.andSchoolYearEqualTo(schoolYear);
				if (null !=term && term != 0){
					criteria.andTermEqualTo(term);
				}
			}
		}
		List<ScoreRecord> list = scoreRecordMapper.selectByExample(example);
		if (null !=list && list.size() >0){
			for (int i = 0; i < list.size(); i++) {
				ScoreRecord scoreRecord = list.get(i);
					if (null != scoreRecord.getSubjectCredits()){
						totalCredits += scoreRecord.getSubjectCredits();
						
					}
				totalPoint += scoreRecord.getPoint();
			}
			averagePoint = totalPoint/list.size()*1.00;
		}
		map.put("totalCredits", totalCredits);
		map.put("totalPoint", totalPoint);
		map.put("averagePoint", averagePoint);
		return map;
	}

	private void ResultSetting(String schoolYear, Integer term, String studentId, Map<String, Double> map) {
		ResultsStatistical resultsStatistical = new ResultsStatistical();
		resultsStatistical.setId(Utils.uuid());
		resultsStatistical.setSchoolYear(schoolYear);
		resultsStatistical.setTerm(term);
		resultsStatistical.setStudentId(studentId);
		resultsStatistical.setStatus(true);
		resultsStatistical.setAveragePoint(map.get("averagePoint"));
		resultsStatistical.setTotalCredits(map.get("totalCredits"));
		resultsStatistical.setTotalPoint(map.get("totalPoint"));
		save(resultsStatistical);
	}

	private void saveBySchoolYearAndTerm(String schoolYear,Integer term ,String studentId){
		ResultSetting(schoolYear, term, studentId, countBySchoolyearAndTerm(studentId, schoolYear, term));
	}


	
	private void saveBySchoolYear(String schoolYear,String studentId){
		ResultSetting(schoolYear, null, studentId, countBySchoolyearAndTerm(studentId, schoolYear, null));
	}
	
	private void saveAll(String studentId){
		ResultSetting(null, null, studentId, countBySchoolyearAndTerm(studentId, null, null));
	}
	
	
	public void save(ResultsStatistical record) {
		resultsStatisticalMapper.insert(record);
	}

	public void deleteByExample(ResultsStatisticalExample example) {
		resultsStatisticalMapper.deleteByExample(example);
	}


	public void saveAndReset(String schoolYear,Integer term ,String studentId) {
		ResultsStatisticalExample example = new ResultsStatisticalExample();
		example.createCriteria().andStudentIdEqualTo(studentId)
		.andSchoolYearEqualTo(schoolYear).andTermEqualTo(term);
		example.or().andStudentIdEqualTo(studentId).andSchoolYearIsNull();
		example.or().andStudentIdEqualTo(studentId).andTermIsNull().andSchoolYearEqualTo(schoolYear);
		
		deleteByExample(example);
		saveBySchoolYearAndTerm(schoolYear, term, studentId);
		saveBySchoolYear(schoolYear, studentId);
		saveAll(studentId);
	}


	public List<ResultsStatistical> findByExample(ResultsStatisticalExample example) {
		
		return resultsStatisticalMapper.selectByExample(example);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
