<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%  
        String path = request.getContextPath();  
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
var basePath = '<%=basePath %>';
</script>
<link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
   <script src="${pageContext.request.contextPath }/bootstrap/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath }/bootstrap/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath }/bootstrap/bootstrapUtils.js"></script>
   <script src="${pageContext.request.contextPath }/bootstrap/bootstrap3-validation.js"></script>
   
   
   <!-- js 中有错，
   	修改 ：
    this.defaultTimeZone=(new Date()).toString().split("(")[1].slice(0,-1);
	为
	this.defaultTimeZone='GMT '+(new Date()).getTimezoneOffset()/60
	即可
	选修：
	如果使用了fa字体，则会报错，系统中会检测不到fontAwesome，所以可以直接赋这个变量为true：
    this.fontAwesome=k.fontAwesome||this.element.data("font-awesome")||false;
	为
    this.fontAwesome=true
    -->
<link href="${pageContext.request.contextPath }/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet">
   <script src="${pageContext.request.contextPath }/bootstrap/bootstrap-datetimepicker.min.js"
   charset="UTF-8"></script>
   <script src="${pageContext.request.contextPath }/bootstrap/bootstrap-datetimepicker.zh-CN.js"></script>
 </head>
</html>