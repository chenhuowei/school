<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SELECTSUBJECT</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<jsp:include page="studentPanel.jsp"></jsp:include>
<script type="text/javascript">

var store = Ext.create('Ext.data.Store', {
    fields: ["id","schoolYear","term","subjectCode","subjectName","teacherName","locationName"],
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
       	url: basePath+'selectSubject/findByPage.do?teacherId=${sessionScope.user.id}',
        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
            type: 'json', //返回数据类型为json格式
            root: 'rows',  //数据
            pruneModifieRecords:true ,//store每次提交后自动清除modified标记
            totalProperty: 'total' //数据总条数
        }
   
    },
    sorters: [{
        property: 'schoolYear',
    }],
    autoLoad: true  //即时加载数据
});
// selected array
var AllSelectedRecords = [];
var grid = Ext.create('Ext.grid.Panel', {
    //renderTo: Ext.getBody(),
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
                 
                  { text: '科目类型', dataIndex: 'catagory',width:120},
                  { text: '科目名称', dataIndex: 'subjectName',width:150},
                  { text: '任教教师', dataIndex: 'teacherName',width:80},
                  { text: '上课地点', dataIndex: 'locationName',width:120},
                  { text: '上课周', dataIndex: 'classWeek',width:80},
                  { text: '上课次序', dataIndex: 'classTime',width:80},
                  
                {
                    xtype:'actioncolumn',
                    text: '操作选项',
                    width:200,
                    items: [
                            "-",
                            {
                            	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/User2.png',
                            	altText : '',
                                tooltip: 'student',
                                handler: function(grid, rowIndex, colIndex) {
                                	var rec = grid.getStore().getAt(rowIndex);
                                    container.remove('studentGrid',true);
                                    var selectSubjectId = rec.get('id');
                                    var aName = rec.get('subjectName');
                                    var sgrid = studentGrid('',selectSubjectId,true);
                                    sgrid.setTitle(aName+name+'选课-学生信息');
                                    container.add(sgrid);
                                    
                                }
                            },'-',
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
                            
                            openWin(rec);
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
                   
                   
                ]
                },
       
   
               ],
   
    
    tbar:[
		{text:'录入',iconCls:'',handler: function(){openWin();}},
          {text:'批量删除',iconCls:'',handler: function(){deleteSelectFun()}},
"->",
{xtype:'label',text:'关键词：'},
		{xtype:'textfield',emptyText:'多个关键词，分隔 ',
	 id:'KeyWord'
	 },
		{iconCls:'icon-search',
    	 text:'查询',
    	 handler:function(){
    		 var keyWord = grid.down('#KeyWord').getValue();
    		 
    		 store.reload({ params:{'keyWord' : keyWord} });
    		 
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
        	       
        	       ]
});

function openWin(id,isHidden){
	var url = '';
	var title= '';
	var icon = '';
	if ('' != id && null != id){
		url = '${pageContext.request.contextPath}/selectSubject/update.do';
		title = '编辑选课科目';
		icon = 'icon-edit';
	}else{
		url = '${pageContext.request.contextPath}/selectSubject/save.do';
		title = '新增选课科目';
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
		            { xtype:'textfield', name:'teacherId',value:'${sessionScope.user.id}', fieldLabel:'tid', allowBlank: false,hidden:true},
		            { xtype:'textfield', name:'schoolYear', value:'${schoolYearAtNow}',fieldLabel:'学年', allowBlank: false},
		            { xtype:'textfield', name:'term',value:'${termAtNow}', fieldLabel:'学期', allowBlank: false,},
		            
		           
					
		            
		
		    ]
		},
		{
	    	xtype: "container",
	        layout: "vbox",
	        items: [
				{ xtype: "combobox", name: "category",id:'category', fieldLabel:"科目类型",allowBlank:false,emptyText: '选择类型...',editable:false, padding:0,
				 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
				 	store:Ext.create('Ext.data.Store', {
				         fields: ["value", "name"],
				            proxy: {
				                type: 'ajax',
				                url: basePath+'dictionary/findByType.do?type=category',
				           	   
				            },
				            autoLoad: true,
				            pageSize : 8,
				            listeners:{  
				                'load' : function(store, records, options ){      
				                    
				                }  
				            }  
				        }),
				       displayField:'name',
				 		 valueField:'value',
				 		 pageSize:8,
				 		 queryParam: 'keyWord',
				 		listeners :{
				            'select':function(obj, record,eOpts){
				            	var s = Ext.getCmp('subject');
				            	
				            	s.setValue('');
				            	store = s.getStore();
				            	store.getProxy().url = basePath+'subject/findIdAndNameByCategory.do?category='+record.data.value;
				            	store.load()
				            }
				          } 
				 },
				{ xtype: "combobox", name: "subjectId",id:'subject', fieldLabel:"上课科目",allowBlank:false,emptyText: '选择科目...',editable:false, padding:0,
				 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
				 	store:Ext.create('Ext.data.Store', {
				         fields: ["value", "name"],
				            proxy: {
				                type: 'ajax',
				                url: '',
				           	   
				            },
				            autoLoad: true,
				            pageSize : 8,
				            listeners:{  
				                'load' : function(store, records, options ){      
				                    
				                }  
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
				
	        ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'startTime', fieldLabel:'开始时间', allowBlank: false ,value:'第二周'},
					 { xtype:'textfield', name:'endTime', fieldLabel:'结束时间', allowBlank: false ,value:'第十六周'},

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
        	loadData(form,id);
        }
        win.show();
}



function loadData(form,id){
	 form.loadRecord(id);    
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
					url : '${pageContext.request.contextPath}/selectSubject/delete.do',
					method: 'get',
					data : {
						//数组转为 字符串
						ids : ids.join(',')
					},
					dataType : 'json',
					success : function(r) {
						store.reload({params:{}});
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


var container = Ext.create('Ext.container.Container', {
    renderTo: Ext.getBody(),
    items: [grid]
});



</script>



</body>
</html>