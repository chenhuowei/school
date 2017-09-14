<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

	var classSyllabus = function(classId,grade){
		var schoolYear='${sessionScope.schoolYearAtNow}';
		var term = '${sessionScope.termAtNow}';
		var toolbarSelect = Ext.create('Ext.toolbar.Toolbar', {
		    dock : 'top',
		    items : [ 
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
						 				store.reload({params:{'term':term,'schoolYear':schoolYear}});
						 			},
						 			'render':function(combo,record,opts){
						 				//schoolYear = '${sessionScope.schoolYearAtNow}';
						 				combo.setValue(schoolYear);
						 				store.reload({params:{'term':term,'schoolYear':schoolYear}});
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
						 				store.reload({params:{'term':term,'schoolYear':schoolYear}});
						 			},
						 			'render':function(combo,record,opts){
						 				//term = '${sessionScope.termAtNow}';
						 				combo.setValue(term);
						 				store.reload({params:{'term':term,'schoolYear':schoolYear}});
						 			}
						 		}
						 },
						
		             
		         ]
		});
		var store = Ext.create('Ext.data.Store', {
		    fields: ["id", "subjectName", "locationName","teacherName","classWeek","classTime"],
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
		       	url: basePath+'syllabus/getSyllabus.do?classId='+classId,
		        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
		            type: 'json', //返回数据类型为json格式
		            root: 'rows',  //数据
		            pruneModifieRecords:true ,//store每次提交后自动清除modified标记
		            totalProperty: 'total' //数据总条数
		        }
		   
		    },
		    sorters: [{
		        property: 'classWeek',
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
		                  { text: '星期', dataIndex: 'classWeek',  width: 80},
		                  { text: '次序', dataIndex: 'classTime',width:80},
		                 
		                  { text: '科目名称', dataIndex: 'subjectName',width:120},
		                  { text: '任教教师', dataIndex: 'teacherName',width:100},
		                  { text: '上课地点', dataIndex: 'locationName',width:150},
		                  
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
		                   
		                    
		                ]
		                },
		       
		   
		               ],
		   
		    listeners: { 'itemclick': function (view, record, item, index, e) {
		    }
		    },
		    
	tbar:[
	      toolbarSelect,{text:'预览',handler:function(){showTable(classId,schoolYear,term)}},
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
				           
				                { xtype:'numberfield', name:'weekTimes', fieldLabel:'节数/周', allowBlank: false ,minValue:2,maxValue:8},
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
		        	loadData(form,grid);
		        }
		        win.show();
     
		 }
		 function loadData(form,grid){
				var record = subjectGrid.getSelectionModel().getSelection();  
				//form.loadRecord(record[0]);
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

	var showTable = function(classId,schoolYear,term){
		if (classId==''||schoolYear==''||term==''){
			Ext.MessageBox.alert('警告','请选择班级，学年，学期');
			return;
		}
		/**
		$.ajax({
			url : '${pageContext.request.contextPath}/syllabus/getSyllabus.do',
			method: 'get',
			data : {
				'classId':classId,
				'schoolYear':schoolYear,
				'term':term,
			},
			dataType : 'json',
			success : function(r) {
				for (var i=0;i<r.length;i++){
					
					console.info(r[i].classTime);
				}
			},
			 failure: function(r) {
		
		            myMsg('操作提示','请求出错，请稍后重试！！！');
		        }
		});
*/
		var win = Ext.create("Ext.window.Window", {
            title: '课程表预览',       //标题
            autoScroll: true,
            maximizable :true,
            draggable: true,
            constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
            height: 460,                          //高度
            width: 720,                           //宽度
            layout: "fit",                        //窗口布局类型
            modal: true, //是否模态窗口，默认为false
            resizable: false,
            html:'<iframe style="overflow:auto;width:100%; height:100%;" '+
            	'src="${pageContext.request.contextPath}/syllabus/classSyllabusTable.do?classId='+classId+'&schoolYear='+schoolYear+'&term='+term.replace(/\s+/g,"")+'" frameborder="0"></iframe>',
        });
		win.show();
		
		
	}



</script>
