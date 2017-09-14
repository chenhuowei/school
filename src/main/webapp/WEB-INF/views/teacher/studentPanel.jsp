<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STUDENT</title>
</head>
<body>
<jsp:include page="scoreRecordPage.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/searchPanel.js"></script>
<script type="text/javascript">

var studentGrid = function(classId,selectSubjectId,isSelect){
	var url = '';
	
	if (null != classId && ''!=classId){
		url = '${pageContext.request.contextPath}/student/findByPage.do?classId='+classId;
	}
	if (null != selectSubjectId && '' != selectSubjectId){
		url = '${pageContext.request.contextPath}/student/findBySelectSubject.do?selectSubjectId='+selectSubjectId;
	}
	
	
	
var store = Ext.create('Ext.data.Store', {
    fields: ["id", "studentNum", "name","sex", "mobile","birth","age","classId"],
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
        url: url,
        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
            type: 'json', //返回数据类型为json格式
            root: 'rows',  //数据
            pruneModifieRecords:true ,//store每次提交后自动清除modified标记
            totalProperty: 'total' //数据总条数
        }
   
    },
    sorters: [{
        property: 'studentNum',
    }],
    autoLoad: true  //即时加载数据
});
// selected array
var AllSelectedRecords = [];
var grid = Ext.create('Ext.grid.Panel', {
    //renderTo: Ext.getBody(),
    store: store,
    id:'studentGrid',
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
                  { text: '学号', dataIndex: 'studentNum',  width: 80},
                  { text: '姓名', dataIndex: 'name',width:80},
                  { text: '性别', dataIndex: 'sex',width:50,
                	  renderer : function(value){
              			if (value){
              				return '男';
              			}else{
              				return '女';
              			}
              		}    
                  },
                  { text: '出生日期', dataIndex: 'birth',width:120},
                  { text: '学院', dataIndex: 'academyName',width:80},
                  { text: '年级', dataIndex: 'grade',width:60},
                  { text: '班别', dataIndex: 'className',width:60},
                  { text: '状态', dataIndex: 'status',width:80,
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
                    width:330,
                    items: [
                     
                    "-",
                    {
                    	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/File_Edit.png',
                    	altText : '成绩登记',
                        tooltip: 'change',
                        handler: function(grid, rowIndex, colIndex) {
                        	var rec = grid.getStore().getAt(rowIndex);
                            var studentId = rec.get('id');
                            var classId = rec.get('classId');
                            var grade = rec.get('grade');
                        	scoreFuntion(studentId,classId,grade,isSelect);
                        }
                    },
                   
                ]
                },
       
   
               ],
   
    tbar:[

{xtype:'label',text:'学生信息'},
"->",
{xtype:'label',text:'关键词：'},
		{xtype:'textfield',emptyText:'学生 ，模糊查询',
	 id:'KeyWords'
	 },
		{iconCls:'icon-search',
    	 text:'查询',
    	 handler:function(){
    		 var keyWord = grid.down('#KeyWords').getValue();
    		 
    		 store.reload({ params:{'keyWords' : keyWord,
    			 'classId':classId} });
    		 
    	 }
},
	{iconCls:'icon-remove',
	 text:'清除',
	 handler:function(){
		 grid.down('#KeyWords').setValue('');
		 var keyWord = grid.down('#KeyWords').getValue();
		 store.reload({ params:{'keyWords' : keyWord} });
	 }
},
	
        	       
        	       ]
});

		return grid;

}

</script>



</body>
</html>