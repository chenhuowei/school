<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<script type="text/javascript">
var messagePanel = Ext.create('Ext.panel.Panel', {
    bodyPadding: 5,  // 避免Panel中的子元素紧邻边框
   
    //border: true,
    renderTo:Ext.getBody(),
    collapsible: true,
    title: '公告栏',
    html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" '
     	+' src="${pageContext.request.contextPath}/schoolMessage/findMessage.do" '
     	+' ></iframe>' ,
     	tbar: [
     	      { xtype: 'button', text: '刷新',
					handler:function(){
						var  html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" '
					     	+' src="${pageContext.request.contextPath}/schoolMessage/findMessage.do" '
					     	+' ></iframe>';
					     	messagePanel.update(html);
					}
     	      }
     	    ]
    
});
	
		
		
		
		
		
</script>
</body>
</html>