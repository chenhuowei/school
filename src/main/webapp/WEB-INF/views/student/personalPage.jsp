<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<body>

<div id="tipDiv" align="center" style="position: fixed;
top: 480px;left: 300px;z-index:999;width: 800px"></div>

   <form role="form" class="form-horizontal" id="personalForm">
       <fieldset>
        <div class="form-group">
               <label class="col-sm-1 control-label" for="cademyName">学院</label>
               <div class="col-sm-3">
                   <input type="text" disabled name="academyName" class="form-control" id="academyName" />
               </div>
               <label class="col-sm-1 control-label" for="grade">年级</label>
               <div class="col-sm-3">
                   <input type="text" disabled name="grade" class="form-control" id="grade" />
               </div>
               <label class="col-sm-1 control-label" for="className">班别</label>
               <div class="col-sm-3">
                   <input type="text" disabled name="className" class="form-control" id="className" />
               </div>
           </div>
           <div class="form-group">
               <label class="col-sm-1 control-label" for="name">姓名</label>
               <div class="col-sm-3">
                   <input type="text" name="name" class="form-control" id="name" />
               </div>
               <label class="col-sm-1 control-label" for="sNum">学号</label>
               <div class="col-sm-3">
                   <input type="text" disabled name="studentNum" class="form-control" id="sNum" />
               </div>
               <label class="col-sm-1 control-label" for="sex">性别</label>
               <div class="radio" id="sex">
			   <label>
			      <input type="radio" name="sex" 
			         value=true> 男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      <input type="radio" name="sex" 
			         value=false>女
			   </label>
			</div>
			
           </div>
           <div class="form-group">
               <label class="col-sm-1 control-label" for="email">邮箱</label>
               <div class="col-sm-3">
                   <input type="text" name="email" class="form-control" id="email" />
               </div>
               <label class="col-sm-1 control-label" for="phone">手机</label>
               <div class="col-sm-3">
                   <input type="text" name="mobile" class="form-control" id="phone" />
               </div>
               <label class="col-sm-1 control-label" for="tel">家庭电话</label>
               <div class="col-sm-3">
                   <input type="text" name="homeTel" class="form-control" id="tel" />
               </div>
           </div>
           <div class="form-group">
               <label class="col-sm-1 control-label" for="idCard">身份证</label>
               <div class="col-sm-3">
                   <input type="text" name="idCard" class="form-control" id="idCard" />
               </div>
               <label class="col-sm-1 control-label" for="datetimepicker">出生日期</label>
               <div class="col-sm-3">
                   <input type="text" name="birth" class="datetimepicker" readonly id="datetimepicker" />
               </div>
               <label class="col-sm-1 control-label" for="age">年龄</label>
               <div class="col-sm-3">
                   <input type="text" name="age" disabled class="form-control" readonly id="age" />
               </div>
           </div>
           <div class="form-group">
               <label class="col-sm-1 control-label" for="national">民族</label>
               <div class="col-sm-3">
                   <input type="text" name="national" class="form-control" id="national" />
               </div>
               <label class="col-sm-1 control-label" for="native">籍贯</label>
               <div class="col-sm-3">
                   <input type="text" name="nativePlace" class="form-control" id="native" />
               </div>
               <label class="col-sm-1 control-label" for="home">家庭地址</label>
               <div class="col-sm-3">
                   <input type="text" name="homeAddress" class="form-control" id="home" />
               </div>
           </div>
          
           <div class="form-group">
               <label class="col-sm-1 control-label" for="school">毕业学校</label>
               <div class="col-sm-3">
                   <input type="text" name="schoolOfGraduation" class="form-control" id="school" />
               </div>
               <label class="col-sm-1 control-label" for="join">入学时间</label>
               <div class="col-sm-3">
                   <input type="text" name="admissionDate" class="form-control" readonly id="join" />
               </div>
               <label class="col-sm-1 control-label" for="parent">父母手机</label>
               <div class="col-sm-3">
                   <input type="text" name="parentMobile" class="form-control" id="parent" />
               </div>
           </div>
           <div class="form-group">
            
            <label class="col-sm-1 control-label" for="status">账号状态 </label>
               <div class="radio" id="status" disabled>
			    <label>
			      <input type="radio" name="status"  disabled
			         value=true> 激活中&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      <input type="radio" name="status"  disabled
			         value=false>已失效
			   </label>
				</div>
               <div class="col-sm-3">
                   <input type="text" name="id" hidden=true />
               </div>
               <label class="col-sm-1 control-label" for="re">备注</label>
               <div class="col-sm-6">
                   <textarea rows="6"  class="form-control" name="remark" id="re" />
               </div>
               
           </div>
           
       </fieldset>
   </form>
  <div class="form-group">
    <div class="col-sm-offset-5 col-sm-10">
      <button type="button" class="btn btn-primary" 
      	data-toggle="tooltip" data-placement="top"
        title="保存"
      	onclick="personalSubmit()">保存</button>
    </div>
  </div>
  
                                  
  
<script type="text/javascript">
function getPersonalData(){
	$.ajax({
		type: "get",  
		   url: basePath+"student/getById.do",  
		   data: {'id':'${user.id}'},  
		   success: function(msg){  
		      loadData("personalForm",JSON.stringify(msg));
		   }  
	});
}
$(function(){
	 //$("#personalForm").validation({icon:true});
	
	getPersonalData();
	 $(".datetimepicker").datetimepicker({
         autoclose: true,//选中之后自动隐藏日期选择框
         todayBtn: true,//今日按钮
         format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
     });
	
	
	 
	
})



function personalSubmit(){
	//if ($("#personalForm").valid(this,'内容出错')==false){
   //     return false;
     // }
	submitForm('personalForm','student/update.do','tipDiv',getPersonalData);
	
}


</script>



</body>
</html>