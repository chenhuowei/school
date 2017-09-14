<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>

<div id="studentSelectTip" align="center" style="position: fixed;
top: 480px;left: 300px;z-index:999;width: 800px"></div>
   
   <div class="row" >
   		<div class="col-md-12">
   			<jsp:include page="selectPage.jsp"  />
		</div>
	</div>
  
   <div class="row" >
   		<div class="col-md-12">
   			
			<table class="table table-hover" id="studentSelectTable">
			
			</table>
   		
		</div>
	</div>
  
<script src="${pageContext.request.contextPath }/bootstrap/utils/grid.js"></script>
<script type="text/javascript">
	
var year = $('#selectYear').val();
var term = $('#selectTerm').val();
	$('#selectYear,#selectTerm').change(function(){
		year = $('#selectYear').val();
		 term = $('#selectTerm').val();
		 loadStudentSelectData(1,year,term);
	});
	
	$(function(){
		loadStudentSelectData(1,year,term);
	})
	
	var attrs = ['schoolYear','term','subjectCode','subjectName','teacherName',
	            'locationName','startTime','endTime','classTime','classWeek',
	            'capacity','catagory'];
	var headers = ['学年','学期','科目代码',
	            '科目名称','教师名称','上课地点','开始时间','结束时间',
	            '上课时间','上课星期','容量','科目类型'];
	var title = '选课信息列表';
	
	var grid = new Grid('studentSelectTable',title,headers,attrs,null);
	function loadStudentSelectData(pageNum,schoolYear,term){
		$.ajax({
			type:'get',
			url:basePath+'student/studentSelectSubject.do',
			data:{'page':pageNum,'limit':5,'studentId':'${user.id}',
					'schoolYear':schoolYear,'term':term				
			},
			success:function(data){
				grid.datas = data;
				grid.loadFun = loadStudentSelectData;
				grid.renderData();
			},
			error:function(){
				alert('请求异常,请稍后再次尝试...')
			}
		})
	}
	
</script>



</body>
</html>