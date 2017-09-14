package com.fireway.sys.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.base.BaseController;
import com.fireway.entity.Subject;
import com.fireway.entity.SubjectExample;
import com.fireway.entity.SubjectExample.Criteria;
import com.fireway.request.dto.SubjectParam;
import com.fireway.sys.service.SubjectService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;
import com.sun.javafx.collections.MappingChange.Map;
@Controller
@RequestMapping("/subject")
public class SubjectController implements BaseController<Subject> {

	@Resource
	private SubjectService subjectService;
	
	@RequestMapping("/subjectPage.do")
	public String toPage() {
		
		return "admin/subjectPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(Subject record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			subjectService.save(record);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/delete.do",method=RequestMethod.POST)
	public Object delete(String ids) {
		try {
			if(StringUtils.isNotBlank(ids)){
				String[] arr = ids.split(",");
				for (String id : arr){
					subjectService.delete(id);
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
	public Object update(Subject record) {
		try {
			record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
			SubjectExample example = new SubjectExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(record.getId());
			subjectService.updateSelectByExample(record, example);
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
			return jsonUtil.loadDataSuccess(true, subjectService.findById(id));
		}
		return jsonUtil.loadDataSuccess(false, null);
	}
	
	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit,SubjectParam subjectParam) {
		
		SubjectExample example = new SubjectExample();
		String key = subjectParam.getKeyWord();
		if (StringUtils.isNotBlank(key)){
			String[] values = key.split("[,，]");
			for (String value : values){
				String val = StringUtils.addLikeStr(value);
				example.or().andCodeLike(val);
				example.or().andSubjectNameLike(val);
				example.or().andCategoryLike(val);
				example.or().andApplicationLike(val);
			}
		}
		
		return subjectService.findByPage(page, limit, example);
	}

	@ResponseBody
	@RequestMapping("/findIdAndNameByCategory.do")
	public Object findIdAndNameByCategory(String category){
		if (StringUtils.isNotBlank(category)){
			return subjectService.findIdAndNameByCategory(category.trim());
		}
		return null;
	}
	
	
	@ResponseBody
	@RequestMapping("/isRepeat.do")
	public Object isRepeat(String code) {
		boolean b = subjectService.isRepeat(code);
		if (!b){
			return jsonUtil.newJson("success", true);
		}
		
		return jsonUtil.newJson("success", false);
	}

}
