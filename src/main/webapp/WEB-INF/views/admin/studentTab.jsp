<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
var changeClassesWin = function(id,academyName,grade,classId,store){
	var academyName = '';
	var grade = '';
	var className = '';
	var classesStore = Ext.create('Ext.data.Store', {
        fields: ["id", "name"],
        proxy: {
            type: 'ajax',
            url: '',
       	   
        },
        autoLoad: false,
        pageSize : 8
    });
	var changeForm = new Ext.FormPanel( {
		bodyStyle: 'padding:15px 15px 10px',
	    layout: 'form',
	    items : [ 
				{ xtype: "combobox", name: "academy",id:'academy1', fieldLabel:"学院",allowBlank:false,emptyText: '选择学院...',editable:false, padding:0,
				 	forceSelection:true,selectOnFocus : true,width:366,labelWidth:30,
				 	store:Ext.create('Ext.data.Store', {
				         fields: ["value", "name"],
				            proxy: {
				                type: 'ajax',
				                url: basePath+'academy/findIdnName.do',
				           	   
				            },
				            autoLoad: false,
				            pageSize : 8,
				            listeners :{
					            'load':function(store, records){
					            	
					            	var data = store.findRecord('name',academyName);
					            	
					            	
					            },
					            
					          } 
				        }),
				       displayField:'name',
				 		 valueField:'value',
				 		 pageSize:6,
				 		 queryParam: 'keyWord',
				 		listeners :{
				            'select':function(obj, record,eOpts){
				            	var id = record.data.value;
				            	academyName = record.data.name;
				            	academyId = id;
				            	var c = Ext.getCmp('classes1');
				            	c.setValue('');
				            	classesStore.getProxy().url = basePath+'classes/findIdAndName.do?academyId='+academyId+'&grade='+grade;
				            	classesStore.load();
				            	
				            },
				            
				          } 
				 },
				{ xtype: "combobox", name: "grade",id:'grade1', fieldLabel:"年级",allowBlank:false,emptyText: '选择年级...',editable:false, padding:0,
				 	forceSelection:true,selectOnFocus : true,width:366,labelWidth:30,
				 	store:Ext.create('Ext.data.Store', {
				         fields: ["name", "value"],
				            proxy: {
				                type: 'ajax',
				                url: basePath+'dictionary/findByType.do?type=grade',
				           	   
				            },
				            autoLoad: false,
				            pageSize : 8
				        }),
				       displayField:'name',
				 		 valueField:'value',
				 		 pageSize:6,
				 		 queryParam: 'keyWord',
				 		listeners :{
				            'select':function(obj, record,eOpts){
				            	var c = Ext.getCmp('classes1');
				            	c.setValue('');
				            	grade = record.data.value;
				            	classesStore.getProxy().url = basePath+'classes/findIdAndName.do?academyId='+academyId+'&grade='+grade;
				            	classesStore.load();
				            }
				          } 
				 },
				{ xtype: "combobox", name: "classes",id:'classes1', fieldLabel:"班级",allowBlank:false,emptyText: '选择班级...',editable:false, padding:0,
				 	forceSelection:true,selectOnFocus : true,width:366,labelWidth:30,
				 	store:classesStore,
				       displayField:'name',
				 		 valueField:'value',
				 		 pageSize:6,
				 		 queryParam: 'keyWord',
				 		listeners :{
				            'select' : function(obj,record,opts){
				            	classId = record.data.value;
				            	className = record.data.name;
				            }
				          } 
				 },
				 
	             
	         ],
	         buttonAlign: 'center',
	 	    buttons: [
	 	{
	 	    text: '确定',
	 	    iconCls: 'icon-search',
	 	    handler: function () {
	 	    	if (changeForm.isValid()) {
	 	    		$.ajax({
						url : '${pageContext.request.contextPath}/student/update.do',
						method: 'post',
						data : {
							'classId' : classId,'id' : id,
							'academyName' : academyName,'grade' : grade,
							'className' : className
						},
						dataType : 'json',
						success : function(r) {
							store.reload();
							myMsg('操作提示',r.message);
							changeWin.close();
						},
						 failure: function(r) {

		                        myMsg('操作提示',r.message);
		                    }
					});
	 		             
	 	          }
	 	    }
	 	},{
	 		text: '关闭',
	 	    iconCls: 'icon-close',
	 	    handler: function () {
	 	    	changeWin.close();
	 	    }
	 	}
	 	]
	});	
		var changeWin = Ext.create("Ext.window.Window", {
		    maximizable :true,
		   // renderTo: Ext.getBody(),
		    draggable: true,
		    constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
		    height: 300,                          //高度
		    width: 500,                           //宽度
		    layout: "fit",                        //窗口布局类型
		    modal: true, //是否模态窗口，默认为false
		    resizable: false,
		    items: [changeForm]
		});
		changeWin.show();
}	
</script>
