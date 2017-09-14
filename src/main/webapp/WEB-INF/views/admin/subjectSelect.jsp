<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">


	var subjectSelect = function(gridStore,id,classId){
		var url = '';
		if (classId == '' || classId == null){
			url = basePath+'selectSubject/update.do'
		}else{
			url = basePath+'subjectArrangement/update.do'
			
		}
		var form = new Ext.FormPanel({
		   	bodyStyle: 'padding:5px 5px 0',
		    layout: 'form',
		    autoScroll: true,
		    items: [
		            {
		            	xtype:'textfield',name:'id',value:id,hidden:true
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
            autoLoad: false,
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
	    }
		],
		 buttonAlign: 'center',
		    buttons: [
		{
		    text: '保存',
		    id : 'saveButton',
		    iconCls: 'icon-save',
		    handler: function () {
		    	if (form.isValid()) {
		    		
			                form.submit({
			                	url: url,
			                	method: 'post',
			                    success: function(form,action) {
			                    	gridStore.reload({params:{'classId':classId}});
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
		})
	    var win = Ext.create("Ext.window.Window", {
            title: '',       //标题
            autoScroll: true,
            maximizable :true,
            draggable: true,
            constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
            height: 200,                          //高度
            width: 400,                           //宽度
            layout: "fit",                        //窗口布局类型
            modal: true, //是否模态窗口，默认为false
            resizable: false,
            items: [form]
        });
     	
        win.show();
	}

</script>
