package com.fireway.sys.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.sys.service.EmploymentRateService;
import com.fireway.utils.BarCharts;
import com.fireway.utils.ChartsUtil;
import com.fireway.utils.LineCharts;

@Controller
@RequestMapping("/charts")
public class ChartsController {

	@Resource
	private EmploymentRateService employmentRateService;
	
	
	@RequestMapping("/chartsPage.do")
	public String  chartsPage() {
		
		
		return "charts/chartsPage";
	}
	
	
	@ResponseBody
	@RequestMapping("/getBarChartsJson.do")
	public Object getBarChartsJson(){
		BarCharts barCharts = new BarCharts("fireway就业率统计", "2016", "学院名称",
				"就业率", "", "%",employmentRateService.statistics("2016"));
		barCharts.setyAxisMaxValue("100");
		return barCharts.getBarCharsJson();
	}
	
	@ResponseBody
	@RequestMapping("/getLineChartsJson.do")
	public Object getLineChartsJson(){
		
		LineCharts lineCharts = new LineCharts("学院年度毕业率", "折线图", "年份", "毕业率",
				"", "%");
		lineCharts.addCategories(employmentRateService.selectGraduationYear());
		lineCharts.addDataSet("数学", employmentRateService.selectRateByAcademy("数学"));
		lineCharts.addDataSet("物理", employmentRateService.selectRateByAcademy("物理"));
		lineCharts.setyAxisMaxValue("100");
		lineCharts.setyAxisValuesStep("1");
		lineCharts.setNumDivLines("9");
		
		return lineCharts.getLneChartsJson();
	}
	
	
	
	
	
}
