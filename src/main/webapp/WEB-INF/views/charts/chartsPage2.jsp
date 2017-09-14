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
    var revenueChart = new FusionCharts({
      "type": "column2d",
      "renderAt": "chartContainer",
      "width": "500",
      "height": "300",
      "dataFormat": "json",
      "dataSource": {
        "chart": {
            "caption": "Test json",
            "subCaption": "FIREWAY ",
            "xAxisName": "月份",
            "yAxisName": "工资层",
            "theme": "fint",
            "numberprefix": "￥",
            "showvalues": "1",
            "animation": "0.5"
         },
        "data": [
            {
               "label": "Jan",
               "value": "420000"
            },
            {
               "label": "Feb",
               "value": "810000"
            },
            {
               "label": "Mar",
               "value": "720000"
            },
            {
               "label": "Apr",
               "value": "550000"
            },
            {
               "label": "May",
               "value": "910000"
            },
            {
               "label": "Jun",
               "value": "510000"
            },
            {
               "label": "Jul",
               "value": "680000"
            },
            {
               "label": "Aug",
               "value": "620000"
            },
            {
               "label": "Sep",
               "value": "610000"
            },
            {
               "label": "Oct",
               "value": "490000"
            },
            {
               "label": "Nov",
               "value": "900000"
            },
            {
               "label": "Dec",
               "value": "730000"
            }
         ],
         "trendlines": [{
             "line": [{
                 "startvalue": "800000",
                 "istrendzone": "1",
                 "valueonright": "1",
                 "tooltext": "达标线",
                 "endvalue": "1000000",
                 "color": "009933",
                 "displayvalue": "目标线",
                 "showontop": "1",
                 "thickness": "1"
             }]
         }]
      }
  });

  revenueChart.render();
  
    var myChart = new FusionCharts({
        "type": "column2d",
        "renderAt": "chartContainer2",
        "width": "500",
        "height": "300",
        "dataFormat": "xml",
        "dataSource": "<chart caption='Harrys SuperMart' subcaption='tEST XML' xaxisname='Month' yaxisname='Amount' numberprefix='$' palettecolors='#008ee4' bgalpha='0' borderalpha='20' canvasborderalpha='0' theme='fint' useplotgradientcolor='0' plotborderalpha='10' placevaluesinside='1' rotatevalues='1' valuefontcolor='#ffffff' captionpadding='20' showaxislines='1' axislinealpha='25' divlinealpha='10'><set label='Jan' value='420000' /><set label='Feb' value='810000' /><set label='Mar' value='720000' /><set label='Apr' value='550000' /><set label='May' value='910000' /><set label='Jun' value='510000' /><set label='Jul' value='680000' /><set label='Aug' value='620000' /><set label='Sep' value='610000' /><set label='Oct' value='490000' /><set label='Nov' value='900000' /><set label='Dec' value='730000' /></chart>"
      });

    myChart.render();
  
  
})
</script>




</body>
</html>