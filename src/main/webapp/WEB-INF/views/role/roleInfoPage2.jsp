<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="padding: 5px">
<jsp:include page="/bostrapPath.jsp"></jsp:include>

<div id="roleTip" align="center" style="position: fixed;
top: 120px;left: 200px;z-index:999;width: 800px"></div>

 <div class="container">
  
   
   <div class="row" >
   		
   		<div class="col-md-7">
   			<button onclick="saveFun()" class="btn btn-primary">录入</button>
   			<button onclick="deleteSelectFun()" class="btn btn-warning">批量删除</button>
		</div>
   		<div class="col-md-3">
   			<input type="search" class="form-control" id="keyWord" placeholder="请输入关键字，多个,分隔">
		</div>
   		<div class="col-md-2">
   			<button onclick="searchFun()" class="btn btn-info">查找</button>
   			<button onclick="$('#keyWord').val('');loadRoleData(1);" class="btn">清空</button>
		</div>
   		
	</div>
   <div class="row" >
   		<div class="col-md-12">
   			
			<table class="table table-hover" id="roleTable">
			
			</table>
   		
		</div>
	</div>
</div>  

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">角色信息</h4>
            </div>
            <div class="modal-body">
            	
				<form id="roleForm" role="form" class="form-horizontal">
				  <div class="form-group">
				    <label for="roleName" class="col-sm-2 control-label">角色名称</label>
				    <div class="col-sm-6">
				      <input type="text" class="form-control" name="roleName" id="roleName" placeholder="请输入角色名称">
				    </div>
				  </div>
				  <div class="form-group">
				     <label class="col-sm-2 control-label" for="sex">状态</label>
		               <div class="radio" id="sex">
					   <label>
					      <input type="radio" name="status" checked="checked"
					         value=true> 激活 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					      <input type="radio" name="status" 
					         value=false>失效
					   </label>
					</div>
				  </div>
				  <div class="form-group">
				    <label for="remark" class="col-sm-2 control-label">备注</label>
				    <div class="col-sm-6">
				    <textarea name="remark" id="remark" class="form-control" rows="3" placeholder="请输入角色描述"></textarea>
				    </div>
				  </div>
				  <input type="reset" id="reset" name="reset" style="display: none;" />
				  <input type="input"  name="id" hidden="true"" />
				</form>
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="submitBtn" type="button" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script src="${pageContext.request.contextPath }/bootstrap/utils/grid2.js"></script>
<script type="text/javascript">
	

	$(function(){
		loadRoleData(1);
	})
	var updateBtn = {'funName':'updateFun','params':'id','class':'btn-primary','display':'编辑'}
	var deleteBtn = {'funName':'deleteFun','params':'id','class':'btn-warning','display':'删除'}
	var btns = [updateBtn,deleteBtn];
	
	var attrs = ['roleName','createTime','updateTime','status',
	            'remark'];
	var headers = ['角色名称','创建时间','更新时间',
	            '角色状态','备注'];
	var title = '角色信息列表';
	
	var grid = new Grid('roleTable',title,headers,attrs,btns);
		function loadRoleData(pageNum){
			$.ajax({
				type:'get',
				url:basePath+'roleInfo/findByPage.do?page='+pageNum+'&limit=5',
				data:{},
				success:function(data){
					grid.datas = data;
					grid.loadFun = loadRoleData;
					grid.renderData();
				},
				error:function(){
					alert('请求异常，请稍后再次尝试...');
				}
			})
		}
		
		function loadRoleDataByKeyWord(pageNum){
			$.ajax({
				type:'get',
				url:basePath+'roleInfo/findByPage.do?page='+pageNum+'&limit=5',
				data:{'keyWord':$('#keyWord').val()},
				success:function(data){
					grid.datas = data;
					grid.loadFun = loadRoleDataByKeyWord;
					grid.renderData();
				},
				error:function(){
					alert('请求异常，请稍后再次尝试...');
				}
			})
		}
		
	function saveFun(){
		$("#reset").trigger("click");
		$('#submitBtn').on('click',function(){submitFun('roleInfo/save.do')});
		 $('#myModal').modal();
	}
	function updateFun(id){
		$("#reset").trigger("click");
		$.ajax({
			type:'get',
			url:basePath+'roleInfo/findById.do',
			data:{'id':id},
			success:function(data){
				loadData('roleForm',JSON.stringify(data.data));
				$('#submitBtn').on('click',function(){submitFun('roleInfo/update.do')});
				$('#myModal').modal();
			},
			error:function(){
				alert('请求异常，请稍后再次尝试...');
			}
		})
	}
	function deleteFun(id){
		$.ajax({
			type:'get',
			url:basePath+'roleInfo/delete.do',
			data:{'ids':id},
			success:function(data){
				alertTip('roleTip',data.success,data.message);
				loadRoleData(1);
			},
			error:function(){
				alert('请求异常，请稍后再次尝试...');
			}
		})
	}
	
	function deleteSelectFun(){
		var s = $('#roleTable input[type="checkbox"]:checked');
		var ids = [];
		for(var i=0;i<s.length;i++){
			ids.push(s[i].value);
		}
		if (ids.length == 0){
			alert('请选择需要删除的记录...');
			return ;
		}
		deleteFun(ids.join(','));
	}
	
	
	function submitFun(url){
		submitForm('roleForm',url,'roleTip',null);
		loadRoleData(1);
		$('#myModal').modal('hide')
	}
	
	function searchFun(){
		var val = $('#keyWord').val();
		if (val != null && val != ''){
			loadRoleDataByKeyWord(1);
		}else{
			return;
		}
	}
	
	
</script>




</body>
</html>