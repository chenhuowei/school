<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<jsp:include page="editPersonal.jsp" flush="true"></jsp:include>
<script type="text/javascript">

var northPanel = Ext.create('Ext.panel.Panel', {  
    id:'north',
    border: false,  
    collapsible: false,
    split: false,  
    region: 'north',
    tbar: [
		{xtype:'label',text:'校务服务系统'},
		"->",
		{xtype:'button',scale:'large', handler:function(){},
       	 icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Mail_Info.png'},'-',
        {xtype:'button',scale:'large', icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/User.png'},
        {xtype:'label',text:'当前用户:${user.userNum}'},'-',
		{xtype:'button',text:'${sessionScope.user.name}',id:'user',tooltip: '提示信息',scale:'medium',
			
			menu : [
			             {text: '个人中心',
			            	 handler: function () {
			            		 editPersonal('${user.id}','${user.userNum}');
			                 }	
			             },
			             {text: '更改密码',
			            	 handler: function () {
			            		 var editForm = new Ext.FormPanel({
			         	           	bodyStyle: 'padding:5px 5px 0',
			         	            layout: 'form',
			         	            items: [
			         	            {
			         	            	 xtype: "container",
			         	                    layout: "vbox",
			         	                    items: [
			         	                        { xtype: "textfield", name: "num", fieldLabel: "编号",value:'${user.userNum}', allowBlank: false, editable:false},
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
			               	                	url: '${pageContext.request.contextPath}/user/updatePassword.do',
			               	                	method: 'post',
			               	                    success: function(form,action) {
			               	                       myMsg('操作提示',action.result.message+",请重新登录");
			               	                       win.close(this);
			               	                    	window.location.href = '${pageContext.request.contextPath}/common/loginIndex.do';
			               	                    },
			               	                    failure: function(form,action) {
													myAlertMsg('提示','原密码不匹配或你已经离线');
			               	                    }
			               	                });
			               	            }
			         	            }
			         	        }, {
			         	            text: '关闭',
			         	            iconCls: 'icon-close',
			         	            handler: function () {
			         	                win.close(this);
			         	            }
			         	        }
			         	      ]
			         	        });
			            		 var win = Ext.create("Ext.window.Window", {
			         	            title: "密码更改",       //标题
			         	            draggable: true,
			         	            constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
			         	            iconCls: 'icon-edit',
			         	            height: 210,                          //高度
			         	            width: 310,                           //宽度
			         	            layout: "fit",                        //窗口布局类型
			         	            modal: true, //是否模态窗口，默认为false
			         	            resizable: false,
			         	            items: [editForm]
			         	        });
			         	        win.show();
			                 }	
			             },
			             
			             {text: '登出/切换',
			            	 handler: function () {
			                     $.ajax({
			                    	 url:'${pageContext.request.contextPath}/common/logout.do',
			                    	 dataType:'json',
			                    	 type:'get',
			                    	 success:function(m){
			                    		myMsg('提示',m.message);
			                    		window.location.href = '${pageContext.request.contextPath}/common/loginIndex.do';
			                    	 }
			                     })
			                 }	 
			             },
			             {text: '取消',
			            	 handler: function () {
			                 }	 
			             },
			            
			         ],
			listeners: {
		        click: function() {
		        	
		        	   
		 			},
		        mouseover: function() {
		            // set a new config which says we moused over, if not already set
		                this.mousedOver = true;
		            if (this.mousedOver) {
		                Ext.create('Ext.tip.ToolTip', {
		                    target: 'user',
		                    anchor: 'left',           //指定箭头的指向 top,left,right
		                    width: 120,
		                    anchorOffset: 50,           //指定箭头的位置
		                    html:'点击，查看更多'
		                });
		               
		        	}
		   	 	}	
			}
		
		},
		{xtype:'label',text:'系统时间:'},
		{xtype:'button',text:'',id:'time',scale:'medium',
			
			 listeners : {
				 'render': function() {
					 
						Ext.TaskManager.start({
						    run: function() {
						      Ext.getCmp("time").setText(Ext.Date.format(new Date(), 'g:i:s A'));
						      
						    },
						    interval: 1000
						  });
						
					}
        	}
		}
	],
	
  
});  




</script>



</body>
