package com.fireway.sys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.entity.ScoreRecord;
import com.fireway.entity.ScoreRecordExample;
import com.fireway.entity.ScoreRecordExample.Criteria;
import com.fireway.entity.SelectSubject;
import com.fireway.entity.Subject;
import com.fireway.entity.SubjectArrangement;
import com.fireway.sys.service.DictionaryService;
import com.fireway.sys.service.ResultsStatisticalService;
import com.fireway.sys.service.ScoreRecordService;
import com.fireway.sys.service.SelectSubjectService;
import com.fireway.sys.service.SubjectArrangementService;
import com.fireway.sys.service.SubjectService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/scoreRecord")
public class ScoreRecordController {

	@Resource
	private ScoreRecordService scoreRecordService;
	@Resource
	private SubjectService subjectService;
	@Resource
	private SubjectArrangementService subjectArrangementServie;
	@Resource
	private DictionaryService dictionaryService;
	@Resource
	private ResultsStatisticalService resultsStatisticalService;
	@Resource
	private SelectSubjectService selectSubjectSerivce;
	
	@RequestMapping("/scoreRecordPage.do")
	public String toPage() {
		
		return null;
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(ScoreRecord record,
			@RequestParam(required=false)String subjectArrangementId,
			@RequestParam(required=false)String selectSubjectId) {
		try {
			double totalScore =0.00;
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			if (StringUtils.isNotBlank(subjectArrangementId)){
				SubjectArrangement subjectArrangement = subjectArrangementServie.findById(subjectArrangementId);
				if (StringUtils.isNotBlank(subjectArrangement.getSubjectId())){
					Subject subject = subjectService.findById(subjectArrangement.getSubjectId());
					record.setSubjectIsRequired(subject.getIsRequest());
				 totalScore =Utils.countTotalScoreByScale(scale(record.getSubjectIsRequired()), 
							record.getCommonScore(), record.getTestScore());
					record.setSubjectCode(subject.getCode());
					if (totalScore >= 60){
						record.setSubjectCredits(subject.getCredits());
					}
					if (null != record.getRebuildScore() &&record.getRebuildScore() >= 60){
						record.setSubjectCredits(subject.getCredits());
					}
					record.setSubjectName(subject.getSubjectName());
					record.setSubjectVolumes(subject.getVolumes());
				}
				
				record.setTotalScore(totalScore);
				record.setPoint(Utils.scoreToPoint(totalScore));
				if (record.getIsRebuild()&&record.getRebuildScore()>=60){
					record.setPoint(1.0);
				}
				
			}
			if (StringUtils.isNotBlank(selectSubjectId)){
				SelectSubject selectSubject = selectSubjectSerivce.findById(selectSubjectId);
				record.setSubjectName(selectSubject.getSubjectName());
				record.setSubjectCode(selectSubject.getSubjectCode());
				 totalScore =Utils.countTotalScoreByScale(scale(false), 
							record.getCommonScore(), record.getTestScore());
				 record.setTotalScore(totalScore);
					record.setPoint(Utils.scoreToPoint(totalScore));
					if (record.getIsRebuild()&&record.getRebuildScore()>=60){
						record.setPoint(1.0);
					}	
					
			}
			scoreRecordService.save(record);
			//result
			resultsStatisticalService.saveAndReset(record.getSchoolYear(), record.getTerm(), record.getStudentId());
			return jsonUtil.saveSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonUtil.saveSuccess(true);
	}

	private String scale(boolean required){
		String requiredScale = "";
		String commonScale = "";
		List<Map<String, String>> maps = dictionaryService.findByType(1, 10, "scoreScale");
		for (int i = 0; i < maps.size(); i++) {
			Map<String , String> map = maps.get(i);
			if ("required".equals(map.get("name"))){
				
				requiredScale = map.get("value");
			}
			if ("common".equals(map.get("name"))){
				
				commonScale = map.get("value");
			}
			
		}
		if (required){
			return requiredScale;
		}else{
			return commonScale;
		}
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
	public Object delete(String ids) {
		try {
			if (StringUtils.isNotBlank(ids)){
				String[] value = ids.split(",");
				for (String id : value){
					scoreRecordService.delete(id);
				}
				return jsonUtil.deleteSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.deleteSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public Object update(ScoreRecord record,@RequestParam(required=false)String selectSubjectId,
			@RequestParam(required=false)String subjectArrangementId) {
		try {
			record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
			double totalScore = 0.00;
			if (StringUtils.isNotBlank(subjectArrangementId)){
				SubjectArrangement subjectArrangement = subjectArrangementServie.findById(subjectArrangementId);
				if (StringUtils.isNotBlank(subjectArrangement.getSubjectId())){
					Subject subject = subjectService.findById(subjectArrangement.getSubjectId());
					record.setSubjectIsRequired(subject.getIsRequest());
					totalScore =Utils.countTotalScoreByScale(scale(record.getSubjectIsRequired()), 
							record.getCommonScore(), record.getTestScore());
					record.setSubjectCode(subject.getCode());
					if (totalScore >= 60){
						record.setSubjectCredits(subject.getCredits());
					}else {
						record.setSubjectCredits(0.00);
					}
					if (null != record.getRebuildScore()&&record.getRebuildScore() >= 60){
						record.setSubjectCredits(subject.getCredits());
					}
					record.setSubjectName(subject.getSubjectName());
					record.setSubjectVolumes(subject.getVolumes());
				}
				
				record.setTotalScore(totalScore);
				record.setPoint(Utils.scoreToPoint(totalScore));
				if (record.getIsRebuild()&&record.getRebuildScore()>=60){
					record.setPoint(1.0);
				}
				
			}
			if (StringUtils.isNotBlank(selectSubjectId)){
				SelectSubject selectSubject = selectSubjectSerivce.findById(selectSubjectId);
				record.setSubjectName(selectSubject.getSubjectName());
				record.setSubjectCode(selectSubject.getSubjectCode());
				 totalScore =Utils.countTotalScoreByScale(scale(false), 
							record.getCommonScore(), record.getTestScore());
				 record.setTotalScore(totalScore);
					record.setPoint(Utils.scoreToPoint(totalScore));
					if (record.getIsRebuild()&&record.getRebuildScore()>=60){
						record.setPoint(1.0);
					}	
					
			}
			scoreRecordService.updateSelectById(record);
			//result
			resultsStatisticalService.saveAndReset(record.getSchoolYear(), record.getTerm(), record.getStudentId());
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(false);
	}

	@ResponseBody
	@RequestMapping("/findById.do")
	public Object findById(String id) {
		if (StringUtils.isNotBlank(id)){
			return jsonUtil.loadDataSuccess(true, scoreRecordService.findById(id));
		}
		return jsonUtil.loadDataSuccess(false, null);
	}
	
	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit, String keyWord,String studentId,
			@RequestParam(required=false)String schoolYear,@RequestParam(required=false)Integer term) {
		ScoreRecordExample example = new ScoreRecordExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(keyWord)){
			String[] keys = keyWord.split("[,，]");
			for (String key : keys){
				String value = StringUtils.addLikeStr(key);
				example.or().andSubjectNameLike(value).andStudentIdEqualTo(studentId);
			}
		}else {
			criteria.andStudentIdEqualTo(studentId);
			if (StringUtils.isNotBlank(schoolYear)){
				criteria.andSchoolYearEqualTo(schoolYear);
			}
			if (null != term && term != 0){
				criteria.andTermEqualTo(term);
			}
		}
		
		return scoreRecordService.findByPage(page, limit, example);
	}

	public Object isRepeat(String key) {
		
		return null;
	}

}
