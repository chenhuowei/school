<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PASSWORD</title>
</head>
<body>


<div id="tipDiv1" align="center" style="position: fixed;
	top: 480px;left: 300px;z-index:999;width: 800px"></div>

<form role="form" class="form-horizontal" id="passwordForm">
       <fieldset>
        <div class="form-group">
               <label class="col-sm-1 control-label" for="cademyName">学号</label>
               <div class="col-sm-3">
                   <input type="text" name="num" readonly value="${user.studentNum }" class="form-control" id="academyName" />
                   <input type="text"  name="id" value="${user.id }" hidden=true />
               </div>
              
           </div>
        <div class="form-group">
               
               <label class="col-sm-1 control-label" for="old">输入原密码</label>
               <div class="col-sm-3">
                   <input type="password"  name="oldPassword" 
                   check-type="required" minlength="6" required-message="请填写你的旧密码"
                   class="form-control" id="old" />
               </div>
               
           </div>
        <div class="form-group">
              
               <label class="col-sm-1 control-label" for="new">输入新密码</label>
               <div class="col-sm-3">
                   <input type="password"  name="newPassword" 
                   check-type="required" minlength="6" required-message="请填写你的新密码"
                   class="form-control" id="new" />
               </div>
           </div>
        <div class="form-group">
               
               <label class="col-sm-1 control-label" for="again">确认新密码</label>
               <div class="col-sm-3">
                   <input type="password"  name="comfirmPassword"
                    check-type="required" minlength="6" required-message="请填写确认密码"
                     class="form-control" id="again" />
               </div>
           </div>
		</fieldset>
</form>
<div class="form-group">
    <div class="col-sm-offset-5 col-sm-10">
      <button type="button" class="btn btn-primary" 
      	data-toggle="tooltip" data-placement="top"
        title="保存"
      	onclick="passwordSubmit()">保存</button>
    </div>
  </div>
<script type="text/javascript">
function out(){
	top.location.href = basePath+'common/loginIndex.do';
}
$(function(){
	 $("#passwordForm").validation();
})
	function passwordSubmit(){
	if ($("#passwordForm").valid(this,'内容出错')==false){
        return false;
      }
		if ($('#new').val() == $('#again').val()){
			submitForm('passwordForm','student/updatePassword.do','tipDiv1',out);
			
		}else{
			alertTip('tipDiv1',false,'确认密码失败，两次新密码输入需要一致！');
		}
	}
</script>

</body>
</html>