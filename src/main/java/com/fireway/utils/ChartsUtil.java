package com.fireway.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartsUtil {
	//data list<map>
	/**
	"caption": "Monthly",
    "xaxisname": "Month",
    "yaxisname": "Revenue",
    "numberprefix": "$",
    */
	
	public static Map<String, Object> getChartsJson(String caption, String xaxisname, String yaxisname, 
			String numberprefix, String numbersuffix,String showvalues,String animation,
			String subCaption,List<Map<String, Object>> data
			) {
		Map<String, Object> chartMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		chartMap.put("caption", caption);
		chartMap.put("subCaption", subCaption);
		chartMap.put("xaxisname", xaxisname);
		chartMap.put("yaxisname", yaxisname);
		chartMap.put("numberprefix", numberprefix);
		chartMap.put("numbersuffix", numbersuffix);
		chartMap.put("showvalues", showvalues);
		chartMap.put("animation", animation);
		listMap.put("chart",chartMap);
		listMap.put("data", data);
		
		
		return listMap;
		
	}
	
	
	
	
	
}
