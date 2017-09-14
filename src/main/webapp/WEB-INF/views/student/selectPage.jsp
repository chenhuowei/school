<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div>
	<form role="form">
	  <div class="form-group">
	       <label class="col-sm-1 control-label" for="selectYear">学年</label>
	    <div class="col-sm-3">
	    <select class="form-control" id="selectYear">
	      
	    </select>
	    </div>
	    
	  <div class="form-group">
	       <label class="col-sm-1 control-label" for="selectTerm">学期</label>
	    <div class="col-sm-3">
	    <select class="form-control" id="selectTerm">
	      <option value="1">1</option>
	      <option value="2">2</option>
	      <option value="">不限</option>
	      
	    </select>
	    </div>
	</form>
</div>	

<script type="text/javascript">
	$(function(){
		loadSelectList();
		// auto selected
		var term = $('#selectTerm option');
		for(var i=0;i<term.length;i++){
			if (term[i].value == '${termAtNow}'){
				term[i].selected = 'selected';
			}
		}
		var year = $('#selectYear option');
		for(var i=0;i<year.length;i++){
			if (year[i].value == '${schoolYearAtNow}'){
				year[i].selected = 'selected';
			}
		}
	})

	function loadSelectList(){
		$.ajax({
			url:basePath+'dictionary/findByGrade.do',
			data:{'grade':'${user.grade}'},
			type:'get',
			success:function(data){
				for(var i=0;i<data.length;i++){
					$('#selectYear').append('<option value="'+data[i].name+'">'+data[i].value+'</option>');
				}
					$('#selectYear').append('<option value="">'+'不限'+'</option>');
			},
			error:function(){
				alert('请求有误，请稍后再次尝试...');
			}
		})
	}
	
	
	
	

</script>



</body>
</html>