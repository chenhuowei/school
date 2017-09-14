<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>

<div class="container">
   
   <div class="row" >
   		<div class="col-md-12">
   			
			<table class="table table-hover " id="enrollTestTable">
			  <caption><strong>
			  	<button type="button" class="btn btn-info btn-block">考试信息列表</button>
			  </strong></caption>
			  <thead>
			    <tr>
			      <th>操作选项</th>
			      <th>考试代码</th>
			      <th>考试名称</th>
			      <th>考试时间</th>
			      <th>考试费用</th>
			      <th>报名开始时间</th>
			      <th>报名结束时间</th>
			      <th>备注</th>
			    </tr>
			  </thead>
			  <tbody id="enrollTestTbody">
			    
			  </tbody>
			   
			</table>
   		
		</div>
	</div>
   <div class="row" >
	   	<div class="col-md-12">
			<form role="form" id="enrollPage"></form>
		</div>
	</div>
   <div class="row" >
	   	<div class="col-md-12">
			<div id="enrollTip" align="center" style="position: fixed;
top: 480px;left: 300px;z-index:999;width: 800px"></div>
		</div>
	</div>
   <div class="row" >
   		<div class="col-md-12">
   			
			<table class="table table-hover table-bordered" id="enrollOkTable">
			   <caption><strong>
			  	<button type="button" class="btn btn-success btn-block">报名成功列表</button>
			  </strong></caption>
			  <thead>
			    <tr>
			      <th>操作选项</th>
			      <th>考试代码</th>
			      <th>考试名称</th>
			      <th>准考证号</th>
			      <th>报名成功</th>
			      <th>缴费成功</th>
			      <th>备注</th>
			    </tr>
			  </thead>
			  <tbody id="enrollOkTbody">
			    
			    
			  </tbody>
			</table>
			 <form role="form" id="enrollOkPage"></form>
   		
		</div>
	</div>
  
  
  
  
</div>
<script src="${pageContext.request.contextPath }/bootstrap/pagination.js"></script>
<script type="text/javascript">

	$(function(){
		
		loadEnrollTestData(1);
		loadEnrollOkData(1);
		
	})
	
	function loadEnrollTestData(pageNum){
		$.ajax({
			type:'get',
			url : basePath+'student/getTestRecord.do',
			data:{'page':pageNum,'limit':5},
			success:function(data){
				createEnrollTestTable(data);
				paginationFun('enrollPage',data.pageNum,data.pages,data.total,loadEnrollTestData);
			},
			error:function(){
				alert('请求异常，请稍后再次尝试...');
			}
		})
	}
	function createEnrollTestTable(datas){
		var id = '#enrollTestTbody';
		$(id).children().remove();
		var data = datas.rows;
		for (var i=0;i<data.length;i++){
			$(id).append('<tr>'+
					'<td><button type="button" onclick="enrollSaveFun('+"'"+data[i].id+"'"+')" class="btn btn-primary">报名</button></td>'+
					'<td>'+data[i].testCode+'</td>'+
					'<td>'+data[i].testName+'</td>'+
					'<td>'+data[i].testTime+'</td>'+
					'<td>'+data[i].money+'</td>'+
					'<td>'+data[i].regisStartTime+'</td>'+
					'<td>'+data[i].regisEndTime+'</td>'+
					'<td>'+data[i].remark+'</td>'+
					'</tr>');
		}
	
	}
	
	function enrollSaveFun(testId){
		$.ajax({
			type:'post',
			url:basePath+'student/saveStudentTest.do',
			data:{'testRecordId':testId,'studentId':'${user.id}',
					'page':1,'limit':5				
			},
			success:function(data){
				if (data.success){
					loadEnrollOkData(1);
					alertTip('enrollTip',data.success,data.message);
				}else{
					alertTip('enrollTip',data.success,data.message);
				}
			},
			error:function(){
				alert('请求异常，请稍后再次尝试...');
			}
		})
	}
	
	function enrollDelFun(testId){
		$.ajax({
			type:'GET',
			url:basePath+'student/deleteStudentTest.do',
			data:{'testRecordId':testId,'studentId':'${user.id}',
					'page':1,'limit':5},
			success:function(data){
				if (data.success){
					loadEnrollOkData(1);
					alertTip('enrollTip',data.success,data.message);
				}else{
					alertTip('enrollTip',data.success,data.message);
				}
			},
			error:function(){
				alert('请求异常，请稍后再次尝试...');
			}
		})
	}
	
// ok enroll test	
	function loadEnrollOkData(pageNum){
		$.ajax({
			type:'GET',
			url:basePath+'student/getStudentTest.do',
			data:{'studentId':'${user.id}',
					'page':pageNum,'limit':5},
			success:function(data){
				createEnrollOkTable(data);
				paginationFun('enrollOkPage',data.pageNum,data.pages,data.total,loadEnrollOkData);
			},
			error:function(){
				alert('请求异常，请稍后再次尝试...');
			}
		})
}
	
	function createEnrollOkTable(datas){
		var id = '#enrollOkTbody';
		$(id).children().remove();
		var data = datas.rows;
		for (var i=0;i<data.length;i++){
			$(id).append('<tr>'+
					'<td><button type="button" onclick="enrollDelFun('+"'"+data[i].testRecordId+"'"+')" class="btn btn-warning">退选</button></td>'+
					'<td>'+data[i].testCode+'</td>'+
					'<td>'+data[i].testName+'</td>'+
					'<td>'+data[i].testNum+'</td>'+
					'<td>'+(data[i].isRegisSuccess?'是':'否')+'</td>'+
					'<td>'+(data[i].isPayment?'是':'否')+'</td>'+
					'<td>'+(data[i].remark==null?'':data[i].remark)+'</td>'+
					'</tr>');
		}
	
	}
</script>







</body>
</html>