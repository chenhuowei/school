<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

	function autoLayout(){
		var grade = new Date().getFullYear();
		var autoForm = new Ext.FormPanel({
		   	bodyStyle: 'padding:5px 5px 0',
		    layout: 'form',
		    autoScroll: true,
		    items: [
			
			{
				xtype: "container",
			    layout: "vbox",
			    items: [
			       
			            { xtype: "combobox", name: "schoolYear",id:'schoolYear1', fieldLabel:"学年",allowBlank:false,emptyText: '选择学年...',editable:false, padding:0,
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
			            { xtype: "combobox", name: "term",id:'term1', fieldLabel:"学期",allowBlank:false,emptyText: '选择学学期...',editable:false, padding:0,
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
			}
			],
			 buttonAlign: 'center',
			    buttons: [
			{
			    text: '确定',
			    iconCls: 'icon-save',
			    handler: function () {
			    	var form = autoForm.getForm();
			    	if (form.isValid()) {
			    Ext.MessageBox.confirm('警告', '您将要把选中学年学期的课程安排清空，并重新编排？', function callback(id) {
			    	if (id == 'yes') {
			    		var p =  Ext.MessageBox.show({   
			    			  
			                 title: 'please wait...',   
			    
			                 msg: '自动编排中，请稍后...',   
			    
			                 progressText: '',   
			    
			                 width:300,   
			    
			                 progress:true,   
			    
			                 closable:false,   
			    
			                 animEl: 'loding'  
			    
			               });
			    		 p.updateProgress(0.5,'50%','执行中,请稍后...');
			    		form.submit({
				                	url: basePath+"syllabus/autoLayoutCourse.do",
				                	method: 'post',
				                    success: function(form,action) {
				                       autoWin.close();
				                       p.updateProgress(1,'100%',action.result.message);
				                       //Ext.MessageBox.alert('操作提示',action.result.message);
				                       p.destroy();
				                    },
				                    failure: function(form,action) {
				                       console.info(action);

				                    	Ext.MessageBox.alert('操作提示',action.result.message);
				                    }
				                });
			    	}
			    })
			          }
			    }
			}, {
			    text: '关闭',
			    iconCls: 'icon-close',
			    handler: function () {
			        autoWin.close(this);
			    }
			}
			]
			});
			var autoWin = Ext.create("Ext.window.Window", {
	            title: "自动排课",       //标题
	            autoScroll: true,
	            maximizable :true,
	            draggable: true,
	            constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
	            height: 160,                          //高度
	            width: 400,                           //宽度
	            layout: "fit",                        //窗口布局类型
	            modal: true, //是否模态窗口，默认为false
	            resizable: false,
	            items: [autoForm]
	        });
	       
	        autoWin.show();
		
		
		
		
	}





</script>