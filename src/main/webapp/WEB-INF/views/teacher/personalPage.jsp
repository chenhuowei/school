<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/extPath.jsp"></jsp:include>
<script type="text/javascript">    
		
		var user = Ext.define('User', {
		    extend: 'Ext.data.Model',
		    fields: ['teacherNum', 'name','sex','age','status','homeAddress','email','phone','mobile','idCard',
						'nativePlace','national','birth','createTime','updateTime','joinDate','academicDegree','academyName','remark','regisTime',		             
		            ],
		            proxy: {
		                type: 'ajax',
		                url : '${pageContext.request.contextPath}/teacher/findByIdAndNum.do?num=${sessionScope.user.teacherNum}'
		            }
		});
		user.load('${sessionScope.user.id}', {
		    success: function(user) {
		        editForm.loadRecord(user); //logs 123
		    }
		});
		 
		var editForm = new Ext.FormPanel({
		   	bodyStyle: 'padding:5px 5px 0',
		    layout: 'form',
		    renderTo:Ext.getBody(),
		    waitMsg : '正在加载数据请稍后',//提示信息                
	        waitTitle : '提示',//标题    
		    items: [
{
	xtype: "container",
    layout: "hbox",
    items: [
       
            { xtype:'textfield', name:'id', fieldLabel:'id', allowBlank: true,hidden:true},
            { xtype:'textfield', name:'teacherNum',id:'userNum', fieldLabel:'工号', disabled: true,
            	value : getNumStart()+'2',disabled:false,regex:/^[1-9]\d{6,10}$/,
            	regexText: '请输入以年份后两位数字+代表数(u:0,s:1,t:2)为开头的7-11位数字(2016 u : 1620123)'},
            { xtype:'textfield', name:'name', fieldLabel:'姓名', allowBlank: false },

    ]
},

{
	xtype: "container",
    layout: "hbox",
    items: [
       
        { xtype:'textfield', name:'age', fieldLabel:'年龄', allowBlank: true,editable:false,disabled:true},
         { xtype:'radiogroup', name:'sex', fieldLabel:'性别', allowBlank: false,  
           columnWidth:0.8,items: [  
               { boxLabel: '男', name: 'sex', inputValue: true },   
               { boxLabel: '女', name: 'sex', inputValue: false },  
               
            ]
                    
  	  	}, 

    ]
},
{
	xtype: "container",
    layout: "hbox",
    items: [
       
            { xtype:'textfield', name:'national', fieldLabel:'民族', allowBlank: false, },
            { xtype:'textfield', name:'homeTel', fieldLabel:'家庭电话', allowBlank: false,vtype:'phone' },

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
       
			{ xtype:'textfield',name:'academyName', fieldLabel:'学院名称', allowBlank: false,editable:false},
            { xtype:'datefield', name:'birth', fieldLabel:'出生日期', allowBlank: false ,format : 'Y-m-d',editable:false,
            	maxValue : new Date()},
          

    ]
},
{
	xtype: "container",
    layout: "hbox",
    items: [
       
           
            { xtype:'radiogroup', name:'academicDgree', fieldLabel:'学历层次', allowBlank: false,width:320,  
            	items: [  
	                   { boxLabel: '教授', name: 'academicDegree', inputValue: '教授',width:80 },   
	                   { boxLabel: '博士', name: 'academicDegree', inputValue: '博士',width:80 },  
	                   { boxLabel: '硕士', name: 'academicDegree', inputValue: '硕士',width:80 },   
	                   { boxLabel: '研究生', name: 'academicDegree', inputValue: '研究生',width:80 },  
	                   
	                ]
		                    
	      	  	}, 

    ]
},
{
	xtype: "container",
    layout: "hbox",
    items: [
       
            
            { xtype:'textfield', name:'nativePlace', fieldLabel:'籍贯', allowBlank: false, width:550, 
               }
    ]
},
{
	xtype: "container",
    layout: "hbox",
    items: [
       
            
            { xtype:'textfield', name:'schoolOfGraduation', fieldLabel:'毕业学校', allowBlank: false, width:550, 
               }
    ]
},
{
	xtype: "container",
    layout: "hbox",
    items: [
       
            { xtype:'textfield', name:'homeAddress', fieldLabel:'家庭地址', allowBlank: true,width:550}

    ]
},
{
	xtype: "container",
    layout: "hbox",
    items: [
       
            { xtype:'textfield', name:'idCard', fieldLabel:'身份证', allowBlank: false
            	,regex:/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/ ,regexText:"请输入正确的身份证号码"},
            

    ]
},
{
	 xtype: "container",
       layout: "hbox",
       items: [
           {xtype:'radiogroup', name:'status', fieldLabel:'状态',   allowBlank: false,
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
       
            { xtype:'datefield', name:'joinDate', fieldLabel:'入职时间', allowBlank: false ,editable:false,format:'Y-m-d',maxValue: new Date()},
            { xtype:'textfield', name:'regisTime', fieldLabel:'注册时间', allowBlank: true ,disabled:true,},

    ]
},
{
	xtype: "container",
    layout: "hbox",
    items: [
       
            { xtype:'textfield', name:'createTime', fieldLabel:'创建时间', allowBlank: true ,disabled:true,},
            { xtype:'textfield', name:'updateTime', fieldLabel:'更新时间', allowBlank: true ,disabled:true,},

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
		    handler: function () {
		    	if (editForm.isValid()) {
		    		
		    		editForm.submit({
			                	url: basePath+'teacher/update.do',
			                	method: 'post',
			                    success: function(form,action) {
			                       myMsg('操作提示',action.result.message);
			                       
			                    },
			                    failure: function(form,action) {

			                    	myMsg('操作提示',action.result.message);
			                    }
			                });
		    		
		          }
		    }
		}
		]
		});

		//Ext.getCmp('centerPanel').add(editForm);
		
		
</script>

		