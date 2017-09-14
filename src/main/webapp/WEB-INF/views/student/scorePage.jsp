<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<div class="container">
   <div class="row" >
	   <div class="col-md-12">
			<jsp:include page="selectPage.jsp"></jsp:include>
	   </div>
   </div>
   <div class="row" >
	   <div class="col-md-12">
	   		<div style="height: 50px"></div>
	   </div>
   </div>
   <div class="row" >
   	<div class="col-md-12">
		<div class="btn-toolbar" role="toolbar">
		<div class="btn-group">
			    <button type="button" class="btn btn-info" 
			    data-toggle="tooltip"  title="成绩排序" data-placement="top"
			    onclick="">成绩排序</button>
			    <button type="button" class="btn btn-info"
			    data-toggle="tooltip"  title="未通过成绩" data-placement="top"
			     onclick="noPassFun()">未通过成绩</button>
			    <button type="button" class="btn btn-info"
			     data-toggle="tooltip"  title="成绩统计" data-placement="top"
			     onclick="countScoreFun()">成绩统计</button>
			    <button type="button" class="btn btn-info"
			      data-toggle="tooltip"  title="打印" data-placement="top"
			    	onclick="alert('test')"
			    >打印</button>
			</div>
		</div>
		</div>
	</div>
   <div class="row" >
   		<div class="col-md-12">
			<div style="height: 30px"></div>
		</div>
	</div>
   <div class="row" >
   		<div class="col-md-12">
			<table class="table table-hover table-bordered" id="countScoreTable">
			  
			</table>
		</div>
	</div>
   <div class="row" >
   		<div class="col-md-12">
			<div style="height: 10px"></div>
		</div>
	</div>
   <div class="row" >
   		<div class="col-md-12">
   			
			<table class="table table-hover table-bordered" id="scoreTable">
			  <caption id="scoreTable_title"></caption>
			  <thead>
			    <tr>
			      <th>学年</th>
			      <th>学期</th>
			      <th>课程名称</th>
			      <th>课程代码</th>
			      <th>课程册序</th>
			      <th>课程属性</th>
			      <th>学分</th>
			      <th>成绩</th>
			      <th>绩点</th>
			      <th>重修</th>
			      <th>重修成绩</th>
			      <th>备注</th>
			    </tr>
			  </thead>
			  <tbody id="scoreTbody">
			    
			    
			  </tbody>
			</table>
   		
		</div>
	</div>
  
  
  
  
</div>


      



<script type="text/javascript">
var year = $('#selectYear').val();
var term = $('#selectTerm').val();
	$('#selectYear,#selectTerm').change(function(){
		year = $('#selectYear').val();
		 term = $('#selectTerm').val();
		loadScoreData('${user.id}',year,term,false);
	});

	$(function(){
		$("[data-toggle='tooltip']").tooltip(); 
		loadScoreData('${user.id}','${schoolYearAtNow}','${termAtNow}',false);
		
	})
	
function createScoreTbody(tbodyId,datas){
		$('#countScoreTable').children().remove();
		year = $('#selectYear').val();
		 term = $('#selectTerm').val();
		 $('#scoreTable_title').html('<strong>${user.academyName}-${user.className}-${user.name}'+
		 '&nbsp;&nbsp;'+year+'学年第'+term+'学期'+'成绩表</strong>');
		$('#'+tbodyId).children().remove();
		for (var i=0;i<datas.length;i++){
			var data = datas[i];
			var trCls = 'danger';
			if (data.point>=1){
				trCls = 'success';
			}
			$('#'+tbodyId).append(
			'<tr class="'+trCls+'">'+
				'<td>'+data.schoolYear+'</td>'+
				'<td>'+data.term+'</td>'+
				'<td>'+data.subjectName+'</td>'+
				'<td>'+data.subjectCode+'</td>'+
				'<td>'+data.subjectVolumes+'</td>'+
				'<td>'+(data.subjectIsRequired?'专业必修':'专业选修')+'</td>'+
				'<td>'+data.subjectCredits+'</td>'+
				'<td>'+data.totalScore+'</td>'+
				'<td>'+data.point+'</td>'+
				'<td>'+(data.isRebuild?'是':'否')+'</td>'+
				'<td>'+(data.rebuildScore==null?'':data.rebuildScore)+'</td>'+
				'<td>'+(data.remark==null?'':data.remark)+'</td>'+
			'</tr>'
			);
		}
	}	

function loadScoreData(studentId,schoolYear,term,noPass){
	$.ajax({
		type:'get',
		url:basePath+'student/getScoreRecord.do',
		data:{'studentId':studentId,
				'schoolYear':schoolYear,'term':term,
				'noPass':noPass
		},
		success:function(data){
			createScoreTbody('scoreTbody',data);
		},
		error:function(){
			alert('请求错误，请稍后再次尝试...');
		}
		
	})
}
	
function noPassFun(){
	loadScoreData('${user.id}',year,term,true);
}
	
function loadCountScoreData(){
	year = $('#selectYear').val();
	 term = $('#selectTerm').val();
	$.ajax({
		type:'get',
		url:basePath+'student/getResultsStatistical.do',
		data: {'studentId':'${user.id}','schoolYear':year,'term':term},
		success:function(data){
			createCountScoreTable('countScoreTable',data);
		},
		error:function(){
			
		}
	})
}

function createCountScoreTable(tableId,data){
	$('#'+tableId).children().remove();
	$('#'+tableId).append('<caption><strong>${user.academyName}-${user.className}-${user.name}'+
			 '&nbsp;&nbsp;'+year+'学年第'+term+'学期'+'成绩统计表</strong></caption>');
	$('#'+tableId).append('<thead><tr>'+
			'<th>学年</th>'+
			'<th>学期</th>'+
			'<th>总学分</th>'+
			'<th>总绩点</th>'+
			'<th>平均绩点</th>'+
			'<th>要求学分</th>'+
			'<th>要求平均绩点</th>'+
			'<th>备注</th>'+
			'</tr></thead>');
	for (var i=0;i<data.length;i++){
		$('#'+tableId).append('<tr>'+
				'<td>'+(data[i].schoolYear==null?'':data[i].schoolYear)+'</td>'+
				'<td>'+(data[i].term==null?'':data[i].term)+'</td>'+
				'<td>'+data[i].totalCredits+'</td>'+
				'<td>'+data[i].totalPoint+'</td>'+
				'<td>'+data[i].averagePoint+'</td>'+
				'<td>'+(data[i].requestCredits==null?'':data[i].requestCredits)+'</td>'+
				'<td>'+(data[i].requestAveragePoint==null?'':data[i].requestAveragePoint)+'</td>'+
				'<td>'+(data[i].remark==null?'':data[i].remark)+'</td>'+
				'</tr>');
	}
}
	
function countScoreFun(){
	loadCountScoreData();
}	
	
	
	
</script>
</body>
</html>