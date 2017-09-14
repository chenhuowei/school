<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

var store = Ext.create('Ext.data.TreeStore', {
    proxy: {
      type: 'ajax',
      url: '${pageContext.request.contextPath}/menu/list.do'
    },
    
  });

var treePanel = Ext.create('Ext.tree.TreePanel', {  
	 icon: '${pageContext.request.contextPath}/jslib/icon/myIcon/Menu_mini.png', 
    region: 'west', 
    collapsible: true,
    width: 300,
    height: 350,
    root: {  
    	text: "服务列表",
        expanded: true,
        nodeType: 'async'  
    },  
    store: store,
    useArrows: true,
    leaf: true,
    width: 180 ,
    
    listeners : {
    	
    	itemcontextmenu: function (dataView,records,items,index,e){
			
    		dataView.menu = Ext.create('Ext.menu.Menu', {      

	                items:
	                    [
	                     {   
	                         text : '新增节点',   
	                         iconCls : 'leaf',  
	                         // 增加菜单点击事件   
	                         handler : function() {    
	                        	 //console.info(records.data.parentId);
	                        	 var pid = "";
	                        	if (!records.data.leaf && records.data.id != 'root'){
	                        	  pid = records.data.id;
	                        	}
	                        	 if (records.data.parentId != 'root'){
	                        		 pid = records.data.parentId;
	                        	 }
	                        	Ext.create('Ext.window.Window', {
	                         	    title: "新增节点",
	                         	    width: 300,
	                         	    height: 220,
	                         	    autoShow: false,
	                         	    closable:true,
	                         	    modal: true,
	                         	    layout: "fit",
	                         	    items: [
	                         	        {
	                         	            xtype: "form",
	                         	            defaultType: 'textfield',
	                         	            defaults: {
	                         	                anchor: '100%',
	                         	            },
	                         	            fieldDefaults: {
	                         	                labelWidth: 80,
	                         	                labelAlign: "left",
	                         	                flex: 1,
	                         	                margin: 10
	                         	            },
	                         	            items: [
	                         	                {
	                         	                    xtype: "container",
	                         	                    layout: "vbox",
	                         	                    items: [
	                         	                        { xtype: "textfield", name: "pid", fieldLabel: "pid", value: pid ,hidden: true},
	                         	                        { xtype: "textfield", name: "text", fieldLabel: "菜单名称", allowBlank: false },
	                         	                       { xtype: "combobox", name: "leaf", fieldLabel: "子叶选项", allowBlank: false, emptyText: '是否为子叶...',
	                        	                        	store: Ext.create('Ext.data.Store', {
	                        	                        	    fields: ['id', 'name'],
	                        	                        	    data : [
	                        	                        	        {"id":'true', "name":"是"},
	                        	                        	        {"id":'false', "name":"否"},
	                        	                        	        
	                        	                        	    ]
	                        	                        	}),
	                        	                        	 displayField:'name',
	                        	                        	 valueField:'id'
	                        	                        },
	                         	                        { xtype: "textfield", name: "url", fieldLabel: "链接地址", allowBlank: true ,emptyText: '仅为子叶时才生效...'  }
	                         	                    ]
	                         	                }
	                         	            ],
	                         	            buttons: [
	                         	          	        { xtype: "button", text: "确定", 
	                         	          	        	handler: function () {
	                     	    	          	        	var form = this.up('form').getForm();
	                     	    	          	        	var w = this.up('form').up('window');
	                     	    	          	            if (form.isValid()) {
	                     	    	          	                form.submit({
	                     	    	          	                	url: '${pageContext.request.contextPath}/menu/save.do',
	                     	    	          	                    success: function(form, action) {
	                     	    	          	                    	store.reload();
	                     	    	          	                    	w.close();
	                     	    	          	                    	myMsg('提示',action.result.message);
	                     	    	          	                       
	                     	    	          	                    },
	                     	    	          	                    failure: function(form, action) {

	                     	    	          	                        Ext.MessageBox.alert('提示', "新增失败");
	                     	    	          	                    }
	                     	    	          	                });
	                     	    	          	            }
	                     	    	          	        
	                         	          	        
	                         	          	        } },
	                         	          	        {xtype: 'button',text: '取消',
	                         	          	        	handler: function(){
	                     	    	          	        	var w = this.up('form').up('window');
	                     	    	          	        	w.close();
	                         	          	        	}	
	                         	          	        }
	                         	          	    ] 
	                         	        }
	                         	    ]
	                        		}).show();
	                           }  
	                    },   
	                     {   
	                         text : '修改节点',   
	                         iconCls : 'leaf',  
	                         // 增加菜单点击事件   
	                         handler : function() {
	                        	 var data = [];
	                        	
	                        	 for (var i=0;i<store.getTotalCount();i++){
	                        		var pids = [];
	                        		 if (!store.getAt(i).get("leaf")){
	                        			 if (store.getAt(i).get('id') != 'root'){
		                        			 pids.push(store.getAt(i).get('id'));
		                        			 pids.push(store.getAt(i).get('text'));
	                        			 }
	                        		 }
	                        		 if (pids.length >0){
	                        		 data.push(pids);
	                        			
	                        		 }
	                        	 }
	                        	 var pid = 0;
	                        	 if (records.data.parentId != 'root'){
	                        		 pid = records.data.parentId;
	                        	 }
	                        	Ext.create('Ext.window.Window', {
	                         	    title: "修改节点",
	                         	    width: 300,
	                         	    height: 300,
	                         	    autoShow: false,
	                         	    closable:true,
	                         	    modal: true,
	                         	    layout: "fit",
	                         	    items: [
	                         	        {
	                         	            xtype: "form",
	                         	            defaultType: 'textfield',
	                         	            defaults: {
	                         	                anchor: '100%',
	                         	            },
	                         	            fieldDefaults: {
	                         	                labelWidth: 80,
	                         	                labelAlign: "left",
	                         	                flex: 1,
	                         	                margin: 10
	                         	            },
	                         	            items: [
	                         	                {
	                         	                    xtype: "container",
	                         	                    layout: "vbox",
	                         	                    items: [
	                         	                        { xtype: "textfield", name: "id", fieldLabel: "id", value: records.id ,hidden: true},
	                         	                        { xtype: "textfield", name: "pid", fieldLabel: "pid", value: pid ,hidden: true},
	                         	                        { xtype: "textfield", name: "text", fieldLabel: "菜单名称",value:records.data.text, allowBlank: false },
	                         	                       { xtype: "combobox", name: "leaf", fieldLabel: "子叶选项",value:records.data.leaf, allowBlank: false, emptyText: '是否为子叶...',
	                        	                        	store: Ext.create('Ext.data.Store', {
	                        	                        	    fields: ['id', 'name'],
	                        	                        	    data : [
	                        	                        	        {"id":'true', "name":"是"},
	                        	                        	        {"id":'false', "name":"否"},
	                        	                        	        
	                        	                        	    ]
	                        	                        	}),
	                        	                        	 displayField:'name',
	                        	                        	 valueField:'id'
	                        	                        },
	                         	                       { xtype: "combobox", name: "pids", fieldLabel: "更改父节点",value:100,editable:false, allowBlank: true, emptyText: '更改父节点...',id:'pids',
	                        	                        	store: Ext.create('Ext.data.Store', {
	                        	                        	    fields: ['id', 'text'],
	                        	                        	    data : data,
	                        	                        	    listeners :{
	                        	                                    load:function(){
	                        	                                    }
	                        	                                  } 
	                        	                        	}),
	                        	                        	 displayField:'text',
	                        	                        	 valueField:'id'
	                        	                        },
	                         	                        { xtype: "textfield", name: "url", fieldLabel: "链接地址",value:records.data.url, allowBlank: true ,emptyText: '仅为子叶时才生效...'  }
	                         	                    ]
	                         	                }
	                         	            ],
	                         	            buttons: [
	                         	          	        { xtype: "button", text: "确定", 
	                         	          	        	handler: function () {
	                     	    	          	        	var form = this.up('form').getForm();
	                     	    	          	        	var w = this.up('form').up('window');
	                     	    	          	            if (form.isValid()) {
	                     	    	          	                form.submit({
	                     	    	          	                	url: '${pageContext.request.contextPath}/menu/update.do',
	                     	    	          	                    success: function(form, action) {
	                     	    	          	                    	store.reload();
	                     	    	          	                    	w.close();
	                     	    	          	                    	myMsg('提示',action.result.message);
	                     	    	          	                       
	                     	    	          	                    },
	                     	    	          	                    failure: function(form, action) {

	                     	    	          	                        Ext.MessageBox.alert('提示', "修改失败");
	                     	    	          	                    }
	                     	    	          	                });
	                     	    	          	            }
	                     	    	          	        
	                         	          	        
	                         	          	        } },
	                         	          	        {xtype: 'button',text: '取消',
	                         	          	        	handler: function(){
	                     	    	          	        	var w = this.up('form').up('window');
	                     	    	          	        	w.close();
	                         	          	        	}	
	                         	          	        }
	                         	          	    ] 
	                         	        }
	                         	    ]
	                        		}).show();
	                           }  
	                    },   
	                    {
	                        text:'重命名',
							handler:function(){
								 Ext.MessageBox.prompt("标题", "請輸入",  
	                                        function(btn, text) {  
									// console.info(records);
	                                            if (btn == "ok") {  
	                                                //records.data.text = text; 
	                                                Ext.Ajax.request({  
	                                                      url: '${pageContext.request.contextPath}/menu/update.do', 
	                                                      params:{  
	                                                          id : records.id,text : text,
	                                                          },  
	                                                      success:function(r)  
	                                                      { 
	                                                    	  myMsg('提示',"修改成功");
	                                                          store.reload();//数的重新加载  
	                                                         // treepanel.root.expand(true,false);  
	                                                      },  
	  
	                                                      failure:function(){  
	                                                          Ext.MessageBox.alert('提示','修改失败');  
	                                                      }  
	  
	                                                  });  
	                                            }  
	                                        }, this, false, // 表示文本框为多行文本框  
	                                        records.get('text'));  
	                            }  
	                    },
	                    {
	                        text:'删除节点',
	                        handler : function(){
	                        Ext.Msg.confirm("警告", "请确认是否删除选项", function (btn) {
	                        	if (btn == 'yes'){
	                        		 Ext.Ajax.request({  
                                        url: '${pageContext.request.contextPath}/menu/delete.do', 
                                        params:{  
                                            id : records.id,
                                            },  
                                        success:function(r)  
                                        { 
                                      	  myMsg('提示','删除成功');
                                            store.reload();//数的重新加载  
                                        },  

                                        failure:function(){  
                                            Ext.MessageBox.alert('提示','删除失败');  
                                        }  

                                    });  
	                            
	                        	}else{
	                        	}
	                        })

	                    	}
	                    }
	                    ]

	                });

    		            dataView.menu.showAt(e.getXY());

    		            e.stopEvent();  

    		        },
    	
       /* itemclick : function(tree, record, item, index, e, options) {
       		
    	   var nodeText = record.data.text, 
	          
           tabPanel = viewport.items.get(2), 
           tabBar = tabPanel.getTabBar(), 
           tabIndex;
           for (var i = 0; i < tabBar.items.length; i++) {
               if (tabBar.items.get(i).getText() === nodeText) {
                   tabIndex = i;
               }
           }
           
           if (Ext.isEmpty(tabIndex)) {
           	 if (!record.data.leaf){
                	return;
                }
               tabPanel.add({
                           title : record.data.text,
                           //bodyPadding : 10,
                           closable : true,
                           renderTo: Ext.getBody(),
                           
                           //loader: { url: record.data.url, scripts: true,autoLoad: true}
                     		html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" '
                         	+' src="${pageContext.request.contextPath}/'+record.data.url+'" '
                         	+' ></iframe>' 
                       }).show();
               tabIndex = tabPanel.items.length - 1;
           }
           tabPanel.setActiveTab(tabIndex);
    } */
   }
});  

</script>
