<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDITPASSWORD</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<script type="text/javascript">

var editForm = new Ext.FormPanel({
    	bodyStyle: 'padding:5px 5px 0',renderTo:Ext.getBody(),
     layout: 'form',
     items: [
     {
     	 xtype: "container",
             layout: "vbox",
             items: [
                 { xtype: "textfield", name: "num", fieldLabel: "编号",value:'${user.teacherNum}', allowBlank: false, editable:false},
                 { xtype: "textfield", name: "oldPassword", fieldLabel: "输入原密码", allowBlank: false,minLength:6,
                 	inputType:'password',maxLength: 16,regex:/^[a-zA-Z0-9]+$/,regexText:'只允许输入英文字母或数字' },

                 { xtype: "textfield", name: "newPassword",id:'newPassword', fieldLabel: "输入新密码", allowBlank: false ,minLength:6,
                 		inputType:'password',maxLength: 16,regex:/^[a-zA-Z0-9]+$/,regexText:'只允许输入英文字母或数字' },
                 { xtype: "textfield", name: "confirmNewPassword", fieldLabel: "重复新密码", allowBlank: false ,minLength:6,
                 		inputType:'password',maxLength: 16,regex:/^[a-zA-Z0-9]+$/,regexText:'只允许输入英文字母或数字',
                 			  vtype : 'password',initialPassField : 'newPassword',},

             ]
     }, 
    
   ],
     buttonAlign: 'center',
     buttons: [
 {
     text: '保存',
     iconCls: 'icon-save',
     handler: function () {
     	if (editForm.isValid()) {
     		editForm.submit({
               	url: '${pageContext.request.contextPath}/teacher/updatePassword.do',
               	method: 'post',
                   success: function(form,action) {
                      myMsg('操作提示',action.result.message+",请重新登录");
                   	top.window.location.href = '${pageContext.request.contextPath}/common/loginIndex.do';
                   },
                   failure: function(form,action) {
					myAlertMsg('提示','原密码不匹配或你已经离线');
                   }
               });
           }
     }
 },
]
 });


</script>
</body>
</html>