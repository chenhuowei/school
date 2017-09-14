<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="subjectSelect.jsp"></jsp:include>
<jsp:include page="subjectTeacher.jsp"></jsp:include>
<script type="text/javascript">

	var subjectList = function(classId,grade){
		
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
		            var selModel = subjectGrid.getSelectionModel();
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
		       	url: basePath+'subjectArrangement/findByPage.do?classId='+classId,
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
		var subjectGrid = Ext.create('Ext.grid.Panel', {
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
		    
	tbar:[
	      {text:'录入',handler:function(){ openWin()}},
	      {text:'批量删除',handler:function(){deleteSelectFun()}},
		"->",
		{xtype:'label',text:'关键词：'},
				{xtype:'textfield',emptyText:'科目教师，模糊查询',
			 id:'KeyWord1'
			 },
				{iconCls:'icon-search',
		    	 text:'查询',
		    	 handler:function(){
		    		 var keyWord = subjectGrid.down('#KeyWord1').getValue();
		    		 
		    		 store.reload({ params:{'keyWord' : keyWord
		    			} });
		    		 
		    	 }
		},
			{iconCls:'icon-remove',
			 text:'清除',
			 handler:function(){
				 subjectGrid.down('#KeyWord1').setValue('');
				 var keyWord = subjectGrid.down('#KeyWord1').getValue();
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
        
        
		 var subjectWin = Ext.create("Ext.window.Window", {
	            title: '班级课程',       //标题
	            autoScroll: true,
	            maximizable :true,
	            draggable: true,
	            constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
	            iconCls: '',
	            height: 350,                          //高度
	            width: 800,                           //宽度
	            layout: "fit",                        //窗口布局类型
	            modal: true, //是否模态窗口，默认为false
	            resizable: false,
	            items: [subjectGrid]
	        });
		 
		 subjectWin.show();
        
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
					    layout: "vbox",
					    items: [
					       
					            { xtype:'textfield', name:'id', fieldLabel:'id', allowBlank: true,hidden:true},
					            { xtype: "combobox", name: "schoolYear",id:'schoolYear', fieldLabel:"学年",allowBlank:false,emptyText: '选择学年...',editable:false, padding:0,
								 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
								 	store:Ext.create('Ext.data.Store', {
								         fields: ["value", "name"],
								            proxy: {
								                type: 'ajax',
								                url: basePath+'dictionary/findByGrade.do?grade='+grade,
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
				           
				                { xtype:'numberfield', name:'weekTimes', fieldLabel:'次数(2节)/周', allowBlank: false ,minValue:1,maxValue:8},
				                { xtype:'textfield', name:'classId', fieldLabel:'', allowBlank: false ,value:classId,hidden:true},

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
		            height: 200,                          //高度
		            width: 400,                           //宽度
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
		 function loadData(form,rec){
				form.loadRecord(rec);
			 }

			function deleteSelectFun(oid){
				var rows = subjectGrid.getSelectionModel().getSelection();
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

		
	}




</script>
