<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STUDENTTEST</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/FileUploadField.js"></script>
<script type="text/javascript">

var studentTest = function(studentId){


var store = Ext.create('Ext.data.Store', {
    fields: ["id", "testCode","testName","testTime","money","status"],
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
        url: '${pageContext.request.contextPath}/testRecord/findByPage.do?status=true',
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
                  { text: '考试代码', dataIndex: 'testCode',  width: 100},
                  { text: '考试名称', dataIndex: 'testName',width:300},
                  { text: '报名开始时间', dataIndex: 'regisStartTime',width:100},
                  { text: '报名截止时间', dataIndex: 'regisEndTime',width:100},
                  { text: '考试时间', dataIndex: 'testTime',width:100},
                  { text: '考试费用', dataIndex: 'money',width:80},
                {
                    xtype:'actioncolumn',
                    text: '操作选项',
                    width:80,
                    items: [
                     
                     {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/My_Check.png',  // Use a URL in the icon config
                        tooltip: '查看',
                       
                        handler: function(grid, rowIndex, colIndex) {
                        	 var rec = grid.getStore().getAt(rowIndex);
                        	 var obj = selectStore.findRecord('id',rec.get('id'));
                             if (obj != null){
                           	  Ext.MessageBox.alert('提示','你已选择此考试科目');
                             }else{
                            	selectStore.add(rec);
                             }
                            
                        }
                       
                    },
                   
       
   
               ],
            }
	]
 
 
});


var selectStore = Ext.create('Ext.data.Store', {
    fields: ["id", "testCode","testName","testTime","money","status"],
    pageSize: 5,  //页容量10条数据
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
        property: 'code',
    }],
    autoLoad: true  //即时加载数据
});
// selected array
var AllSelectedRecords = [];


var selectGrid = Ext.create('Ext.grid.Panel', {
    renderTo: Ext.getBody(),
    store: selectStore,
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
        store: selectStore,
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
                  { text: '报名开始时间', dataIndex: 'regisStartTime',width:100},
                  { text: '报名截止时间', dataIndex: 'regisEndTime',width:100},
                  { text: '考试时间', dataIndex: 'testTime',width:100},
                  { text: '考试费用', dataIndex: 'money',width:80},
                {
                    xtype:'actioncolumn',
                    text: '操作选项',
                    width:80,
                    items: [
                     
                     {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/My_No.png',  // Use a URL in the icon config
                        tooltip: '查看',
                       
                        handler: function(grid, rowIndex, colIndex) {
                        	 var rec = grid.getStore().getAt(rowIndex);
                        	 var id = rec.get('testRecordId');
                             selectStore.remove(rec);
                             selectRemove(id,studentId);
                            
                        }
                       
                    },
                   
       
   
               ],
            }
	],
	 buttonAlign: 'center',
	    tbar:[
				{xtype:'label',text:'已报名'},
	          ],
	    bbar: [
				{text:'提交',scale: 'medium',handler: function(){selectSubmit()}},
	    
	    ],
 
 
});



var selectSubmit = function(){
	if (selectStore.getCount() == 0){
		Ext.MessageBox.alert('提示','请选择至少一门考试科目');
		return;
	}
	
	var testIds = [];
	for(var i=0;i<selectStore.getCount();i++){
		var rec = selectStore.getAt(i);
		testIds.push(rec.get('id'));
	}
	
	
	$.ajax({
		url : '${pageContext.request.contextPath}/studentTest/save.do',
		method: 'post',
		data : {
			'testRecordIds' : testIds.join(','),
			'studentId' : studentId
		},
		dataType : 'json',
		success : function(r) {
			selectStore.reload();
			myMsg('操作提示',r.message);
		},
		 failure: function(r) {

                myMsg('操作提示',r.message);
            }
	});		
}

var selectRemove = function(selectId,sid){
	
	$.ajax({
		url : '${pageContext.request.contextPath}/studentTest/delete.do',
		method: 'get',
		data : {
			'testRecordId' : selectId,
			'studentId' : studentId
		},
		dataType : 'json',
		success : function(r) {
			selectStore.reload();
			myMsg('操作提示',r.message);
		},
		 failure: function(r) {

                myMsg('操作提示',r.message);
            }
	});		
}


var st = Ext.create("Ext.window.Window", {
    title: '考试报名',       //标题
    autoScroll: true,
    maximizable :true,
    draggable: true,
    constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
    height: 480,                          //高度
    width: 800,                           //宽度
    layout: "fit",                        //窗口布局类型
    modal: true, //是否模态窗口，默认为false
    resizable: false,
    items: [grid,selectGrid],
    buttonAlign: 'center',
    bbar:[
			
			{text:'关闭',scale: 'medium',handler: function(){st.close()}},
          ]
});
	
st.show();



}
</script>



</body>
</html>

