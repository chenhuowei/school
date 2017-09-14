<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/extPath.jsp"></jsp:include>


<script type="text/javascript">

//get cookies
var allcookies = document.cookie;    
//定义一个函数，用来读取特定的cookie值。  
 
function getCookie(cookie_name)  
 
	{  
	 
	var allcookies = document.cookie;  
	 
	var cookie_pos = allcookies.indexOf(cookie_name);   //索引的长度  
	 
	  
	 
	//如果找到了索引，就代表cookie存在，  
	 
	//反之，就说明不存在。  
	 
	if (cookie_pos != -1)  
	 
	{  
	 
	//把cookie_pos放在值的开始，只要给值加1即可。  
	 
	cookie_pos += cookie_name.length + 1;      //这里我自己试过，容易出问题，所以请大家参考的时候自己好好研究一下。。。  
	 
	var cookie_end = allcookies.indexOf(";", cookie_pos);  
	 
	  
	 
	if (cookie_end == -1)  
	 
	{  
	 
	cookie_end = allcookies.length;  
	 
	}  
	 
	  
	 
	var value = unescape(allcookies.substring(cookie_pos, cookie_end)); //这里就可以得到你想要的cookie的值了。。。  
	 
	}  
	 
	  
	 
	return value;  
	 
	}  
 
  
 
//调用函数  
var cookie_num = getCookie("num");  
var cookie_password = getCookie("password");  


Ext.onReady(function () {
	   //登录窗口
	var login_form_panel = Ext.create("Ext.form.Panel", {
	    width: 400,
	    height: 230,
	    margin: 50,
	    padding:20,
	    renderTo: "login_form",
	    collapsible: false,  //可折叠
	    autoScroll: true,   //自动创建滚动条
	    defaultType: 'textfield',
	    buttonAlign:'center',
	    defaults: {
	        anchor: '100%',
	    },
	    fieldDefaults: {
	        labelWidth: 80,
	        labelAlign: "center",
	        flex: 1,
	        margin: 5
	    },
	    items: [
	        {
	            xtype: "container",
	            layout: "vbox",
	            items: [
	                { xtype: "textfield", name: "num",value:cookie_num, fieldLabel: "登录账号", emptyText:"请输入登录账号",allowBlank: false },
	                { xtype: "textfield", name: "password",value : cookie_password, fieldLabel: "登录密码",inputType:'password',emptyText:"请输入登录密码", allowBlank: false },
	            ]
	        },
	        {
	        	 xtype: "container",
		            layout: "vbox",
		            items: [
		                { xtype: "checkbox", name: "rememberMe", fieldLabel: "记住我?", inputValue: true,},
		            ]
	        },
	        
	        {  
                xtype      : 'fieldcontainer',  
                fieldLabel : '登录选项',  
                defaultType: 'radiofield',  
                defaults: {  
                    flex: 1  
                },  
                layout: 'hbox',  
                items: [  
                    {  
                        boxLabel  : 'admin',  
                        name      : 'loginType',  
                        inputValue: 'admin',  
                        checked : true
                    }, {  
                        boxLabel  : '教工',  
                        name      : 'loginType',  
                        inputValue: 'teacher',  
                    }, {  
                        boxLabel  : '学生',  
                        name      : 'loginType',  
                        inputValue: 'student',  
                    }  
                ]  
            }  
	    ],
	    buttons: [
	        { xtype: "button", text: "登录" ,
	        	handler: function () {
      	        	var form = login_form_panel.getForm();
      	            if (form.isValid()) {
      	                form.submit({
      	                	url: '${pageContext.request.contextPath}/common/login.do',
      	                    success: function(form, action) {
      	                    	window.location.href = "${pageContext.request.contextPath}"+action.result.url;
      	                    	myMsg('登陆提示',action.result.message);
      	                    },
      	                    failure: function(form, action) {
      	                        Ext.MessageBox.alert('登录提示', "登陆失败,用户名或密码错误");
      	                    }
      	                });
      	            }
	        	}
	        
	        },
	        { xtype: "button", text: "注册申请", handler:function(){
	        	Ext.MessageBox.alert('Tip','请在一个工作日内到人事管理处获取申请表格并且如实填写...');
	        } },
	        { xtype: "button", text: "忘记密码？", handler:function(){
	        	Ext.MessageBox.alert('Tip','请带本人的在校的相关证件与身份证件到人事处查找或更改...');}
	        },
	    ]
	});
	    	});
</script>
<body>

     <div id="login_form" align="center" style="position:fixed;left:600px;top: 100px"></div>
     
     

</body>



