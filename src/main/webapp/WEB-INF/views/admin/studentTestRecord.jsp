<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STUDENTTESTRECORD</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/FileUploadField.js"></script>
<script type="text/javascript">

var studentTestRecord = function(studentId){


var store = Ext.create('Ext.data.Store', {
    fields: ["id", "testCode","testName","testLocation","isPass","isPayment"],
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
        url: '${pageContext.request.contextPath}/studentTest/findByStudentId.do?studentId='+studentId,
        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
            type: 'json', //返回数据类型为json格式
            root: 'rows',  //数据
            pruneModifieRecords:true ,//store每次提交后自动清除modified标记
            totalProperty: 'total' //数据总条数
        }
   
    },
    sorters: [{
        property: 'testCode',
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
                  { text: '考试代码', dataIndex: 'testCode',  width: 100},
                  { text: '考试名称', dataIndex: 'testName',width:300},
                  { text: '准考证', dataIndex: 'testNum',width:180},
                  { text: '考试地点', dataIndex: 'testLocation',width:150},
                  { text: '考试成绩', dataIndex: 'testScore',width:80},
                  { text: '是否通过', dataIndex: 'isPass',width:80,
                	  renderer : function(value){
              			if (value){
                				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Button Check.png' />";;
                			}else{
                				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Error.png' />";
                			}
                		}      
                  },
                  { text: '是否缴费', dataIndex: 'isPayment',width:80,
                	  renderer : function(value){
              			if (value){
                				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Button Check.png' />";;
                			}else{
                				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Error.png' />";
                			}
                		}      
                  
                  },
                  { text: '报名成功', dataIndex: 'isRegisSuccess',width:80,
                	  
                	  renderer : function(value){
              			if (value){
                				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Button Check.png' />";;
                			}else{
                				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Error.png' />";
                			}
                		}    
                  },
                {
                    xtype:'actioncolumn',
                    text: '操作选项',
                    width:80,
                    items: [
                     
                     {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Pencil_2.png',  // Use a URL in the icon config
                        tooltip: '查看',
                       
                        handler: function(grid, rowIndex, colIndex) {
                        	 var rec = grid.getStore().getAt(rowIndex);
                        	 openWin(rec);
                            
                        }
                       
                    },
                   
       
   
               ],
            }
	]
 
 
});
var openWin = function(rec){
	 var form = new Ext.FormPanel({
	   	bodyStyle: 'padding:5px 5px 0',
	    layout: 'form',
	    autoScroll: true,
	    items: [
		{
			xtype: "container",
		    layout: "hbox",
		    items: [
		       
		            { xtype:'textfield', name:'id', fieldLabel:'', allowBlank: false,hidden:true},
		            { xtype:'textfield', name:'testScore',value:'0', fieldLabel:'考试成绩', allowBlank: true,},
		
		    ]
		},
		{
			xtype: "container",
		    layout: "hbox",
		    items: [
		       
				{ xtype:'radiogroup', name:'isRegisSuccess', fieldLabel:'报名状态', allowBlank: false,hiddenName:'isRegisSuccess',
				    columnWidth:0.8,items: [  
				        { boxLabel: '成功', name: 'isRegisSuccess', inputValue: 'true' ,checked:true},   
				        { boxLabel: '失败', name: 'isRegisSuccess', inputValue: 'false',width:180 },  
				        
				     ]
				             
				 	}, 
				{ xtype:'radiogroup', name:'isPayment', fieldLabel:'缴费状态', allowBlank: false,  
				    columnWidth:0.8,items: [  
				        { boxLabel: '已缴费', name: 'isPayment', inputValue: 'true' ,checked:true},   
				        { boxLabel: '未缴费', name: 'isPayment', inputValue: 'false' },  
				        
				     ]
				             
				 	}, 
		
		    ]
		},

		],
		 buttonAlign: 'center',
		    buttons: [
		{
		    text: '保存',
		    handler: function () {
		    	if (form.isValid()) {
		    		
			                form.submit({
			                	url: basePath+'/studentTest/update.do',
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
          title: '考试编辑',       //标题
          autoScroll: true,
          maximizable :true,
          draggable: true,
          constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
          height: 300,                          //高度
          width: 600,                           //宽度
          layout: "fit",                        //窗口布局类型
          modal: true, //是否模态窗口，默认为false
          resizable: false,
          items: [form]
      });
   		form.reset();
     	form.loadRecord(rec);
      win.show();



}






var st = Ext.create("Ext.window.Window", {
    title: '学生考试',       //标题
    autoScroll: true,
    buttonAlign: 'center',
    maximizable :true,
    draggable: true,
    constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
    height: 480,                          //高度
    width: 800,                           //宽度
    layout: "fit",                        //窗口布局类型
    modal: true, //是否模态窗口，默认为false
    resizable: false,
    items: [grid],
    bbar:[
			
			{text:'关闭',scale: 'medium',handler: function(){st.close()}},
          ]
});
	
st.show();



}
</script>



</body>
</html>

