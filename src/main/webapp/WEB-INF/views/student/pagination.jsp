<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>

	<form role="form" id="pageForm">
		 <fieldset>
	        <div class="form-group">
	               <div class="col-sm-3">
	               		<a>当前页码,总页数,总记录数</a>
	               </div>
	               <div class="col-sm-1">
	               		<button type="button" class="btn btn-default">&laquo; 上页</button>
	               </div>
	               <div class="col-sm-1">
	               		<button type="button" class="btn btn-default">下页  &raquo;</button>
	               </div>
	               <div class="col-sm-1">
	               		<h5> 转至</h5>
	               </div>
	               <div class="col-sm-1">
	               	<input type="text" style="width:60px"
	               		class="form-control" id="pageNum" placeholder="页码">
	               </div>
	               <div class="col-sm-1">
	               		<button type="button" class="btn btn-default">Go</button>
	               </div>
	               
	           </div>
        </fieldset>
	</form>


</body>
</html>