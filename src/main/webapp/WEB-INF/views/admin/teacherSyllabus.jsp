<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
var teacherSyllabus = function(tid,teacherNum){
	var grade = new Date().getFullYear();
	var schoolYear = '';
	var term = '';
	var win = Ext.create("Ext.window.Window", {
        title: '课程表预览',       //标题
        autoScroll: true,
        maximizable :true,
        id:'studentSyllabus',
        draggable: true,
        constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
        height: 500,                          //高度
        width: 720,                           //宽度
        layout: "fit",                        //窗口布局类型
        modal: true, //是否模态窗口，默认为false
        resizable: false,
        html:'',
        tbar: [
				{ xtype: "combobox", name: "schoolYear",id:'schoolYear1', fieldLabel:"学年",allowBlank:false,emptyText: '选择学年...',editable:false, padding:0,
				 	forceSelection:false,selectOnFocus : true,width:366,labelWidth:30,
				 	store:Ext.create('Ext.data.Store', {
				         fields: ["value", "name"],
				            proxy: {
				                type: 'ajax',
				                url: basePath+'dictionary/findByGrade.do?grade='+new Date().getFullYear(),
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
				 			},
				 			'render':function(combo,record,opts){
				 				schoolYear = '${sessionScope.schoolYearAtNow}';
				 				combo.setValue(schoolYear);
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
				 				var html = '<iframe style="overflow:auto;width:100%; height:100%;" '+
				 	        	'src="${pageContext.request.contextPath}/syllabus/teacherSyllabusTable.do?teacherId='+tid+'&teacherNum='+teacherNum+'&schoolYear='+schoolYear+'&term='+term.replace(/\s+/g,"")+'" frameborder="0"></iframe>';
				 	        	Ext.getCmp('studentSyllabus').update(html);
				 			},
				 			'render':function(combo,record,opts){
				 				term = '${sessionScope.termAtNow}';
				 				combo.setValue(term);
				 				var html = '<iframe style="overflow:auto;width:100%; height:100%;" '+
				 	        	'src="${pageContext.request.contextPath}/syllabus/teacherSyllabusTable.do?teacherId='+tid+'&teacherNum='+teacherNum+'&schoolYear='+schoolYear+'&term='+term.replace(/\s+/g,"")+'" frameborder="0"></iframe>';
				 	        	Ext.getCmp('studentSyllabus').update(html);
				 			}
				 		}
				 },
        	   ]
    });
	win.show();
}	
</script>
