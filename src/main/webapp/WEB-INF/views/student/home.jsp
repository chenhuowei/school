<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
   <title>学生中心</title>
   <jsp:include page="/bostrapPath.jsp"></jsp:include>
</head>
<body>
   			
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
   <div>
      <ul class="nav navbar-nav">
         <li class="active">
         	<a onclick="loadPageFun('schoolMessage/findMessage.do')">
         		Home</a></li>
         
         
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              	 信息维护 <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
               <li>
               		<a onclick="loadPageFun('student/personalPage.do')">
               			个人信息</a></li>
               <li class="divider"></li>
               <li><a onclick="loadPageFun('student/passwordPage.do')">密码更改</a></li>
               <li class="divider"></li>
            </ul>
           
         </li>
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              	 信息查询 <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
               <li><a onclick="loadPageFun('student/syllabusPage.do?type=class')">
               			专业课课表</a></li>
               <li class="divider"></li>
               <li><a onclick="loadPageFun('student/syllabusPage.do?type=student')">
               			个人课表</a></li>
               <li class="divider"></li>
               <li><a onclick="loadPageFun('student/scorePage.do')">
               			成绩查询</a></li>
               <li class="divider"></li>
               <li><a onclick="loadPageFun('student/testPage.do')">考试查询</a></li>
               <li class="divider"></li>
               <li><a onclick="loadPageFun('student/studentSelectPage.do')">选课查询</a></li>
               <li class="divider"></li>
            </ul>
            
         </li>
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              	 报名入口 <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
               <li><a onclick="loadPageFun('student/enrollTestPage.do')">考试报名</a></li>
               <li class="divider"></li>
               <li><a onclick="loadPageFun('student/selectSubjectPage.do')">公共选课</a></li>
               <li class="divider"></li>
            </ul>
         </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
			<li><a>当前用户:${user.studentNum }</a></li>
			
	         <li>
					    <button type="button" class="btn btn-info btn-lg dropdown-toggle" 
					    data-toggle="dropdown">${user.name }
					        <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu" role="menu">
					        <li>
					            <a href="#">信息</a>
					        </li>
					        
					        <li class="divider"></li>
					        <li>
					            <a onclick="logout()">退出</a>
					        </li>
					    </ul>
	         
	         </li>
	 </ul>
   </div>
</nav>
   		
	<!--display  panel  -->>
	
		<div class="panel panel-info">
		    <div class="panel-heading">
		    	 
		    </div>
		    <div class="panel-body" id="container" style="margin:15px">
			      
			    </div>
		</div>



<script type="text/javascript">
$(function(){
	
	$("#container").load("${pageContext.request.contextPath}/schoolMessage/findMessage.do");
})

var loadPageFun = function(url){
	$("#container").load(basePath+url);
}

function logout(){
	$.ajax({
		type:'get',
		url:basePath+'common/logout.do',
		data:{},
		success:function(data){
			top.location.href = basePath+'common/loginIndex.do';
		}
	})
}
</script>	
	
	
	
	
</body>
</html>