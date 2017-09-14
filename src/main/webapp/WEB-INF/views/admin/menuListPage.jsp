<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MENULIST</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<script type="text/javascript">
	var type = '';
var store = Ext.create('Ext.data.Store', {
    fields: ["id", "text", "url","icon", "handler","width","height",'type'],
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
        url: '${pageContext.request.contextPath}/menuList/findByPage.do',
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
                  { text: '菜单类型', dataIndex: 'type',  width: 80,
						renderer: function(value){
							if (value == 'teacher'){
								return '教工菜单';
							}
							if (value == 'student'){
								return '学生菜单';
							}
						}                	  
                  },
                  { text: '显示文本', dataIndex: 'text',  width: 80},
                  { text: '链接地址', dataIndex: 'url',width:250},
                  { text: '显示图标', dataIndex: 'icon',width:80,
                	  
                  },
                  { text: '处理函数', dataIndex: 'handler',width:80},
                  { text: '宽度', dataIndex: 'width',width:80},
                  { text: '高度', dataIndex: 'height',width:80,},
                  { text: '父元素', dataIndex: 'pid',width:120,
                  		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store){
                  			var rec = store.findRecord('id',value);
                  			if (rec != null && rec != ''){
                  			return rec.get('text');
                  				
                  			}else{
                  				return '';
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
                            
                            openWin(rec,true);
                        }
                       
                    },
                    "-",
                     {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Pencil_2.png',  // Use a URL in the icon config
                        tooltip: '编辑',
                       
                        handler: function(grid, rowIndex, colIndex) {
                            var rec = grid.getStore().getAt(rowIndex);
                            
                            
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
    
     "->",
     {xtype:'label',text:'关键词：'},
     		{xtype:'textfield',emptyText:'多个 ，分隔 查询',
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
		url = '${pageContext.request.contextPath}/menuList/update.do';
		title = '编辑';
		icon = 'icon-edit';
	}else{
		url = '${pageContext.request.contextPath}/menuList/save.do';
		title = '录入';
		icon = 'icon-save';
		
	}
	 
	var form = new Ext.FormPanel({
	   	bodyStyle: 'padding:5px 5px 0',
	    layout: 'form',
	    items: [
		{
			xtype: "container",
		    layout: "vbox",
		    items: [
		       
				{
					xtype: "container",
				    layout: "hbox",
				    items: [
				       
						{xtype:'radiogroup', name:'type', fieldLabel:'菜单类型',   allowBlank: false
							,width:300,id:'type',
						    items: [  
						        { boxLabel: '学生菜单', name: 'type', inputValue: 'student' },  
						        { boxLabel: '教工菜单', name: 'type', inputValue: 'teacher' },   
						       
						    ],
						    listeners:{  
			                 	'change':function(r,newV,oV,eopts){
			                 		type = newV.type;
			                 		Ext.getCmp('pid').getStore().getProxy().url=basePath+'menuList/findIdAndText.do?type='+type;
			                 		Ext.getCmp('pid').setDisabled(false);
			                 	}
			                }  
						},
				
				    ]
				},
						            
		            { xtype: "combobox", name: "pid",id:'pid', fieldLabel:"父菜单",editable:false, padding:0,
					 	forceSelection:true,selectOnFocus : true,width:366,labelWidth:30,disabled:true,
					 	store:Ext.create('Ext.data.Store', {
					         fields: ["id", "text"],
			            proxy: {
			                type: 'ajax',
			                url: basePath+'menuList/findIdAndText.do?type='+type,
			            },
			            autoLoad: false,
			            pageSize : 8,
			            listeners:{  
			                 	'load':function(store,rec,isOk,eopts){
			                 		
			                 	}
			                }  
			             
			        }),
			       displayField:'text',
			 		 valueField:'id',
			 		 pageSize:8,
			 		listeners :{
			            'focus':function(obj, record,eOpts){
			            	
			            }
			          } 
			 },
			 ]
		},
		
		{
			xtype: "container",
		    layout: "hbox",
		    items: [
		       
		            { xtype:'textfield', name:'id', fieldLabel:'id', allowBlank: true,hidden:true},
		            { xtype:'textfield', name:'text', fieldLabel:'显示文本', allowBlank: false ,width:550},
		
		    ]
		},
	    
	   
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'url', fieldLabel:'链接地址', allowBlank: false,width:550},

	        ]
	    },
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'textfield', name:'icon', fieldLabel:'显示图标', allowBlank: true ,width:550
	                	},

	        ]
	    },
	    
	    {
	   	 xtype: "container",
	           layout: "hbox",
	           items: [
	              
	                { xtype:'numberfield', name:'width', fieldLabel:'宽度', allowBlank: true ,width:550,minValue:1},
	           ]
	   }, 
	    
	    {
	    	xtype: "container",
	        layout: "hbox",
	        items: [
	           
	                { xtype:'numberfield', name:'height', fieldLabel:'高度',minValue:1, allowBlank: true ,width:550},

	        ]
	    },
	    
	    {
	   	 xtype: "container",
	           layout: "hbox",
	           items: [
	               
	               { xtype: "textarea", name: "remark", fieldLabel: "备注", allowBlank: true , grow:true, height:100,width:550,
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



function loadData(form,id){
	 form.getForm().loadRecord(id);
        

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
					url : '${pageContext.request.contextPath}/menuList/delete.do',
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

