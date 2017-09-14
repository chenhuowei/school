package com.fireway.sys.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fireway.base.BaseController;
import com.fireway.entity.Dictionary;
import com.fireway.entity.DictionaryExample;
import com.fireway.entity.GradeSchoolYear;
import com.fireway.sys.service.DictionaryService;
import com.fireway.sys.service.GradeSchoolYearService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	@Resource
	private DictionaryService dictionaryService;
	@Resource
	private GradeSchoolYearService gradeSchoolYearService;

	@RequestMapping("/dictionaryPage.do")
	public String toPage() {
		
		return "admin/dictionaryPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(Dictionary record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			dictionaryService.save(record);
			if ("grade".equalsIgnoreCase(record.getType())){
				List<String> list = Utils.getSchoolYearByGrade(record.getValue());
				if (null != list && list.size() >0){
					
					for (int i=0;i<4;i++){
						GradeSchoolYear gsYear = new GradeSchoolYear();
						gsYear.setId(Utils.uuid());
						gsYear.setGrade(record.getValue());
						gsYear.setSchoolYear(list.get(i));
						gradeSchoolYearService.save(gsYear);
					}
				}
				
			}
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
			if (StringUtils.isNotBlank(ids)){
				String[] arr = ids.split(",");
				for (String id : arr){
					Dictionary dictionary = dictionaryService.findById(id);
					if ("grade".equals(dictionary.getType())){
						gradeSchoolYearService.deleteByGade(dictionary.getValue());
					}
					dictionaryService.deleteById(id);
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
	public Object update(Dictionary record) {
		try {
			record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
			DictionaryExample example = new DictionaryExample();
			example.createCriteria().andIdEqualTo(record.getId());
			dictionaryService.updateByExample(record, example);
			if ("grade".equalsIgnoreCase(record.getType())){
				gradeSchoolYearService.deleteByGade(record.getValue());
				List<String> list = Utils.getSchoolYearByGrade(record.getValue());
				if (null != list && list.size() >0){
					
					for (int i=0;i<4;i++){
						GradeSchoolYear gsYear = new GradeSchoolYear();
						gsYear.setId(Utils.uuid());
						gsYear.setGrade(record.getValue());
						gsYear.setSchoolYear(list.get(i));
						gradeSchoolYearService.save(gsYear);
					}
				}
				
			}
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/findById.do",method=RequestMethod.GET)
	public Object findById(String id) {
		try {
			if (StringUtils.isNotBlank(id)){
				return jsonUtil.loadDataSuccess(true, dictionaryService.findById(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return jsonUtil.loadDataSuccess(false, null);
	}

	@ResponseBody
	@RequestMapping(value="/findByPage.do",method=RequestMethod.GET)
	public Object findByPage(int page, int limit, String keyWord) {
		
		DictionaryExample example = new DictionaryExample();
		if (StringUtils.isNotBlank(keyWord)){
			String value = StringUtils.addLikeStr(keyWord);
			example.or().andTypeLike(value);
			example.or().andNameLike(value);
			example.or().andValueLike(value);
		}
		
		return dictionaryService.findByPage(page, limit, example);
	}

	@ResponseBody
	@RequestMapping("/findByType.do")
	public Object findByType(int page,int limit,String type){
		
		if (StringUtils.isNotBlank(type)){
			return dictionaryService.findByType(page, limit, type);
		}
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/findTreeList.do")
	public Object findTreeList(String type){
		
		if (StringUtils.isNotBlank(type)){
			return dictionaryService.findTreeList(type);
		}
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/findByGrade.do")
	public Object findByGrade(String grade,HttpServletRequest request){
		
		request.getSession().setAttribute("schoolYearAtNow", Utils.getSchoolYearAtNow());
		request.getSession().setAttribute("termAtNow", Utils.getTermAtNow());
		
		return gradeSchoolYearService.findByGrade(grade);
	}
	
	@RequestMapping("/exportToExcel.do")
	public void exportToExcel(HttpServletResponse response, String ids) {
	}

	@ResponseBody
	@RequestMapping("/importFromExcel.do")
	public Object importFromExcel(MultipartFile file) {
		
		return null;
	}

}
