<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>

<div class="container">
   
			<div id="selectTip" align="center" style="position: fixed;
top: 180px;left: 300px;z-index:999;width: 800px"></div>
   
   <div class="row" >
   		<div class="col-md-12">
   			
			<table class="table table-hover" id="selectSubject">
			</table>
   		
		</div>
	</div>
   <div class="row" >
	   	<div class="col-md-12">
		   	 <div class="progress">
			    <div class="progress-bar progress-bar-info" role="progressbar"
			         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			         style="width: 100%;">
			    </div>
			</div>
		</div>
	</div>
  
   <div class="row" >
   		<div class="col-md-12">
   			
			<table class="table table-hover" id="selectOk">
			</table>
   		
		</div>
	</div>
  
  
  
  
</div>
<script src="${pageContext.request.contextPath }/bootstrap/utils/grid.js"></script>
<script type="text/javascript">
	
	$(function(){
		loadSelectData(1);
		loadSelectOkData(1);
	})
	
	var attrs = ['schoolYear','term','subjectCode','subjectName','teacherName',
	            'locationName','startTime','endTime','classTime','classWeek',
	            'capacity','catagory'];
	var headers = ['学年','学期','科目代码',
	            '科目名称','教师名称','上课地点','开始时间','结束时间',
	            '上课时间','上课星期','容量','科目类型'];
	var title = '选课信息列表';
	var saveBtn = {'funName':'saveSelect','params':'id','class':'btn-primary','display':'选择'}
	var btns = [saveBtn];
	
	var grid = new Grid('selectSubject',title,headers,attrs,btns);
	function loadSelectData(pageNum){
		$.ajax({
			type:'get',
			url:basePath+'student/getSelectSubject.do',
			data:{'page':pageNum,'limit':5},
			success:function(data){
				grid.datas = data;
				grid.loadFun = loadSelectData;
				grid.renderData();
			},
			error:function(){
				alert('请求异常,请稍后再次尝试...')
			}
		})
	}
	
	function saveSelect(id){
		$.ajax({
			type:'post',
			url:basePath+'student/saveStudentSelectSubject.do',
			data:{'selectSubjectId':id,'studentId':'${user.id}'},
			success:function(data){
				if (data.success){
					loadSelectOkData(1);
				}
				alertTip('selectTip',data.success,data.message);
			},
			error:function(){
				alert('请求异常,请稍后再次尝试...')
			}
		})
	}
// select ok and exit subject	

	var title2 = '已选科目列表';
	var deleteBtn = {'funName':'deleteSelect','params':'id,status','class':'btn-warning','display':'退选'}
	var btns2 = [deleteBtn];
	
	var gridOk = new Grid('selectOk',title2,headers,attrs,btns2);
	function loadSelectOkData(pageNum){
		$.ajax({
			type:'get',
			url:basePath+'student/getStudentSelectSubject.do',
			data:{'page':pageNum,'limit':5,'studentId':'${user.id}'},
			success:function(data){
				gridOk.datas = data;
				gridOk.loadFun = loadSelectOkData;
				gridOk.renderData();
			},
			error:function(){
				alert('请求异常,请稍后再次尝试...')
			}
		})
	}
	
	
	function deleteSelect(id,status){
			$.ajax({
				type:'get',
				url:basePath+'student/deleteStudentSelectSubject.do',
				data:{'selectSubjectId':id,'studentId':'${user.id}'},
				success:function(data){
					if (data.success){
						loadSelectOkData(1);
					}
					alertTip('selectTip',data.success,data.message);
				},
				error:function(){
					alert('请求异常,请稍后再次尝试...')
				}
			})
	}
	
</script>


</body>
</html>