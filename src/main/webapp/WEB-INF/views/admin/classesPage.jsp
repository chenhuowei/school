<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Classes</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<jsp:include page="classSubject.jsp"></jsp:include>
<jsp:include page="classSyllabus.jsp"></jsp:include>
<jsp:include page="autoLayout.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/FileUploadField.js"></script>
<script type="text/javascript">

var url = '${pageContext.request.contextPath}/classes/findByPage.do';
var academyId = '';
var academyName = '';
var toolbarCRUD = Ext.create('Ext.Toolbar',{
	dock : 'top',
	disabled: true,
	items :[
			{text:'新增',iconCls:'icon-plus',handler:function(){ openWin() }},"-",
			{text:'批量删除',iconCls:'icon-remove',handler: function(){deleteSelectFun()}},"-",
			{text:'excel导入',iconCls:'',handler: function(){openUpload(basePath+'classes/importFromExcel.do','xls/xlsx',store)}},"-",
			{text:'导出excel',iconCls:'',handler: function(){
				 
				 window.location.href = basePath+'classes/exportToExcel.do';
			}},"-",
	        ]
	
})


var toolbarSelect = Ext.create('Ext.toolbar.Toolbar', {
    dock : 'top',
    items : [ 
			{ xtype: "combobox", name: "academy",id:'academy', fieldLabel:"学院",allowBlank:false,emptyText: '选择学院...',editable:false, 
			 	forceSelection:true,selectOnFocus : true,width:396,labelWidth:30,
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
			                    var data ={ "value": "", "name": "不限制"};      
			                    var rs = [new Ext.data.Record(data)];      
			                    store.insert(0,rs);  
			                }  
			            }  
			        }),
			       displayField:'name',
			 		 valueField:'value',
			 		 pageSize:6,
			 		 queryParam: 'keyWord',
			 		listeners :{
			            'change':function(obj, newValue, oldValue, eOpts){
			            	if (newValue == null){
			            		newValue = '';
			            	}
			            	academyId = newValue;
			            	if (''!=academyId){
			       		     	toolbarCRUD.setDisabled(false);
			            	}else{
			       		     	toolbarCRUD.setDisabled(true);
			            	}
			            	academyName = obj.rawValue;
			            	//store.reload({ params:{'academyId' : academyId} });
			            	store.getProxy().url = '${pageContext.request.contextPath}/classes/findByPage.do?academyId='+academyId ;
			            	store.load();
			            }
			          } 
			 }
             
         ]
});

var store = Ext.create('Ext.data.Store', {
    fields: ["id", "grade", "number","name", "major","head","headMobile","academicDegree","status"],
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
        url: url,
        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
            type: 'json', //返回数据类型为json格式
            root: 'rows',  //数据
            pruneModifieRecords:true ,//store每次提交后自动清除modified标记
            totalProperty: 'total' //数据总条数
        }
   
    },
    sorters: [{
        property: 'name',
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
                  { text: '学院', dataIndex: 'academyName',  width: 100},
                  { text: '年级', dataIndex: 'grade',  width: 80},
                  { text: '班级序号', dataIndex: 'number',width:80},
                  { text: '班别', dataIndex: 'name',width:80,
                	  
                  },
                  { text: '班主任', dataIndex: 'head',width:120},
                  { text: '班主任手机', dataIndex: 'headMobile',width:120},
                  { text: '学历层次', dataIndex: 'academicDegree',width:120},
                 
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
                    width:160,
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
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/File_Text.png',
                    	altText : '开课科目',
                        tooltip: 'subject',
                        handler: function(grid, rowIndex, colIndex) {
                        	 var rec = grid.getStore().getAt(rowIndex);
                             var classId = rec.get('id');
                             var grade = rec.get('grade');
                        	subjectList(classId,grade);
                        }
                    },
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/File_Table.png',
                    	altText : '课程表',
                        tooltip: 'syllabus',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var classId = rec.get('id');
                            var grade = rec.get('grade');
                        	classSyllabus(classId,grade);
                        }
                    }
                    ]
                },
       
   
               ],
   
    listeners: { 'itemclick': function (view, record, item, index, e) {
    }
    },
     tbar:[toolbarSelect,toolbarCRUD,"-",{text:'自动排课',handler:function(){  autoLayout()  }},"-",
     "->",
     {xtype:'label',text:'关键词：'},
     		{xtype:'textfield',emptyText:'班级信息 ，模糊查询',
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
    		{
        	 text:'高级查询',
        	 handler:function(){
        		 myAlertMsg('提示','此功能暂未开放，敬请期待');
        	 }
     	}
        	 ], 
});


function openWin(id,isHidden){
	var url = '';
	var title= '';
	var icon = '';
	if ('' != id && null != id){
		url = '${pageContext.request.contextPath}/classes/update.do';
		title = '编辑班级';
		icon = 'icon-edit';
	}else{
		url = '${pageContext.request.contextPath}/classes/save.do';
		title = '录入班级';
		icon = 'icon-save';
		
	}
	 
	var form = new Ext.FormPanel({
	   	bodyStyle: 'padding:5px 5px 0',
	    layout: 'form',
	    items: [
		{
			xtype: "container",
		    layout: "hbox",
		    items: [
		       
		            { xtype:'textfield', name:'id', fieldLabel:'id', allowBlank: true,hidden:true},
		            { xtype:'textfield',value:academyId, name:'academyId', fieldLabel:'aid', allowBlank: false,hidden:true},
		            { xtype:'textfield',value:academyName, name:'academyName', fieldLabel:'学院名称', allowBlank: false,editable:false},
		           
		
		    ]
		},
	    
	   
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
					{ xtype: "combobox", name: "grade", fieldLabel:"学年年级",allowBlank:false,emptyText: '',editable:false,id:'grade',
						forceSelection:true,selectOnFocus : true,width:396,
						store:Ext.create('Ext.data.Store', {
					        fields: ["name", "value"],
					           proxy: {
					               type: 'ajax',
					               url: basePath+'dictionary/findByType.do?type=grade',
					          	   
					           },
					           autoLoad: true,
					           pageSize : 6
					       }),
					      displayField:'name',
							 valueField:'value',
							 pageSize:6,
							 queryParam: 'keyWord',
						listeners : {
							
							
						}
					},

	        ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'number', fieldLabel:'班级序号', allowBlank: false,
	                	regex:/^\d{2}$/,regexText:'请输入两位数字'
	                },
	                { xtype:'textfield', name:'name',id:'name', fieldLabel:'班别', allowBlank: true,editable:false,
		            	value : '',disabled:true,regex:/^[1-9]\d{3}$/,
		            	regexText: '请输入以年级后两位数字为开头的4位数字(2016 : 1601)'},
	        ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'head', fieldLabel:'班主任', allowBlank: false},
	                { xtype:'textfield', name:'headMobile', fieldLabel:'班主任手机', allowBlank: false,vtype:'mobilephone' },

	        ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'academicYear', fieldLabel:'学制',value:'4', allowBlank: false,regex:/^\d{1}$/ },
	                {xtype:'radiogroup', name:'userAccountStatus', fieldLabel:'学历层次',   allowBlank: false,
	                      columnWidth:0.8,items: [  
	                          { boxLabel: '本科层次', name: 'academicDegree', inputValue: '本科' ,checked:'true'},   
	                          { boxLabel: '专科层次', name: 'academicDegree', inputValue: '专科' },  
	                         
	                      ]
	                  },

	        ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'major', fieldLabel:'专业方向', allowBlank: false},
	                { xtype:'textfield', name:'capacity', fieldLabel:'计划人数', allowBlank: false,regex:/^\d{2}$/,regexText:'仅限10-99' },

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
	           
	                { xtype:'textfield', name:'createTime', fieldLabel:'创建时间', allowBlank: true ,disabled:true,},
	                { xtype:'textfield', name:'updateTime', fieldLabel:'更新时间', allowBlank: true ,disabled:true,},

	        ]
	    },
	    
	    {
	   	 xtype: "container",
	           layout: "hbox",
	           items: [
	               
	               { xtype: "textarea", name: "remark", fieldLabel: "备注",defaultValue :'  ', allowBlank: true ,emptyText : '备注文本300字以内', grow:true, height:100,width:550,
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
	    		var num = Ext.getCmp("name").getValue();
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
            height: 350,                          //高度
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


function isRepeat(num){
	var b = false;
	$.ajax({
		url : '${pageContext.request.contextPath}/classes/isRepeat.do',
		method: 'get',
		async: false,
		data : {
			code : num
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
          url : '${pageContext.request.contextPath}/classes/findById.do',            
          params:{id:selectedKeys},                
          method:'GET',//请求方式             
          success:function(form,action){
        	var grade = action.result.data.grade;
    		 form.findField('grade').setValue(grade);
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
					url : '${pageContext.request.contextPath}/classes/delete.do',
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

