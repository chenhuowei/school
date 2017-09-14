<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
var scoreFuntion = function(studentId,classId,grade,isSelect){
	var schoolYear = '${schoolYearAtNow}';
	var term = '${termAtNow}';
	
	var comboName = 'subjectArrangementId';
	var comboUrl = basePath+'subjectArrangement/findByClassId.do?classId='+classId
		+'&schoolYear='+schoolYear+'&term='+term+'&teacherId=${user.id}';
	if (isSelect){
		comboName = 'selectSubjectId';
		comboUrl = basePath+'selectSubject/findIdAndName.do?teacherId=${user.id}'
		+'&schoolYear='+schoolYear+'&term='+term;
		}
	
var scoreStore = Ext.create('Ext.data.Store', {
    fields: ["id", "schoolYear","subjectName", "subjectCredits","commonScore", "testScore",
             "totalScore","point","isRebuild","rebuildScore"],
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
        url: '${pageContext.request.contextPath}/scoreRecord/findByPage.do?studentId='+studentId,
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
var scoreGrid = Ext.create('Ext.grid.Panel', {
    renderTo: Ext.getBody(),
    store: scoreStore,
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
        store: scoreStore,
        displayMsg: '显示 {0} - {1} 条，共计 {2} 条',
        emptyMsg: "没有数据",
        beforePageText: "当前页",
        afterPageText: "共{0}页",
        displayInfo: true                 
    }],
   
    columns: [                    
                  { text: 'ID', dataIndex: 'id', align: 'left', width: 50,hidden:true },
                  { text: '学年', dataIndex: 'schoolYear',  width: 80},
                  { text: '科目名称', dataIndex: 'subjectName',width:80},
                  { text: '册序', dataIndex: 'subjectVolumes',width:60},
                  { text: '学分', dataIndex: 'subjectCredits',width:80},
                  { text: '平时成绩', dataIndex: 'commonScore',width:80},
                  { text: '考试成绩', dataIndex: 'testScore',width:80},
                  { text: '总成绩', dataIndex: 'totalScore',width:80},
                  { text: '绩点', dataIndex: 'point',width:80},
                  { text: '重考', dataIndex: 'isRebuild',width:50,
                	  renderer : function(value){
              			if (value){
              				return '是';
              			}else{
              				return '否';
              			}
              		}    
                  },
                  { text: '重考成绩', dataIndex: 'rebuildScore',width:120},
                  
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
                    width:180,
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
                             deleteSelectFun(id);
                        }
                    },
                    
                ]
                },
       
   
               ],
   
    listeners: { 'itemclick': function (view, record, item, index, e) {
    }
    },
    tbar:[,
{text:'录入',id:'addButton',handler: function(){
	openWin();
	}
},
{text:'批量删除',iconCls:'',handler: function(){
	deleteSelectFun();
	}
},

"->",
{xtype:'label',text:'关键词：'},
		{xtype:'textfield',emptyText:'多个关键词，分隔',
	 id:'KeyWord2'
	 },
		{iconCls:'icon-search',
    	 text:'查询',
    	 handler:function(){
    		 var keyWord = scoreGrid.down('#KeyWord2').getValue();
    		 scoreStore.reload({ params:{'keyWord' : keyWord} });
    		 
    	 }
},
	{iconCls:'icon-remove',
	 text:'清除',
	 handler:function(){
		 scoreGrid.down('#KeyWord2').setValue('');
		 scoreStore.reload({ params:{'keyWord' : ''} });
	 }
},
        	       
        	       ]
});


function openWin(id,isHidden){
	var url = '';
	var title= '';
	var icon = '';
	if ('' != id && null != id){
		url = '${pageContext.request.contextPath}/scoreRecord/update.do';
		title = '编辑成绩';
		icon = 'icon-edit';
	}else{
		url = '${pageContext.request.contextPath}/scoreRecord/save.do';
		title = '录入成绩';
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
	    	                {xtype:'textfield',fieldLabel:'',name:'id',editable:false,hidden:true},
	    	                {xtype:'textfield',fieldLabel:'',name:'subjectIsRequired',editable:false,hidden:true},
	    	                {xtype:'textfield',fieldLabel:'',name:'studentId',allowblank:false,value:studentId,editable:false,hidden:true},
	    	                ]
	    	    },
	    {
	    	xtype: "container",
	        layout: "vbox",
	        items: [
				{ xtype: "combobox", name: comboName, fieldLabel:"考试科目",allowBlank:false,emptyText: '选择...',editable:false, padding:0,
				 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
				 	store:Ext.create('Ext.data.Store', {
				         fields: ["value", "name"],
				            proxy: {
				                type: 'ajax',
				                url: comboUrl,
				           	   
				            },
				            autoLoad: false,
				            pageSize : 10,
				            listeners:{  
				                'load' : function(store, records, options ){      
				                    
				                }  
				            }  
				        }),
				       displayField:'name',
				 		 valueField:'value',
				 		 pageSize:10,
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
	                {xtype:'textfield',fieldLabel:'学年',name:'schoolYear',allowblank:false,value:schoolYear,editable:false},
	                {xtype:'textfield',fieldLabel:'学期',name:'term',allowblank:false,value:term,editable:false},
	                ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	                {xtype:'textfield',fieldLabel:'平时成绩',name:'commonScore',allowblank:false,value:''},
	                {xtype:'textfield',fieldLabel:'考试成绩',name:'testScore',allowblank:false,value:''},
	                ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	                {xtype:'textfield',fieldLabel:'总成绩',name:'totalScore',allowblank:false,disabled:true},
	                {xtype:'textfield',fieldLabel:'绩点',name:'point',allowblank:false,disabled:true},
	                ]
	    },
	    {
		   	 xtype: "container",
		           layout: "hbox",
		           items: [
		                  {xtype:'textfield',fieldLabel:'重考成绩',name:'rebuildScore',},
		               {xtype:'radiogroup', name:'userAccountStatus', fieldLabel:'重考',   allowBlank: false,
		                      columnWidth:0.8,items: [  
		                          { boxLabel: '是', name: 'isRebuild', inputValue: 'true' },   
		                          { boxLabel: '否', name: 'isRebuild', inputValue: 'false',checked:'true' },  
		                         
		                      ]
		                  },
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
	    	
	    		
		                form.submit({
		                	url: url,
		                	method: 'post',
		                    success: function(form,action) {
		                    	scoreStore.reload();
		                       myMsg('操作提示',action.result.message);
		                       win.close(this);
		                       
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
     	if (isHidden){
     		
     	Ext.getCmp("saveButton").setVisible(false); 
     	}
     	loadData(form,id);
     }
     win.show();
}


function loadData(form,id){
	 var selectedKeys = id;
    form.getForm().load({                    
         waitMsg : '正在加载数据请稍后',//提示信息                
         waitTitle : '提示',//标题                
         url : '${pageContext.request.contextPath}/scoreRecord/findById.do',            
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
	var rows = scoreGrid.getSelectionModel().getSelection();
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
					url : '${pageContext.request.contextPath}/scoreRecord/delete.do',
					method: 'GET',
					data : {
						//数组转为 字符串
						ids : ids.join(',')
					},
					dataType : 'json',
					success : function(r) {
						scoreStore.reload();
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


var scoreWin = Ext.create("Ext.window.Window", {

	title:'学生成绩',
    maximizable :true,
   // renderTo: Ext.getBody(),
    draggable: true,
    constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
    height: 300,                          //高度
    width: 600,                           //宽度
    layout: "fit",                        //窗口布局类型
    modal: true, //是否模态窗口，默认为false
    resizable: false,
    items: [scoreGrid],
    tbar: [
			{ xtype: "combobox", name: "schoolYear",id:'schoolYear1', fieldLabel:"学年",allowBlank:false,emptyText: '选择学年...',editable:false, padding:0,
			 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
			 	store:Ext.create('Ext.data.Store', {
			         fields: ["value", "name"],
			            proxy: {
			                type: 'ajax',
			                url: basePath+'dictionary/findByGrade.do?grade='+grade,
			            },
			            autoLoad: true,
			            pageSize : 8,
			        }),
			       displayField:'name',
			 		 valueField:'value',
			 		 pageSize:8,
			 		 queryParam: 'keyWord',
			 		listeners:{
			 			'select':function(combo,record,opts){
			 				schoolYear = record.data.value;
			 				scoreStore.reload({params:{'schoolYear':schoolYear,'term':term}});
			 			},
			 			'render':function(combo,record,opts){
			 				schoolYear = '${schoolYearAtNow}';
			 				combo.setValue(schoolYear);
			 				scoreStore.reload({params:{'schoolYear':schoolYear,'term':term}});
			 			}
			 		}
			 },
			{ xtype: "combobox", name: "term",id:'term1', fieldLabel:"学期",allowBlank:false,emptyText: '选择学学期...',editable:false, padding:0,
			 	forceSelection:false,selectOnFocus : true,width:184,labelWidth:30,
			 	store:Ext.create('Ext.data.Store', {
			         fields: ["value", "name"],
			            proxy: {
			                type: 'ajax',
			                url: basePath+'dictionary/findByType.do?type=term',
			            },
			            autoLoad: true,
			           // pageSize : 8,
			            
			        }),
			       displayField:'name',
			 		 valueField:'value',
			 		// pageSize:8,
			 		 queryParam: 'keyWord',
			 		listeners:{
			 			'select':function(combo,record,opts){
			 				term = record.data.value;
			 				scoreStore.reload({params:{'schoolYear':schoolYear,'term':term}});
			 				
			 			},
			 				'render':function(combo,record,opts){
				 				term = '${termAtNow}';
				 				combo.setValue(term);
				 				scoreStore.reload({params:{'term':term}});
				 			}
			 		}
			 },
   	   ]
});
	scoreWin.show();



}

</script>



