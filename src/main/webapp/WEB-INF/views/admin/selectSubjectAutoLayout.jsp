<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">


	var selectSubjectLayout = function(store){
		
		
		var form = new Ext.FormPanel({
		   	bodyStyle: 'padding:5px 5px 0',
		    layout: 'form',
		    autoScroll: true,
		    items:[

       
           {xtype:'textfield',name:'schoolYear',fieldLabel:'学年',value:'${schoolYearAtNow}',allowblank:false,editable:false},
           {xtype:'textfield',name:'term',fieldLabel:'学期',value:'${termAtNow}',allowblank:false,editable:false},
            

		       {
		        xtype: 'checkboxgroup',
		        fieldLabel: '上课时间',
		        columns: 3,
		        vertical: true,
		        items: [
		            { boxLabel: '星期日', name: 'classWeek', inputValue: '星期日' ,checked:true},
		            { boxLabel: '星期一', name: 'classWeek', inputValue: '星期一' },
		            { boxLabel: '星期二', name: 'classWeek', inputValue: '星期二',checked:true },
		            { boxLabel: '星期三', name: 'classWeek', inputValue: '星期三' },
		            { boxLabel: '星期四', name: 'classWeek', inputValue: '星期四',checked:true },
		            { boxLabel: '星期五', name: 'classWeek', inputValue: '星期五' },
		            { boxLabel: '星期六', name: 'classWeek', inputValue: '星期六' },
		            
		        ]
		    },
		    	{xtype:'textfield',value:'此课程安排仅限于9-10节的时间点',disabled:true}
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
			                	url: basePath+'selectSubject/autoLayout.do',
			                	method: 'get',
			                    success: function(form,action) {
			                    	store.reload();
			                       Ext.MessageBox.alert('操作提示',action.result.message);
			                       win.close(this);
			                       
			                    },
			                    failure: function(form,action) {

			                    	Ext.MessageBox.alert('操作提示',action.result.message);
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
            title: '',       //标题
            autoScroll: true,
            maximizable :true,
            draggable: true,
            constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
            height: 300,                          //高度
            width: 400,                           //宽度
            layout: "fit",                        //窗口布局类型
            modal: true, //是否模态窗口，默认为false
            resizable: false,
            items: [form]
        });
     	
        win.show();
	}

</script>
