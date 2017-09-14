<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SUBJECTARRANGEMENT</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<jsp:include page="studentTab.jsp"></jsp:include>
<jsp:include page="subjectSelect.jsp"></jsp:include>
<jsp:include page="subjectTeacher.jsp"></jsp:include>
<jsp:include page="scoreRecordPage.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/searchPanel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/FileUploadField.js"></script>
<script type="text/javascript">
var academyId = '';
var academyName = '';
var grade = '';
var classId = [];
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
				            	classId = [];
				            	var id = record.data.value;
				            	academyId = id;
				            	if (classId.length>0){
				            		toolbarCRUD.setDisabled(false);
				            	}else{
				            		toolbarCRUD.setDisabled(true);
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
				            	classId = [];
				            	if (classId.length>0){
				            		toolbarCRUD.setDisabled(false);
				            	}else{
				            		toolbarCRUD.setDisabled(true);
				            	}
				            	grade = record.data.value;
				            	if (''!=academyId && ''!=grade){
					            	classStore.getProxy().url = basePath+'classes/findIdAndName.do?academyId='+academyId+'&grade='+grade;
					            	classStore.load();
				            	}else{
					            	classStore.removeAll();
					            	Ext.getCmp('classes').setValue('');
				            		
				            	}
				            }
				          } 
				 },
				{ xtype: "combobox", name: "classes",id:'classes', fieldLabel:"班级",allowBlank:true,emptyText: '选择班级...',editable:false, padding:0,
				 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,multiSelect:true,
				 	store:classStore,
				       displayField:'name',
				 		 valueField:'value',
				 		 pageSize:6,
				 		 queryParam: 'keyWord',
				 		listeners :{
				            'select' : function(obj,record,opts){
				            	for (var i=0;i<record.length;i++){
				            		//classId.push(record[i].data.value);
				            		classId[i] = record[i].data.value;
				            	}
				            	if (classId.length>0){
				            		toolbarCRUD.setDisabled(false);
				            	}else{
				            		toolbarCRUD.setDisabled(true);
				            	}
				            	store.reload({params:{'classId':classId}});
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
			
	        ]
	
})

var store = Ext.create('Ext.data.Store', {
    fields: ["id", "subjectId", "teacherId","schoolYear","term"],
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
       	url: basePath+'subjectArrangement/findByPage.do',
        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
            type: 'json', //返回数据类型为json格式
            root: 'rows',  //数据
            pruneModifieRecords:true ,//store每次提交后自动清除modified标记
            totalProperty: 'total' //数据总条数
        }
   
    },
    sorters: [{
        property: 'subjectCode',
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
        mode: "SIMPLE",
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
                  { text: '学年', dataIndex: 'schoolYear',  width: 80},
                  { text: '学期', dataIndex: 'term',width:80},
                 
                  { text: '科目代码', dataIndex: 'subjectCode',width:120},
                  { text: '科目名称', dataIndex: 'subjectName',width:100},
                  { text: '科目册序', dataIndex: 'subjectVolumes',width:80},
                  { text: '教工工号', dataIndex: 'teacherNum',width:120},
                  { text: '任教教师', dataIndex: 'teacherName',width:80},
                  { text: '次数/周', dataIndex: 'weekTimes',width:60},
                  
                {
                    xtype:'actioncolumn',
                    text: '操作选项',
                    width:200,
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
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Blackboard_2.png',
                    	altText : '更改',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var id = rec.get('id');
                        	subjectSelect(store,id,classId);
                        	
                        }
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/User2.png',
                    	altText : '更改',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var id = rec.get('id');
                        	subjectTeacher(store,id,classId);
                        	
                        }
                    },
                    
                ]
                },
       
   
               ],
   
    listeners: { 'itemclick': function (view, record, item, index, e) {
    }
    },
    dockedItems:[
			toolbarSelect
			
          
        	 ], 
    tbar:[toolbarCRUD,{text:'批量删除',iconCls:'icon-remove',handler: function(){deleteSelectFun()}},"-",
{text:'excel导入',iconCls:'',handler: function(){
	if (''==classId){
		Ext.MessageBox.alert('警告','请选择班级');
	}else{
		//openUpload(basePath+'student/importFromExcel.do','xls/xlsx',store,'','',classId);
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
	// window.location.href = basePath+'student/exportToExcel.do?ids='+ids+"&classId="+classId;
	 
}},
"->",
{xtype:'label',text:'关键词：'},
		{xtype:'textfield',emptyText:'，模糊查询',
	 id:'KeyWord'
	 },
		{iconCls:'icon-search',
    	 text:'查询',
    	 handler:function(){
    		 var keyWord = grid.down('#KeyWord').getValue();
    		 
    		 store.reload({ params:{'keyWord' : keyWord,
    			 'classId':classId} });
    		 
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
		 //openSearchWin2(store,academyId,grade,classId);
	 }
	}
        	       
        	       ]
});

function openWin(id,isHidden){
	var url = '';
	var title= '';
	var icon = '';
	if ('' != id && null != id){
		url = '${pageContext.request.contextPath}/subjectArrangement/update.do';
		title = '编辑班级科目';
		icon = 'icon-edit';
	}else{
		url = '${pageContext.request.contextPath}/subjectArrangement/save.do';
		title = '新增班级科目';
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
		       
		            { xtype:'textfield', name:'id', fieldLabel:'id', allowBlank: true,hidden:true},
		            { xtype: "combobox", name: "schoolYear",id:'schoolYear', fieldLabel:"学年",allowBlank:false,emptyText: '选择学年...',editable:false, padding:0,
					 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
					 	store:Ext.create('Ext.data.Store', {
					         fields: ["value", "name"],
					            proxy: {
					                type: 'ajax',
					                url: basePath+'dictionary/findByType.do?type=schoolYear',
					            },
					            autoLoad: false,
					            pageSize : 8,
					            listeners:{  
					                 
					                }  
					             
					        }),
					       displayField:'name',
					 		 valueField:'value',
					 		 pageSize:8,
					 		 queryParam: 'keyWord',
					 		listeners :{
					            'select':function(obj, record,eOpts){
					            	
					            }
					          } 
					 },
		            { xtype: "combobox", name: "term",id:'term', fieldLabel:"学期",allowBlank:false,emptyText: '选择学学期...',editable:false, padding:0,
					 	forceSelection:false,selectOnFocus : true,width:184,labelWidth:30,
					 	store:Ext.create('Ext.data.Store', {
					         fields: ["value", "name"],
					            proxy: {
					                type: 'ajax',
					                url: basePath+'dictionary/findByType.do?type=term',
					            },
					            autoLoad: false,
					           // pageSize : 8,
					            listeners:{  
					                'load' : function(store, records, options ){      
					                   
					                }  
					            }  
					        }),
					       displayField:'name',
					 		 valueField:'value',
					 		// pageSize:8,
					 		 queryParam: 'keyWord',
					 		listeners :{
					            'select':function(obj, record,eOpts){
					            	
					            }
					          } 
					 },
		            
		
		    ]
		},
	    
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'numberfield', name:'weekTimes', fieldLabel:'节数/周', allowBlank: false ,minValue:2,maxValue:6},
	                { xtype:'textfield', name:'classId', fieldLabel:'', allowBlank: false ,value:classId[0],hidden:true},
	                { xtype:'textfield', name:'classId', fieldLabel:'', allowBlank: true ,value:classId[1],hidden:true},
	                { xtype:'textfield', name:'classId', fieldLabel:'', allowBlank: true ,value:classId[2],hidden:true},
	                { xtype:'textfield', name:'classId', fieldLabel:'', allowBlank: true ,value:classId[3],hidden:true},

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
	    		var b = true;
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
            width: 775,                           //宽度
            layout: "fit",                        //窗口布局类型
            modal: true, //是否模态窗口，默认为false
            resizable: false,
            items: [form]
        });
     	form.reset();
        if ('' != id && null != id){
        	if (isHidden){
        		
        	Ext.getCmp("saveButton").setVisible(false); 
        	}
        	loadData(form,grid);
        }
        win.show();
}

function isRepeat(num){
	var b = false;
	$.ajax({
		url : '${pageContext.request.contextPath}/subjectArrangement/isRepeat.do',
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

function loadData(form,grid){
	var record = grid.getSelectionModel().getSelection();  
	//form.loadRecord(record[0]);
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
					url : '${pageContext.request.contextPath}/subjectArrangement/delete.do',
					method: 'post',
					data : {
						//数组转为 字符串
						ids : ids.join(',')
					},
					dataType : 'json',
					success : function(r) {
						store.reload({params:{'classId':classId}});
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