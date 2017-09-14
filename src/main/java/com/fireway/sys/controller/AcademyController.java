package com.fireway.sys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.fireway.entity.Academy;
import com.fireway.entity.AcademyExample;
import com.fireway.entity.AcademyExample.Criteria;
import com.fireway.sys.service.AcademyService;
import com.fireway.utils.BeanAndMapUtil;
import com.fireway.utils.ContantsUtil;
import com.fireway.utils.DateUtil;
import com.fireway.utils.ExportToExcelUtil;
import com.fireway.utils.ImportFromExcelUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
public class AcademyController {

	@Resource
	private AcademyService academyService;
	
	@RequestMapping("/academy/academyPage.do")
	public String toAcademyPage(){
		
		return "admin/academyPage";
	}
	
	@ResponseBody
	@RequestMapping(value="/academy/save.do",method=RequestMethod.POST)
	public Object save(Academy a){
		
		try {
			a.setId(Utils.uuid());
			a.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			academyService.saveAcademy(a);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}
	
	@ResponseBody
	@RequestMapping(value="/academy/delete.do",method=RequestMethod.POST)
	public Object delete(String ids){
		
		try {
			if (StringUtils.isNotBlank(ids)){
				for(String id : ids.split(",")){
					academyService.deleteyId(id);
				}
			}
			return jsonUtil.deleteSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.deleteSuccess(false);
	}
	
	@ResponseBody
	@RequestMapping(value="/academy/update.do",method=RequestMethod.POST)
	public Object update(Academy a){
		
		try {
			a.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
			AcademyExample example = new AcademyExample();
			example.createCriteria().andIdEqualTo(a.getId());
			academyService.updateByExample(a, example);
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(false);
	}
	
	@ResponseBody
	@RequestMapping(value="/academy/findById.do",method=RequestMethod.GET)
	public Object findById(String id){
		try {
			Academy data = null;
			if (StringUtils.isNotBlank(id)){
				 data = academyService.findById(id);
			}
			return jsonUtil.loadDataSuccess(true, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.loadSuccess(false);
	}
	
	@ResponseBody
	@RequestMapping(value="/academy/findByPage.do",method=RequestMethod.GET)
	public Object findByPage(int page, int limit,String keyWord){
		try {
			AcademyExample example = new AcademyExample();
			Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(keyWord)){
				String value = StringUtils.addLikeStr(keyWord);
				example.or().andCodeLike(value);
				example.or().andNameLike(value);
				example.or().andHeadLike(value);
				example.or().andOfficAddressLike(value);
				example.or().andOfficTelLike(value);
			}
			return academyService.findByPage(page, limit, example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/academy/isRepeat.do")
	public Object isRepeat(String code){
		boolean b = true;
		if (StringUtils.isNotBlank(code)){
			b = academyService.isRepeat(code);
		}
		if (!b){
			return jsonUtil.newJson("success", true);
		}
		return jsonUtil.newJson("success", false);
		
		
	}
	
	@RequestMapping("/academy/exportToExcel.do")
	public void exportToExcel(HttpServletResponse response){
		
		try {
			List<Academy> list = academyService.findByExample(null);
			BeanAndMapUtil beanAndMapUtil = new BeanAndMapUtil();
			List<Map<String, Object>> listMap = beanAndMapUtil.listMap(list);
			ExportToExcelUtil.exportView(response, listMap, 
					ContantsUtil.academyColumnNames, ContantsUtil.academyPropertys, "学院信息");
		} catch (Exception e) {
			
			
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/academy/importFromExcel.do")
	public Object importFromExcel(@RequestParam(value = "uploadFile", required = true)MultipartFile file){
		
		try {
			List<Map<String, Object>> listMap = ImportFromExcelUtil.exportListFromExcel(file, 0,
					ContantsUtil.academyColumnNames,ContantsUtil.academyPropertys);
			Academy academy = null;
			for(Map<String, Object> map : listMap){
				academy = new Academy();
				academy = (Academy) BeanAndMapUtil.map2Bean(map, academy);
				academy.setId(Utils.uuid());
				academy.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
				academyService.saveAcademy(academy);
			}
			
			return jsonUtil.excelSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.excelSuccess(false);
		
	}
	
	@ResponseBody
	@RequestMapping("/academy/findIdnName.do")
	public Object findIdnName(int page,int limit,String keyWord){
		AcademyExample example = new AcademyExample();
		if (StringUtils.isNotBlank(keyWord)){
			example.createCriteria().andNameLike(StringUtils.addLikeStr(keyWord));
		}
		
		return academyService.findIdnName(page, limit, example);
	}
	
	
	@ResponseBody
	@RequestMapping("/academy/treeList.do")
	public Object list(){
		
		
		
		
		return academyService.findTreeList(null);
	}
	
	
	
	
	
}
