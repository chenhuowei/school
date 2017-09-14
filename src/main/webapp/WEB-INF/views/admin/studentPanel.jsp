<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STUDENT</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<jsp:include page="studentTab.jsp"></jsp:include>
<jsp:include page="scoreRecordPage.jsp"></jsp:include>
<jsp:include page="studentSyllabus.jsp"></jsp:include>
<jsp:include page="resultsStatisticalPage.jsp"></jsp:include>
<jsp:include page="studentSelectSubject.jsp"></jsp:include>
<jsp:include page="studentTest.jsp"></jsp:include>
<jsp:include page="studentTestRecord.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/searchPanel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/FileUploadField.js"></script>
<script type="text/javascript">
var academyId = '';
var academyName = '';
var grade = '';
var classId = '';
var className = '';

var classStore = Ext.create('Ext.data.Store', {
    fields: ["value", "name"],
    proxy: {
        type: 'ajax',
        url: '',
   	   
    },
    autoLoad: false,
    pageSize : 8,
    listeners:{  
        'load' : function(store, records, options ){      
            var data ={ "value": "", "name": "不限制"};      
            var rs = [new Ext.data.Record(data)];      
            store.insert(0,rs);  
        }  
    }  
});
var toolbarSelect = Ext.create('Ext.Toolbar',{
	dock : 'top',
	items : [ 
				{ xtype: "combobox", name: "academy",id:'academy', fieldLabel:"学院",allowBlank:true,emptyText: '选择学院...',editable:false, padding:0,
				 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
				 	store:Ext.create('Ext.data.Store', {
				         fields: ["value", "name"],
				            proxy: {
				                type: 'ajax',
				                url: basePath+'academy/findIdnName.do',
				           	   
				            },
				            autoLoad: false,
				            pageSize : 8,
				            listeners:{  
				                'load' : function(store, records, options ){      
				                    var data ={ "value":"", "name": "不限制"};      
				                    var rs = [new Ext.data.Record(data)];      
				                    store.insert(0,rs);  
				                }  
				            }  
				        }),
				       displayField:'name',
				 		 valueField:'value',
				 		 pageSize:8,
				 		 queryParam: 'keyWord',
				 		listeners :{
				            'select':function(obj, record,eOpts){
				            	var id = record.data.value;
				            	academyId = id;
				            	academyName = record.data.name;
				            	store.reload({params:{'academyId':academyId}});
				            	if (''!=academyId && ''!=grade){
					            	classStore.getProxy().url = basePath+'classes/findIdAndName.do?academyId='+academyId+'&grade='+grade;
					            	classStore.load();
					            	Ext.getCmp('classes').setValue('');
				            	}else{
					            	classStore.removeAll();
					            	Ext.getCmp('classes').setValue('');
				            		
				            	}
				            	
				            }
				          } 
				 },
				{ xtype: "combobox", name: "grade",id:'grade', fieldLabel:"年级",allowBlank:true,emptyText: '选择年级...',editable:false, padding:0,
				 	forceSelection:true,selectOnFocus : true,width:366,labelWidth:30,
				 	store:Ext.create('Ext.data.Store', {
				         fields: ["name", "value"],
				            proxy: {
				                type: 'ajax',
				                url: basePath+'dictionary/findByType.do?type=grade',
				           	   
				            },
				            autoLoad: false,
				            pageSize : 8,
				            listeners:{  
				                'load' : function(store, records, options ){      
				                   
				                }  
				            }  
				        }),
				       displayField:'name',
				 		 valueField:'value',
				 		 pageSize:6,
				 		 queryParam: 'keyWord',
				 		listeners :{
				            'select':function(obj, record,eOpts){
				            	
				            	grade = record.data.value;
				            	store.reload({params:{'academyId':academyId,'grade':grade}});
				            	if (''!=academyId && ''!=grade){
					            	classStore.getProxy().url = basePath+'classes/findIdAndName.do?academyId='+academyId+'&grade='+grade;
					            	classStore.load();
					            	Ext.getCmp('classes').setValue('');
				            	}else{
					            	classStore.removeAll();
					            	Ext.getCmp('classes').setValue('');
				            		
				            	}
				            }
				          } 
				 },
				{ xtype: "combobox", name: "classes",id:'classes', fieldLabel:"班级",allowBlank:true,emptyText: '选择班级...',editable:false, padding:0,
				 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
				 	store:classStore,
				       displayField:'name',
				 		 valueField:'value',
				 		 pageSize:6,
				 		 queryParam: 'keyWord',
				 		listeners :{
				            'select' : function(obj,record,opts){
				            	classId = record.data.value;
				            	className = record.data.name;
				            	store.reload({params:{'academyId':academyId,'grade':grade,'classId':classId}});
				            	if (classId != ''){
				            		toolbarCRUD.setDisabled(false);
				            	}else{
				            		toolbarCRUD.setDisabled(true);
				            	}
				            }
				          } 
				 }
	             
	         ],
	
})
var toolbarCRUD = Ext.create('Ext.Toolbar',{
	dock : 'top',
	disabled : true,
	items :[
			{text:'新增',iconCls:'icon-plus',handler:function(){ openWin() }},"-",
			{text:'批量删除',iconCls:'icon-remove',handler: function(){deleteSelectFun()}},"-",
	        ]
	
})

var store = Ext.create('Ext.data.Store', {
    fields: ["id", "studentNum", "name","sex", "mobile","birth","age","classId"],
    pageSize: 10,  //页容量10条数据
    remoteSort: false,
    remoteFilter: true,
    listeners: {
        load: function (me, records, success, opts) {
            if (!success || !records || records.length == 0)
                return;

            //根据全局的选择，初始化选中的列
            var selModel = grid.getSelectionModel();
            Ext.Array.each(AllSelectedRecords, function () {
                for (var i = 0; i < records.length; i++) {
                    var record = records[i];
                    if (record.get("id") == this.get("id")) {
                        selModel.select(record, true, true);    //选中record，并且保持现有的选择，不触发选中事件
                    }
                }
            });
        }
    },
    proxy: {
        type: 'ajax',
        url: '${pageContext.request.contextPath}/student/findByPage.do',
        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
            type: 'json', //返回数据类型为json格式
            root: 'rows',  //数据
            pruneModifieRecords:true ,//store每次提交后自动清除modified标记
            totalProperty: 'total' //数据总条数
        }
   
    },
    sorters: [{
        property: 'studentNum',
    }],
    autoLoad: true  //即时加载数据
});
// selected array
var AllSelectedRecords = [];
var grid = Ext.create('Ext.grid.Panel', {
    renderTo: Ext.getBody(),
    store: store,
    layout:'fit',
    waitMsg : '正在加载数据请稍后',//提示信息                
    waitTitle : '提示',//标题    
    trackMouseOver : true, //鼠标移动时高亮显示
    selModel: Ext.create("Ext.selection.CheckboxModel", {
        mode: "MULTI",
        listeners: {
            deselect: function (me, record, index, opts) {

                AllSelectedRecords = Ext.Array.filter(AllSelectedRecords, function (item) {
                    return item.get("id") != record.get("id");
                });
            },
            select: function (me, record, index, opts) {
                AllSelectedRecords.push(record);
            }
        }
    }),   //选择框
    bbar: [{
        xtype: 'pagingtoolbar',
        store: store,
        displayMsg: '显示 {0} - {1} 条，共计 {2} 条',
        emptyMsg: "没有数据",
        beforePageText: "当前页",
        afterPageText: "共{0}页",
        displayInfo: true                 
    }],
   
    columns: [                    
                  { text: 'ID', dataIndex: 'id', align: 'left', width: 50,hidden:true },
                  { text: '学号', dataIndex: 'studentNum',  width: 80},
                  { text: '姓名', dataIndex: 'name',width:80},
                  { text: '性别', dataIndex: 'sex',width:50,
                	  renderer : function(value){
              			if (value){
              				return '男';
              			}else{
              				return '女';
              			}
              		}    
                  },
                  { text: '出生日期', dataIndex: 'birth',width:120},
                  { text: '学院', dataIndex: 'academyName',width:100},
                  { text: '年级', dataIndex: 'grade',width:60},
                  { text: '班别', dataIndex: 'className',width:60},
                  { text: '身份证', dataIndex: 'idCard',width:120},
                  { text: '状态', dataIndex: 'status',width:80,
                	  renderer : function(value){
                			if (value){
                  				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Button Check.png' />";;
                  			}else{
                  				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Error.png' />";
                  			}
                  		}    
                  
                  },
                {
                    xtype:'actioncolumn',
                    text: '操作选项',
                    width:330,
                    items: [
                     
                     {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Info.png',  // Use a URL in the icon config
                        tooltip: '查看',
                       
                        handler: function(grid, rowIndex, colIndex) {
                            var rec = grid.getStore().getAt(rowIndex);
                            var id = rec.get('id');
                            
                            openWin(id,true);
                        }
                       
                    },
                    "-",
                     {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Pencil_2.png',  // Use a URL in the icon config
                        tooltip: '编辑',
                       
                        handler: function(grid, rowIndex, colIndex) {
                            var rec = grid.getStore().getAt(rowIndex);
                            var id = rec.get('id');
                            
                            openWin(id);
                        }
                       
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Denided.png',
                    	altText : '删除',
                        tooltip: 'Delete',
                        handler: function(grid, rowIndex, colIndex) {
                        	 var rec = grid.getStore().getAt(rowIndex);
                             var id = rec.get('id');
                            // deleteFun(id);
                             deleteSelectFun(id);
                        }
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Button_Sync.png',
                    	altText : '更改',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var id = rec.get('id');
                            var aName = rec.get('academyName');
                            var grade = rec.get('grade');
                        	changeClassesWin(id,aName,grade,classId,store);
                        	
                        }
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/File_Table.png',
                    	altText : 'syllabus',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var id = rec.get('id');
                            var classId = rec.get('classId');
                            var grade = rec.get('grade');
                            studentSyllabus(id,classId,grade);
                        	
                        }
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/File_Edit.png',
                    	altText : '成绩登记',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var studentId = rec.get('id');
                            var classId = rec.get('classId');
                            var grade = rec.get('grade');
                        	scoreFuntion(studentId,classId,grade);
                        }
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Chart_Bar_Big.png',
                    	altText : '成绩统计',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var studentId = rec.get('id');
                        	resultStaticFuntion(studentId);
                        }
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Project.png',
                    	altText : '学生选课',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var studentId = rec.get('id');
                            studentSelectSubject(studentId);
                        }
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/TEST.gif',
                    	altText : '考试报名',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var studentId = rec.get('id');
                            studentTest(studentId);
                        }
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Test_Score.png',
                    	altText : '学生考试',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var studentId = rec.get('id');
                            studentTestRecord(studentId);
                        }
                    }
                ]
                },
       
   
               ],
   
    listeners: { 'itemclick': function (view, record, item, index, e) {
    }
    },
    dockedItems:[
			toolbarSelect
			
          
        	 ], 
    tbar:[toolbarCRUD,
{text:'excel导入',iconCls:'',handler: function(){
	if (''==classId){
		Ext.MessageBox.alert('警告','请选择班级');
	}else{
		openUpload(basePath+'student/importFromExcel.do','xls/xlsx',store,'','',classId);
	}
	
}
},"-",
{text:'导出excel',iconCls:'',handler: function(){
	var datas = grid.getSelectionModel().getSelection();
	 var ids = [];
	 for (var i=0;i<datas.length;i++){
	 	ids.push(datas[i].id);
	 }
	 ids = ids.join(',');
	 window.location.href = basePath+'student/exportToExcel.do?ids='+ids+"&classId="+classId;
	 
}},
"->",
{xtype:'label',text:'关键词：'},
		{xtype:'textfield',emptyText:'学生 ，模糊查询',
	 id:'KeyWord'
	 },
		{iconCls:'icon-search',
    	 text:'查询',
    	 handler:function(){
    		 var keyWord = grid.down('#KeyWord').getValue();
    		 
    		 store.reload({ params:{'keyWord' : keyWord,'academyId':academyId,
    			 'grade':grade,'classId':classId} });
    		 
    	 }
},
	{iconCls:'icon-remove',
	 text:'清除',
	 handler:function(){
		 grid.down('#KeyWord').setValue('');
		 var keyWord = grid.down('#KeyWord').getValue();
		 store.reload({ params:{'keyWord' : keyWord} });
	 }
},
	{
	 text:'高级查询',
	 handler:function(){
		 openSearchWin2(store,academyId,grade,classId);
	 }
	}
        	       
        	       ]
});

function openWin(id,isHidden){
	var url = '';
	var title= '';
	var icon = '';
	if ('' != id && null != id){
		url = '${pageContext.request.contextPath}/student/update.do';
		title = '编辑学生';
		icon = 'icon-edit';
	}else{
		url = '${pageContext.request.contextPath}/student/save.do';
		title = '新增学生';
		icon = 'icon-save';
		
	}
	 
	var form = new Ext.FormPanel({
	   	bodyStyle: 'padding:5px 5px 0',
	    layout: 'form',
	    autoScroll: true,
	    items: [
		{
			xtype: "container",
		    layout: "hbox",
		    items: [
		       
		            { xtype:'textfield', name:'academyName',value:academyName, fieldLabel:'学院', allowBlank: false,editable:false,width:180},
		            { xtype:'textfield', name:'grade', value : grade,fieldLabel:'年级', allowBlank: false,editable:false,width:180},
		            { xtype:'textfield', name:'className',value :className, fieldLabel:'班别', allowBlank: false,editable:false,width:180 },
		
		    ]
		},
		{
			xtype: "container",
		    layout: "hbox",
		    items: [
		       
		            { xtype:'textfield', name:'id', fieldLabel:'id', allowBlank: true,hidden:true},
		            { xtype:'textfield', name:'studentNum',id:'num', fieldLabel:'学号号', allowBlank: false,
		            	value : getNumStart()+'1',disabled:false,regex:/^[1-9]\d{6,10}$/,
		            	regexText: '请输入以年份后两位数字+代表数(u:0,s:1,t:2)为开头的7-11位数字(2016 u : 1610123)'},
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
	           
					{ xtype:'textfield',value:classId, name:'classId', fieldLabel:'aid', allowBlank: false,hidden:true},
					{ xtype:'textfield', name:'parentMobile', fieldLabel:'父母手机', allowBlank: false,editable:true},
	                { xtype:'datefield', name:'birth', fieldLabel:'出生日期', allowBlank: false ,format : 'Y-m-d',editable:false,
	                	maxValue : new Date()},
	              

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
	                
	                { xtype: "textfield", name: "password2", fieldLabel: "密码", allowBlank: false, value:"123456",
	                		inputType:'',maxLength: 16,regex:/^[a-zA-Z0-9]+$/,regexText:'只允许输入英文字母或数字' },

	        ]
	    },
	    {
	   	 xtype: "container",
	           layout: "hbox",
	           items: [
	               {xtype:'radiogroup', name:'userAccountStatus', fieldLabel:'状态',   allowBlank: false,
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
	           
	                { xtype:'datefield', name:'admissionDate', fieldLabel:'入学时间', allowBlank: false ,editable:false,format:'Y-m-d',maxValue: new Date()},
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
	    id : 'saveButton',
	    iconCls: 'icon-save',
	    handler: function () {
	    	if (form.isValid()) {
	    		// vaild userNum is repeat;
	    		var num = Ext.getCmp("num").getValue();
	    		var b = isRepeat(num);
	    		if (null != id && '' != id){
	    			b = true;
	    		}
	    		if (b){
		                form.submit({
		                	url: url,
		                	method: 'post',
		                    success: function(form,action) {
		                       store.reload();
		                       myMsg('操作提示',action.result.message);
		                       win.close(this);
		                       
		                    },
		                    failure: function(form,action) {

		                    	myMsg('操作提示',action.result.message);
		                    }
		                });
	    		}else{
	    			 Ext.MessageBox.alert('提示','该号码不可用！');
	    		}
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
            title: title,       //标题
            autoScroll: true,
            maximizable :true,
            draggable: true,
            constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
            iconCls: icon,
            height: 420,                          //高度
            width: 600,                           //宽度
            layout: "fit",                        //窗口布局类型
            modal: true, //是否模态窗口，默认为false
            resizable: false,
            items: [form]
        });
     	form.reset();
        if ('' != id && null != id){
        	Ext.getCmp("num").setDisabled(true);
        	if (isHidden){
        		
        	Ext.getCmp("saveButton").setVisible(false); 
        	}
        	loadData(form,id);
        }
        win.show();
}

function isRepeat(num){
	var b = false;
	$.ajax({
		url : '${pageContext.request.contextPath}/student/isRepeat.do',
		method: 'get',
		async: false,
		data : {
			'num' : num
		},
		dataType : 'json',
		success : function(r) {
			b= r.success;
		
		},
		 failure: function(r) {
				
               
            }
	});
	return b;
	
}

function loadData(form,id){
	 var selectedKeys = id;
     form.getForm().load({                    
          waitMsg : '正在加载数据请稍后',//提示信息                
          waitTitle : '提示',//标题                
          url : '${pageContext.request.contextPath}/student/findById.do',            
          params:{id:selectedKeys},                
          method:'GET',//请求方式             
          success:function(form,action){
        	
          },
          failure:function(form,action){//加载失败的处理函数                
              Ext.MessageBox.alert("提示","加载数据失败");     
              
          }            
     });        

 }

function deleteSelectFun(oid){
	var rows = grid.getSelectionModel().getSelection();
	var ids = [];
	if (rows.length > 0 || (null != oid && '' != oid)) {
		Ext.MessageBox.confirm('确认', '您是否要删除当前选中的项目？', function callback(id) {
			if (id == 'yes') {
				if (null != oid && '' != oid){
					ids.push(oid);
				}else{
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].data['id']);
					}
				}
				$.ajax({
					url : '${pageContext.request.contextPath}/student/delete.do',
					method: 'post',
					data : {
						//数组转为 字符串
						ids : ids.join(',')
					},
					dataType : 'json',
					success : function(r) {
						store.reload();
						myMsg('操作提示',r.message);
					},
					 failure: function(r) {

	                        myMsg('操作提示',r.message);
	                    }
				});
			}
		});
	} else {
		Ext.MessageBox.alert("警告!","请选择你需要删除的记录");
	}
	
}


</script>



</body>
</html>