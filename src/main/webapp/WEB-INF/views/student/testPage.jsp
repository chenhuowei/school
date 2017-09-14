<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>

	<div id="testTip" align="center" style="position: fixed;
top: 480px;left: 300px;z-index:999;width: 800px"></div>
   
   <div class="row" >
   		<div class="col-md-12">
		</div>
	</div>
  
   <div class="row" >
   		<div class="col-md-12">
   			
			<table class="table table-hover" id="testTable">
			
			</table>
   		
		</div>
	</div>
  
  
  
  
<script src="${pageContext.request.contextPath }/bootstrap/utils/grid.js"></script>
<script type="text/javascript">

	$(function(){
		loadTestData(1);
	})

	var attrs = ['testCode','testName','testNum','testLocation','testScore',
	            'isPass'];
	var headers = ['考试代码','考试名称','准考证号',
	            '考试地点','考试成绩','是否通过'];
	var title = '考试信息列表';
	
	var grid = new Grid('testTable',title,headers,attrs,null);
	function loadTestData(pageNum){
		$.ajax({
			type:'get',
			url:basePath+'student/studentTest.do',
			data:{'studentId':'${user.id}','page':pageNum,'limit':5},
			success:function(data){
				grid.datas = data;
				grid.loadFun = loadTestData;
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