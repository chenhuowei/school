<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

	var editPersonal = function(id,num){
		
		var user = Ext.define('User', {
		    extend: 'Ext.data.Model',
		    fields: ['userNum', 'name','sex','age','status','address','email','phone','mobile','idCard',
						'birth','createTime','updateTime','joinDate','lastLoginTime','loginIp','remark','regisTime',		             
		            ],
		            proxy: {
		                type: 'ajax',
		                url : '${pageContext.request.contextPath}/user/findByIdOrNum.do?num='+num
		            }
		});
		user.load(id, {
		    success: function(user) {
		        editForm.loadRecord(user); //logs 123
		    }
		});
		 /* var userStore = Ext.create('Ext.data.Store', {
		     model: user,
		     proxy: {
		         type: 'ajax',
		         url: '${pageContext.request.contextPath}/user/findByIdOrNum.do?num=1601234',
		         reader: {
		             type: 'json',
		         }
		     },
		     autoLoad: true
		 }); */
		 
		var editForm = new Ext.FormPanel({
		   	bodyStyle: 'padding:5px 5px 0',
		    layout: 'form',
		    waitMsg : '正在加载数据请稍后',//提示信息                
	        waitTitle : '提示',//标题    
		    items: [
			{
				xtype: "container",
			    layout: "hbox",
			    items: [
			       
			            { xtype:'textfield', name:'id', fieldLabel:'id', allowBlank: true,hidden:true},
			            { xtype:'textfield', name:'refresh',value:true, fieldLabel:'id', allowBlank: true,hidden:true},
			            { xtype:'textfield', name:'userNum',id:'userNum', fieldLabel:'工号', allowBlank: false,disabled:true,
			            	regex:/^[1-9]\d{6,10}$/,
			            	regexText: '请输入以年份后两位数字+代表数(u:0,s:1,t:2)为开头的7-11位数字(2016 u : 1600123)'},
			            { xtype:'textfield', name:'name', fieldLabel:'姓名', allowBlank: false },
			
			    ]
			},
		    
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		           
		            { xtype:'textfield', name:'age', fieldLabel:'年龄', allowBlank: true,editable:false,disabled:true},
		             { xtype:'radiogroup', name:'userSex', fieldLabel:'性别', allowBlank: false,  
		               columnWidth:0.8,items: [  
		                   { boxLabel: '男', name: 'sex', inputValue: 'true' },   
		                   { boxLabel: '女', name: 'sex', inputValue: 'false' },  
		                   
		                ]
			                    
		      	  	}, 

		        ]
		    },
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		           
		                { xtype:'textfield', name:'mobile', fieldLabel:'手机号码', allowBlank: false,vtype:'mobilephone' },
		                { xtype:'textfield', name:'email', fieldLabel:'电子邮箱', allowBlank: false,vtype: "email",//email格式验证  
		                    vtypeText   : "不是有效的邮箱地址"}

		        ]
		    },
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		           
		                { xtype:'datefield', name:'birth', fieldLabel:'出生日期', allowBlank: false ,format : 'Y-m-d',editable:false,
		                	maxValue : new Date()},
		                { xtype:'textfield', name:'address', fieldLabel:'居住地址', allowBlank: false},

		        ]
		    },
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		           
		                { xtype:'textfield', name:'homeTel', fieldLabel:'家庭电话', allowBlank: false,vtype:'phone' },
		                { xtype:'textfield', name:'homeAddress', fieldLabel:'家庭地址', allowBlank: true,disabled:true},

		        ]
		    },
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		           
		                { xtype:'textfield', name:'idCard', fieldLabel:'身份证', allowBlank: false
		                	,regex:/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/ ,regexText:"请输入正确的身份证号码"},
		                
		                { xtype: "textfield", name: "password2", fieldLabel: "密码", allowBlank: false, disabled:true,
		                		inputType:'',maxLength: 16,regex:/^[a-zA-Z0-9]+$/,regexText:'只允许输入英文字母或数字' },

		        ]
		    },
		    {
		   	 xtype: "container",
		           layout: "hbox",
		           items: [
		               {xtype:'radiogroup', name:'userAccountStatus', fieldLabel:'状态',   allowBlank: false,disabled:true,
		                      columnWidth:0.8,items: [  
		                          { boxLabel: '激活', name: 'status', inputValue: 'true' ,checked:'true'},   
		                          { boxLabel: '失效', name: 'status', inputValue: 'false' },  
		                         
		                      ]
		                  },
		           ]
		   }, 
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		           
		                { xtype:'datefield', name:'joinDate', fieldLabel:'入职时间', allowBlank: false ,editable:false,format:'Y-m-d'
		                	,maxValue: new Date(),disabled:true,},
		                { xtype:'textfield', name:'regisTime', fieldLabel:'注册时间', allowBlank: true ,editable:false,disabled:true,},

		        ]
		    },
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		           
		                { xtype:'textfield', name:'createTime', fieldLabel:'创建时间', allowBlank: true ,editable:false,disabled:true,},
		                { xtype:'textfield', name:'updateTime', fieldLabel:'更新时间', allowBlank: true ,editable:false,disabled:true,},

		        ]
		    },
		    
		    
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		           
		                { xtype:'textfield', name:'lastLoginTime', fieldLabel:'最后登录时间', allowBlank: true ,disabled:true,},
		                { xtype:'textfield', name:'loginIp', fieldLabel:'最后登录IP', allowBlank: true ,disabled:true,},

		        ]
		    },
		    
		    
		    {
		   	 xtype: "container",
		           layout: "hbox",
		           items: [
		               
		               { xtype: "textarea", name: "remark", fieldLabel: "备注", allowBlank: true ,emptyText : '备注文本300字以内', grow:true, height:100,width:550,
		                   maxLength : 300,  }
		           ]
		   }, 
		    
		    
		  ],
		    buttonAlign: 'center',
		    buttons: [
		{
		    text: '保存',
		    id : 'saveButton',
		    iconCls: 'icon-save',
		    handler: function () {
		    	if (editForm.isValid()) {
		    		
		    		editForm.submit({
			                	url: basePath+'user/update.do',
			                	method: 'post',
			                    success: function(form,action) {
			                       myMsg('操作提示',action.result.message);
			                       editWin.close(this);
			                       //window.location.reload();
			                       
			                    },
			                    failure: function(form,action) {

			                    	myMsg('操作提示',action.result.message);
			                    }
			                });
		    		
		          }
		    }
		}, {
		    text: '关闭',
		    iconCls: 'icon-close',
		    handler: function () {
		    	editWin.close(this);
		    }
		}
		]
		});

		
		
		
		
		var editWin = Ext.create("Ext.window.Window", {
            title: '个人资料编辑',       //标题
            autoScroll: true,
            maximizable :true,
            draggable: true,
            constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
            iconCls: 'icon-edit',
            height: 350,                          //高度
            width: 600,                           //宽度
            layout: "fit",                        //窗口布局类型
            modal: true, //是否模态窗口，默认为false
            resizable: false,
            items: [editForm]
        });
		
		
		editWin.show();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

</script>