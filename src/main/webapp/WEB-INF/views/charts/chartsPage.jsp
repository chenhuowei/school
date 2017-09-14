<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FUSIONCHARTS</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/fusioncharts/fusioncharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/fusioncharts/fusioncharts.theme.fint.js"></script>
</head>
<body>

 <div id="chartContainer"></div>
 <div id="chartContainer2"></div>

<script type="text/javascript">
FusionCharts.ready(function(){
	 var myChart = new FusionCharts({
	        "type": "column2d",
	        "renderAt": "chartContainer",
	        "width": "500",
	        "height": "300",
	        "dataFormat": "jsonurl",
	        "dataSource": "${pageContext.request.contextPath}/charts/getBarChartsJson.do"
	    });
	    myChart.render();
	 var myChart2 = new FusionCharts({
	        "type": "msline",
	        "renderAt": "chartContainer2",
	        "width": "500",
	        "height": "350",
	        "dataFormat": "jsonurl",
	        "dataSource": "${pageContext.request.contextPath}/charts/getLineChartsJson.do"
	    });
	    myChart2.render();
  
})
</script>




</body>
</html>