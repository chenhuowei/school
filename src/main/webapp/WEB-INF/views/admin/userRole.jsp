<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/rewriteExt.js"></script>
<script type="text/javascript">
var userRole = function(userId){
	
	var checksource = new Ext.ux.RemoteCheckboxGroup({
	    name: 'roleIds',
	    columns :3,
	    boxLabel: 'name',
	    inputValue: 'value',
	    url: basePath+'roleInfo/findIdAndName.do',
	    fieldLabel: '角色列表',
	    style: 'padding:10px;height:17px;'
	});
	 //创建panel
    var form = new Ext.FormPanel({
	   	bodyStyle: 'padding:5px 5px 0',
	    layout: 'form',
	    items: [checksource,
	            {xtype:'textfield',name:'userId',allowblank:false,value:userId,hidden:true}
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
		                	url: basePath+'userRole/save.do',
		                	method: 'post',
		                    success: function(form,action) {
		                       myMsg('操作提示',action.result.message);
		                       roleWin.close(this);
		                       
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
	    	roleWin.close(this);
	    }
	}
	]
    });
	 
	 
    form.getForm().load({                    
        waitMsg : '正在加载数据请稍后',//提示信息                
        waitTitle : '提示',//标题                
        url : '${pageContext.request.contextPath}/userRole/findByUser.do',            
        params:{'userId':userId},                
        method:'GET',//请求方式             
        success:function(form,action){
      		
        },
        failure:function(form,action){//加载失败的处理函数                
            Ext.MessageBox.alert("提示","加载数据失败");     
            
        }            
   });    
	 
	var roleWin = Ext.create("Ext.window.Window", {
	    title: '用户角色',       //标题
	    autoScroll: true,
	    maximizable :true,
	    draggable: true,
	    constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
	    height: 240,                          //高度
	    width: 430,                           //宽度
	    layout: "fit",                        //窗口布局类型
	    modal: true, //是否模态窗口，默认为false
	    resizable: false,
	    items: [form]
	});
	roleWin.show();
}


</script>