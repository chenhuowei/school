
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<jsp:include page="selectPage.jsp"></jsp:include>

	
	  
	  
<table class="table table-bordered" id="syllabusTable">

  
</table>
<input id="type" hidden value="${requestScope.type }">
	
<script type="text/javascript">

function loadSyllabusData(studentId,classId,schoolYear,term){
	
	clearTable('syllabusTable');
	createTable('syllabusTable');
	$.ajax({
		url:basePath+'student/syllabus.do',
		type:'get',
		data:{'studentId':studentId,'classId':classId,'schoolYear':schoolYear,'term':term},
		success:function(data){
			fillTable(data);
		},
		error:function(){
			alert('请求错误，请稍后再次尝试...');
		}
	})
}

$(function(){
	
	$('#selectYear,#selectTerm').change(
			function(){
				var classId = '${user.classId}';
				var schoolYear = $('#selectYear').val();
				var term = $('#selectTerm').val();
				var sid = '';
				if ($('#type').val() == 'student'){
					sid = '${user.id}';
				}
				loadSyllabusData(sid,classId,schoolYear,term);
			}	
	)
	var sid = '';
	if ($('#type').val() == 'student'){
		sid = '${user.id}';
	}
	loadSyllabusData(sid,'${user.classId}','${schoolYearAtNow}','${termAtNow}');
	
})
function createTable(tableId){
	var weeks = ['','星期日','星期一','星期二','星期三','星期四','星期五','星期六'];
	var times = ['','1-2','3-4','5-6','7-8','9-10'];
	if ($('#type').val() == 'student'){
		$('#'+tableId).append('<caption>${user.name }个人课程表</caption>');
	}else{
		$('#'+tableId).append('<caption>${user.academyName }-${user.grade}-${user.className }课程表</caption>');
	}
	$('#'+tableId).append('<thead><tr id="th"></tr></thead>');
	$('#'+tableId).append('<tbody id="tbody"></tbody>');
	for(var i=0;i<weeks.length;i++){
		$('#th').append('<th>'+weeks[i]+'</th>');
	}
	for(var j=0;j<times.length;j++){
		$('#tbody').append('<tr id='+times[j]+'></tr>');
	}
	for(var j=1;j<times.length;j++){
		$('#'+times[j]).append('<td>'+times[j]+'</td>');
		for(var i=1;i<weeks.length;i++){
				$('#'+times[j]).append('<td align="center" id='+weeks[i]+'-'+times[j]+'></td>');
		}
	
	}
	
}

function clearTable(tableId){
	$("#"+tableId).children().remove();
}

	
function fillTable(datas){
	var data = datas.classSyllabus;
		for(var i=0;i<data.length;i++){
				var id = data[i].classWeek+'-'+data[i].classTime;
				$('#'+id).html(
						data[i].subjectName+"</br>"+
						data[i].locationName+"</br>"+
						data[i].teacherName
						
				);
		}
	var data1 = datas.studentSyllabus;
	if (data1 != null){
		
		for(var i=0;i<data1.length;i++){
				var id1 = data1[i].classWeek+'-'+data1[i].classTime;
				$('#'+id1).html(
						data1[i].subjectName+"</br>"+
						data1[i].locationName+"</br>"+
						data1[i].teacherName
						
				);
		}
	}
}
</script>





</body>
</html>