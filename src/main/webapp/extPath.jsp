<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<script src="<%=basePath %>extjs5/jquery.min.js"></script>
<script src="<%=basePath %>extjs5/ext-all.js"></script>
<script src="<%=basePath %>extjs5/packages/ext-locale/build/ext-locale-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath %>extjs5/utils.js"></script>
<script type="text/javascript" src="<%=basePath %>extjs5/vaild.js"></script>

<link href="<%=basePath %>extjs5/packages/ext-theme-neptune/build/resources/ext-theme-neptune-all.css" rel="stylesheet" />
 </head>
</html>