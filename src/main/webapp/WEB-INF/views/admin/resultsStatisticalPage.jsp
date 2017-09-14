<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
var resultStaticFuntion = function(studentId){
	var schoolYear = '';
	var term = '';
	
var resultStore = Ext.create('Ext.data.Store', {
    fields: ["id", "student","term", "totalCredits","totalPoint", "averagePoint",
             "requestCredits","requestAveragePoint","status"],
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
        url: '${pageContext.request.contextPath}/resultsStatistical/findByStudentId.do?studentId='+studentId,
        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
            type: 'json', //返回数据类型为json格式
            root: 'rows',  //数据
            pruneModifieRecords:true ,//store每次提交后自动清除modified标记
            totalProperty: 'total' //数据总条数
        }
   
    },
    sorters: [{
        property: 'schoolYear',
    }],
    autoLoad: true  //即时加载数据
});
// selected array
var AllSelectedRecords = [];
var resultGrid = Ext.create('Ext.grid.Panel', {
    renderTo: Ext.getBody(),
    store: resultStore,
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
        store: resultStore,
        displayMsg: '显示 {0} - {1} 条，共计 {2} 条',
        emptyMsg: "没有数据",
        beforePageText: "当前页",
        afterPageText: "共{0}页",
        displayInfo: true                 
    }],
   
    columns: [                    
                  { text: 'ID', dataIndex: 'id', align: 'left', width: 50,hidden:true },
                  { text: '学年', dataIndex: 'schoolYear',  width: 80},
                  { text: '学期', dataIndex: 'term',width:50},
                  { text: '总学分', dataIndex: 'totalCredits',width:60},
                  { text: '总绩点', dataIndex: 'totalPoint',width:60},
                  { text: '平均绩点', dataIndex: 'averagePoint',width:80},
                  { text: '要求学分', dataIndex: 'requestCredits',width:80},
                  { text: '要求平均绩点', dataIndex: 'requestAveragePoint',width:100},
                  { text: '状态', dataIndex: 'status',width:80,
                	  renderer : function(value){
                			if (value){
                  				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Button Check.png' />";;
                  			}else{
                  				return "<img width='15px' src='${pageContext.request.contextPath}/jslib/icon/myIcon/Error.png' />";
                  			}
                  		}    
                  
                  },
    
       
   
               ],
   
    listeners: { 'itemclick': function (view, record, item, index, e) {
    }
    },
    tbar:[

"->",
{xtype:'label',text:'关键词：'},
		{xtype:'textfield',emptyText:'多个关键词，分隔',
	 id:'KeyWord3'
	 },
		{iconCls:'icon-search',
    	 text:'查询',
    	 handler:function(){
    		 var keyWord = scoreGrid.down('#KeyWord3').getValue();
    		resultStore.reload({ params:{'keyWord' : keyWord} });
    		 
    	 }
},
	{iconCls:'icon-remove',
	 text:'清除',
	 handler:function(){
		 resultGrid.down('#KeyWord3').setValue('');
		 resultStore.reload({ params:{'keyWord' : ''} });
	 }
},
        	       
        	       ]
});


var resultWin = Ext.create("Ext.window.Window", {

	title:'成绩统计',
    maximizable :true,
   // renderTo: Ext.getBody(),
    draggable: true,
    constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
    height: 300,                          //高度
    width: 600,                           //宽度
    layout: "fit",                        //窗口布局类型
    modal: true, //是否模态窗口，默认为false
    resizable: false,
    items: [resultGrid],
    tbar: [
			{ xtype: "combobox", name: "schoolYear",id:'schoolYear1', fieldLabel:"学年",allowBlank:false,emptyText: '选择学年...',editable:false, padding:0,
			 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
			 	store:Ext.create('Ext.data.Store', {
			         fields: ["value", "name"],
			            proxy: {
			                type: 'ajax',
			                url: basePath+'dictionary/findByType.do?type=schoolYear',
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
			 				resultStore.reload({params:{'schoolYear':schoolYear,'term':term}});
			 			},
			 			'render':function(combo,record,opts){
			 				schoolYear = '${sessionScope.schoolYearAtNow}';
			 				combo.setValue(schoolYear);
			 				resultStore.reload({params:{'schoolYear':schoolYear,'term':term}});
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
			 				resultStore.reload({params:{'schoolYear':schoolYear,'term':term}});
			 				
			 			},
			 			'render':function(combo,record,opts){
			 				term = '${sessionScope.termAtNow}';
			 				combo.setValue(term);
			 				resultStore.reload({params:{'schoolYear':schoolYear,'term':term}});
			 				
			 			}
			 		}
			 },
   	   ]
});
	resultWin.show();



}

</script>



