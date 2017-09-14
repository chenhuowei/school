<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FINDMESSAGE</title>
</head>
<body>

		<c:forEach items="${schoolMessages }" var="sms">
			<h3 align="center">${sms.title }</h3>
			<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sms.context }</span>
			<p align="right" style="color:gray">发布时间:${sms.sendTime }</p>
		</c:forEach>	


</body>
</html>