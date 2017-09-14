<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
var studentSelectSubject = function(sid){
	var nowYear = new Date();
	var nextYear = parseInt(nowYear.getFullYear())+1;
	var schoolYear = nowYear.getFullYear()+"-"+nextYear;
	var term = '';
	
	var store = Ext.create('Ext.data.Store', {
	    fields: ["id","schoolYear","term","subjectCode","subjectName","teacherName","locationName"],
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
	       	url: basePath+'selectSubject/findByPage.do',
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
	
	var AllSelectedRecords = [];
	var grid = Ext.create('Ext.grid.Panel', {
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
	                  { text: '学年', dataIndex: 'schoolYear',  width: 80},
	                  { text: '学期', dataIndex: 'term',width:80},
	                 
	                  { text: '科目类型', dataIndex: 'catagory',width:120},
	                  { text: '科目名称', dataIndex: 'subjectName',width:150},
	                  { text: '任教教师', dataIndex: 'teacherName',width:80},
	                  { text: '上课地点', dataIndex: 'locationName',width:120},
	                  { text: '上课周', dataIndex: 'classWeek',width:80},
	                  { text: '上课次序', dataIndex: 'classTime',width:80},
	                  { text: '容量', dataIndex: 'capacity',width:80},
	                  {
	                      xtype:'actioncolumn',
	                      text: '操作选项',
	                      width:80,
	                      items: [
	                       
	                      "-",
	                       {
	                      	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/My_Check.png',  // Use a URL in the icon config
	                          tooltip: '查看',
	                         
	                          handler: function(grid, rowIndex, colIndex) {
	                              var rec = grid.getStore().getAt(rowIndex);
	                              var obj = selectStore.findRecord('id',rec.get('id'));
	                              if (selectStore.count()>=1){
	                            	  Ext.MessageBox.alert('提示','你已选一门课程');
	                              }else if(obj != null){
	                            	  Ext.MessageBox.alert('提示','你已选择该课程');
	                            	  
	                              }else{
	                             	selectStore.add(rec);
	                            	  
	                              }
	                              
	                              
	                          }
	                         
	                      },
	                      ]
	                  }
	   
	               ],
	   
	    listeners: { 'itemclick': function (view, record, item, index, e) {
	    }
	    },
	    tbar:[

	        	       ]
	});

	var selectStore = Ext.create('Ext.data.Store', {
	    fields: ["id","schoolYear","term","subjectCode","subjectName","teacherName","locationName"],
	    pageSize: 10,  //页容量10条数据
	    remoteSort: false,
	    remoteFilter: true,
	    proxy: {
	        type: 'ajax',
	       	url: basePath+'studentSelectSubject/findByStudentId.do?studentId='+sid,
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
	var selectGrid = Ext.create('Ext.grid.Panel', {
	    renderTo: Ext.getBody(),
	    store: selectStore,
	    layout:'fit',
	    viewConfig: {
            forceFit: true, //让grid的列自动填满grid的整个宽度，不用一列一列的设定宽度。
            emptyText: '你还没有选择课程'
        },
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
	   
	    columns: [                    
	                  { text: 'ID', dataIndex: 'id', align: 'left', width: 50,hidden:true },
	                  { text: '学年', dataIndex: 'schoolYear',  width: 80},
	                  { text: '学期', dataIndex: 'term',width:80},
	                 
	                  { text: '科目类型', dataIndex: 'catagory',width:120},
	                  { text: '科目名称', dataIndex: 'subjectName',width:150},
	                  { text: '任教教师', dataIndex: 'teacherName',width:80},
	                  { text: '上课地点', dataIndex: 'locationName',width:120},
	                  { text: '上课周', dataIndex: 'classWeek',width:80},
	                  { text: '上课次序', dataIndex: 'classTime',width:80},
	                  {
	                      xtype:'actioncolumn',
	                      text: '操作选项',
	                      width:80,
	                      items: [
	                       
	                      "-",
	                       {
	                      	icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/My_No.png',  // Use a URL in the icon config
	                          tooltip: '查看',
	                         
	                          handler: function(grid, rowIndex, colIndex) {
	                              var rec = grid.getStore().getAt(rowIndex);
	                              var id = rec.get('id');
	                             selectStore.remove(rec);
	                             selectRemove(id,sid);
	                          }
	                         
	                      },
	                      ]
	                  }
	   
	               ],
	               buttonAlign: 'center',
	       	    tbar:[
	       				{xtype:'label',text:'已选课程'},
	       	          ],
	       	    bbar: [
	       				{text:'提交',scale: 'medium',handler: function(){selectSubmit()}},
	       	    
	       	    ],
	   
	   
	});
	
	var selectSubmit = function(){
		if (selectStore.getCount() == 0){
			Ext.MessageBox.alert('提示','请选择至少一门课程');
			return;
		}
		var rec = selectStore.getAt(0);
		var id = rec.get('id');
		$.ajax({
			url : '${pageContext.request.contextPath}/studentSelectSubject/save.do',
			method: 'post',
			data : {
				selectSubjectId : id,
				studentId : sid
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
			url : '${pageContext.request.contextPath}/studentSelectSubject/delete.do',
			method: 'get',
			data : {
				selectSubjectId : selectId,
				studentId : sid
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
	
	
	
	var sss = Ext.create("Ext.window.Window", {
        title: '学生选课',       //标题
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
				
				{text:'关闭',scale: 'medium',handler: function(){sss.close()}},
              ]
    });
 	
    sss.show();

	
	
	
	
	

}	
</script>
