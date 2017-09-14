<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SUBJECT</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/FileUploadField.js"></script>
<script type="text/javascript">
	
var store = Ext.create('Ext.data.Store', {
    fields: ["id", "code", "category","subjectName", "version","credits","isRequest","isPublic","status"],
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
        url: '${pageContext.request.contextPath}/subject/findByPage.do',
        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
            type: 'json', //返回数据类型为json格式
            root: 'rows',  //数据
            pruneModifieRecords:true ,//store每次提交后自动清除modified标记
            totalProperty: 'total' //数据总条数
        }
   
    },
    sorters: [{
        property: 'code',
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
                  { text: '科目代码', dataIndex: 'code',  width: 80},
                  { text: '科目类别', dataIndex: 'category',width:80},
                  { text: '科目名称', dataIndex: 'subjectName',width:120,
                  },
                  { text: '学分', dataIndex: 'credits',width:120},
                  { text: '版本', dataIndex: 'version',width:120},
                  { text: '必修科目', dataIndex: 'isRequest',width:120
                	  ,renderer:function(value){
                		  if (value){
                			  return "是";
                		  }else{
                			  return "否";
                		  }
                	  }
                  },
                  { text: '公共科目', dataIndex: 'isPublic',width:120
                	  ,renderer:function(value){
                		  if (value){
                			  return "是";
                		  }else{
                			  return "否";
                		  }
                	  }
                  },
                 
                  { text: '账号状态', dataIndex: 'status',width:80,
                	  renderer : function(value){
                			if (value){
                  				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Button Check.png' />";
                  			}else{
                  				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Error.png' />";
                  			}
                  		}    
                  
                  },
                {
                    xtype:'actioncolumn',
                    text: '操作选项',
                    width:130,
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
                    }
                    ]
                },
       
   
               ],
   
    listeners: { 'itemclick': function (view, record, item, index, e) {
    }
    },
     tbar:[
     {text:'新增',iconCls:'icon-plus',handler:function(){ openWin() }},"-",
     {text:'批量删除',iconCls:'icon-remove',handler: function(){deleteSelectFun()}},"-",
     {text:'excel导入',iconCls:'',handler: function(){openUpload(basePath+'subject/importFromExcel.do','xls/xlsx',store)}},"-",
     {text:'导出excel',iconCls:'',handler: function(){
    	 
    	 window.location.href = basePath+'subject/exportToExcel.do';
     }},"-",
     
     "->",
     {xtype:'label',text:'关键词：'},
     		{xtype:'textfield',emptyText:'模糊查询,多个，分隔',
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
		url = '${pageContext.request.contextPath}/subject/update.do';
		title = '编辑科目';
		icon = 'icon-edit';
	}else{
		url = '${pageContext.request.contextPath}/subject/save.do';
		title = '录入科目';
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
		            { xtype:'textfield', name:'code',id:'code', fieldLabel:'科目代码', allowBlank: false,
		            	value : 'A',disabled:false,regex:/^[A]\d{4,11}$/,
		            	regexText: '请输入以A开头 的5-11个字符组成， 如:A10010'},
		            { xtype:'textfield', name:'category', fieldLabel:'科目类别', allowBlank: false },
		
		    ]
		},
	    
	   
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'subjectName', fieldLabel:'科目名称', allowBlank: false},
	                { xtype:'numberfield', name:'credits', fieldLabel:'学分', allowBlank: false,minValue:1,maxValue:5},

	        ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'version', fieldLabel:'版本', allowBlank: false ,
	                	},
	                { xtype:'textfield', name:'volumes', fieldLabel:'册序', allowBlank: false},

	        ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'application', fieldLabel:'应用方向', allowBlank: false ,width:550
	                	},
	               

	        ]
	    },
	    
	    {
	   	 xtype: "container",
	           layout: "hbox",
	           items: [
	               {xtype:'radiogroup', name:'isRequest', fieldLabel:'必修',   allowBlank: false,
	                      columnWidth:0.8,items: [  
	                          { boxLabel: '是', name: 'isRequest', inputValue: 'true' ,checked:'true'},   
	                          { boxLabel: '否', name: 'isRequest', inputValue: 'false',width:200 },  
	                         
	                      ]
	                  },
	               {xtype:'radiogroup', name:'isPublic', fieldLabel:'公共',   allowBlank: false,
	                      columnWidth:0.8,items: [  
	                          { boxLabel: '是', name: 'isPublic', inputValue: 'true' },   
	                          { boxLabel: '否', name: 'isPublic', inputValue: 'false',checked:'true' },  
	                         
	                      ]
	                  },
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
	               
	               { xtype: "textarea", name: "info", fieldLabel: "科目信息", allowBlank: false ,emptyText : '', grow:true, height:100,width:550,
	                   maxLength : 300,  }
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
	    		var num = Ext.getCmp("code").getValue();
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
            height: 350,                          //高度
            width: 600,                           //宽度
            layout: "fit",                        //窗口布局类型
            modal: true, //是否模态窗口，默认为false
            resizable: false,
            items: [form]
        });
     	form.reset();
        if ('' != id && null != id){
        	Ext.getCmp("code").setDisabled(true);
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
		url : '${pageContext.request.contextPath}/subject/isRepeat.do',
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
          url : '${pageContext.request.contextPath}/subject/findById.do',            
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
					url : '${pageContext.request.contextPath}/subject/delete.do',
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

