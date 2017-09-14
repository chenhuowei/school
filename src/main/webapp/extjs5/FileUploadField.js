// format x-x-x
var types = "";   
  
  
  

  
  
  
function openUpload(url,type,store,academyId,grade,classId){   
  // allow type
    types = type;   
  
    
 //判断文件格式 
   var typeArray = types.split('/');
  var isCheck = false;
  
  
var formUpload = new Ext.FormPanel({   
  
    baseCls: 'x-plain',   
  
    labelWidth: 80,   
    frame: true,
    defaultType: 'textfield',   
  
    items: [
		{   
		    xtype: 'radiogroup',   
		    fieldLabel: '操作选项',   
		    name: 'isCreate', 
		    vertical: true,
		    allowBlank: false,   
		    items: [     
		            {boxLabel: '创建', name: 'isCreate',inputValue:true,checked: true},     
		            {boxLabel: '更新', name: 'isCreate', inputValue:false,},     
		        ]  
		
		  }, 
            {   
  
      xtype: 'filefield',   
  
      fieldLabel: '文 件',   
      id : 'file',
      name: 'uploadFile',   
  
      allowBlank: false,   
  
      blankText: '请上传文件',   
  
      anchor: '90%'  // anchor width by percentage   
  
    },
    {   
    	
    	xtype: 'textfield',   
    	fieldLabel: '',   
    	name: 'academyId', 
    	value: academyId
    		
    },
    {   
    	
    	xtype: 'textfield',   
    	fieldLabel: '',   
    	name: 'grade',  
    	value:grade
    	
    },
    {   
    	
    	xtype: 'textfield',   
    	fieldLabel: '',   
    	name: 'classId',
    	value:classId
    	
    },
    
    ]   
  
  });   
  
  
  
var winUpload = new Ext.Window({   
  
    title: '资源上传',   
  
    width: 400,   
  
    height:150,   
  
    layout: 'fit',   
  
    plain:true,   
  
    bodyStyle:'padding:5px;',   
  
    buttonAlign:'center',   
  
    items: formUpload,   
  
    buttons: [{   
  
      text: '上 传',   
  
      handler: function() {
    	  var fileName = Ext.getCmp('file').getValue().split('.');
    	for (var i=0;i<typeArray.length;i++){
    		if (typeArray[i] == fileName[fileName.length-1]){
    			isCheck = true;
    		}
    	}
    	if(isCheck){
        if(formUpload.form.isValid()){   
  
          Ext.MessageBox.show({   
  
               title: 'Please wait',   
  
               msg: '上传中，请稍后...',   
  
               progressText: '',   
  
               width:300,   
  
               progress:true,   
  
               closable:false,   
  
               animEl: 'loding'  
  
             });   
  
          formUpload.getForm().submit({       
  
            url:url,   
  
            success: function(form, action){   
  
                if (null != store || '' != store){
                	store.reload();
                }
  
               var value = action.result.message;   
  
              
  
               Ext.Msg.alert('成功',value);   
  
               winUpload.hide();     
  
            },       
  
             failure: function(form, action){       
  
              //... action生成的json{msg:上传失败},页面就可以用action.result.msg得到非常之灵活   
              Ext.Msg.alert('Error', action.result.message);       
  
             }   
  
          })              
  
        }   
    	}else{
    		Ext.MessageBox.alert('警告','请选择后缀为'+types+'的类型');
    	}
       }   
  
    },{   
  
      text: '取 消',   
  
      handler:function(){winUpload.hide();}   
  
    }]   
  
  }); 
	winUpload.show();   


}