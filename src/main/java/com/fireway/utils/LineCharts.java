package com.fireway.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

public class LineCharts {
	
	private String caption = "";
	private String subCaption = "";
	private String xaxisname ="";
	private String yaxisname ="";
	private String numberprefix ="";
	private String numbersuffix ="";
	private String showvalues = "";
	private String animation = "1";
	private String yAxisMaxValue ="";
	private String yAxisMinValue = "";
	private String theme = "fint";
	private String numDivLines= "";
	private String yAxisValuesStep;
	private List<Map<String,Object>> dataset = new ArrayList<Map<String,Object>>();
	private List<Map<String,Object>> categories = new ArrayList<Map<String,Object>>();
	
	
	private Map<String, Object> chartMap = new HashMap<String, Object>();
	private Map<String, Object> listMap = new HashMap<String, Object>();
	
	
	
	public LineCharts(String caption, String subCaption, String xaxisname, String yaxisname, String numberprefix,
			String numbersuffix) {
		super();
		this.caption = caption;
		this.subCaption = subCaption;
		this.xaxisname = xaxisname;
		this.yaxisname = yaxisname;
		this.numberprefix = numberprefix;
		this.numbersuffix = numbersuffix;
	}

	public Map<String, Object> getLneChartsJson(){
		chartMap.put("caption", getCaption());
		chartMap.put("subCaption", getSubCaption());
		chartMap.put("xaxisname", getXaxisname());
		chartMap.put("yaxisname", getYaxisname());
		chartMap.put("numberprefix", getNumberprefix());
		chartMap.put("numbersuffix", getNumbersuffix());
		chartMap.put("showvalues", getShowvalues());
		chartMap.put("animation", getAnimation());
		chartMap.put("yAxisMaxValue", getyAxisMaxValue());
		chartMap.put("yAxisMinValue", getyAxisMinValue());
		chartMap.put("theme", getTheme());
		
		
		listMap.put("chart", chartMap);
		listMap.put("categories", categories);
		listMap.put("dataset", dataset);
		return listMap;
	}

	public void addDataSet(String seriesname,List<Map<String, Object>> data){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seriesname", seriesname);
		map.put("data", data);
		dataset.add(map);
	}
	
	public void addCategories(List<Map<String, Object>> cacategory){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("category", cacategory);
		categories.add(map);
	}
	
	
	public String getCaption() {
		return caption;
	}



	public String getyAxisValuesStep() {
		return yAxisValuesStep;
	}

	public void setyAxisValuesStep(String yAxisValuesStep) {
		this.yAxisValuesStep = yAxisValuesStep;
	}

	public String getNumDivLines() {
		return numDivLines;
	}

	public void setNumDivLines(String numDivLines) {
		this.numDivLines = numDivLines;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}



	public String getSubCaption() {
		return subCaption;
	}



	public void setSubCaption(String subCaption) {
		this.subCaption = subCaption;
	}



	public String getXaxisname() {
		return xaxisname;
	}



	public void setXaxisname(String xaxisname) {
		this.xaxisname = xaxisname;
	}



	public String getYaxisname() {
		return yaxisname;
	}



	public void setYaxisname(String yaxisname) {
		this.yaxisname = yaxisname;
	}



	public String getNumberprefix() {
		return numberprefix;
	}



	public void setNumberprefix(String numberprefix) {
		this.numberprefix = numberprefix;
	}



	public String getNumbersuffix() {
		return numbersuffix;
	}



	public void setNumbersuffix(String numbersuffix) {
		this.numbersuffix = numbersuffix;
	}



	public String getShowvalues() {
		return showvalues;
	}



	public void setShowvalues(String showvalues) {
		this.showvalues = showvalues;
	}



	public String getAnimation() {
		return animation;
	}



	public void setAnimation(String animation) {
		this.animation = animation;
	}



	public String getyAxisMaxValue() {
		return yAxisMaxValue;
	}



	public void setyAxisMaxValue(String yAxisMaxValue) {
		this.yAxisMaxValue = yAxisMaxValue;
	}



	public String getyAxisMinValue() {
		return yAxisMinValue;
	}



	public void setyAxisMinValue(String yAxisMinValue) {
		this.yAxisMinValue = yAxisMinValue;
	}



	public String getTheme() {
		return theme;
	}



	public void setTheme(String theme) {
		this.theme = theme;
	}





	

	



	
	
	
	
	
	
	

}
