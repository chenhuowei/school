// search more...

var openSearchWin2 = function(store,academyId,grade,classId){
		
		  
		
		var searchForm = new Ext.FormPanel({
		   	bodyStyle: 'padding:5px 5px 0',
		    layout: 'form',
		    items: [
			{
				xtype: "container",
			    layout: "hbox",
			    items: [
			       
			            { xtype:'textfield', name:'num',id:'num', fieldLabel:'编号',value:'',
			            	disabled:false,regex:/^[1-9]\d{6,10}$/,
			            	regexText: '请输入以年份后两位数字+代表数(u:0,s:1,t:2)为开头的7-11位数字(2016 u : 1600123)'},
			            { xtype:'textfield', name:'name',id:'name', fieldLabel:'姓名', value:'',},
			
			    ]
			},
		    
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		                { xtype:'textfield', name:'address',id:'address', fieldLabel:'居住地址', allowBlank: true,value:'',width:550},

		        ]
		    },
		    {
		    	xtype: "container",
		    	layout: "hbox",
		    	items: [
		    	        { xtype:'textfield', name:'nativePlace',id:'nativePlace', fieldLabel:'籍贯', allowBlank: true,value:'',width:550},
		    	        
		    	        ]
		    },
		    {
		    	xtype: "container",
		    	layout: "hbox",
		    	items: [
		    	        { xtype:'textfield', name:'homeAddress',id:'homeAddress', fieldLabel:'家庭地址', allowBlank: true,value:'',width:550},
		    	        
		    	        ]
		    },
		    
		    {
		    	xtype: "container",
		    	layout: "hbox",
		    	items: [
		    	        
		    	        { xtype:'radiogroup', name:'userSex', fieldLabel:'性别',  id:'sex',
		    	        	columnWidth:0.8,items: [  
		    	        	                        { boxLabel: '男', name: 'sex', inputValue: 1,width:50 },   
		    	        	                        { boxLabel: '女', name: 'sex', inputValue: 0 ,width:225 },  
		    	        	                        
		    	        	                        ]
		    	        
		    	        }, 
		    	        {xtype:'radiogroup', name:'userAccountStatus', fieldLabel:'状态',id:'status',
				        	   columnWidth:0.8,items: [  
				        	                           { boxLabel: '激活', name: 'status', inputValue: 1,width:50 },   
				        	                           { boxLabel: '失效', name: 'status', inputValue: 0,width:50  },  
				        	                           
				        	                           ]
				           },
		    	        
		    	        ]
		    },
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		           
		                { xtype:'textfield', name:'mobile',id:'mobile', fieldLabel:'手机号码', vtype:'mobilephone',value:'', },
		                { xtype:'textfield', name:'tel',id:'tel', fieldLabel:'家庭电话', regex:/^[0-9]{7,11}$/,value:'', },
		        ]
		    },
		   
		    
		    {
			   	 xtype: "container",
			           layout: "hbox",
			           items: [
			               { xtype:'textfield', name:'idCard',id:'idCard', fieldLabel:'身份证',value:'',width:550},
			               
			           ]
			   }, 
			   {
				   xtype: "container",
				   layout: "hbox",
				   items: [
				          
				           ]
			   }, 
		    {
		    	xtype: "container",
		        layout: "hbox",
		        items: [
		                
		               { xtype:'datefield', name:'startBirth', fieldLabel:'出生日期', format : 'Y-m-d',editable:false,id:'startBirth',value:'',
	                       maxValue : new Date()},
	                       { xtype:'datefield', name:'endBirth', fieldLabel:'至', format : 'Y-m-d',editable:false,id:'endBirth',value:'',
	                    	   maxValue : new Date()},

		        ]
		    },
		    {
		    	xtype: "container",
		    	layout: "hbox",
		    	items: [
		    	        
		    	        { xtype:'datefield', name:'startAdmissionDate', fieldLabel:'入学日期', format : 'Y-m-d',editable:false,id:'startAdmissionDate',value:'',
		    	        	maxValue : new Date()},
		    	        	{ xtype:'datefield', name:'endAdmissionDate', fieldLabel:'至', format : 'Y-m-d',editable:false,id:'endAdmissionDate',value:'',
		    	        		maxValue : new Date()},
		    	        		
		    	        		]
		    },
		    {
		    	xtype: "container",
		    	layout: "hbox",
		    	items: [
		    	        
		    	        { xtype:'datefield', name:'startJoinDate', fieldLabel:'入职日期', format : 'Y-m-d',editable:false,id:'startJoinDate',value:'',
		    	        	maxValue : new Date()},
		    	        	{ xtype:'datefield', name:'endJoinDate', fieldLabel:'至', format : 'Y-m-d',editable:false,id:'endJoinDate',value:'',
		    	        		maxValue : new Date()},
		    	        		
		    	        		]
		    },
		    {
		    	xtype: "container",
		    	layout: "hbox",
		    	items: [
		    	        
		    	        { xtype:'datefield', name:'startCreateTime', fieldLabel:'创建日期', format : 'Y-m-d',editable:false,id:'startCreateTime',value:'',
		    	        	maxValue : new Date()},
		    	        	{ xtype:'datefield', name:'endCreateTime', fieldLabel:'至', format : 'Y-m-d',editable:false,id:'endCreateTime',value:'',
		    	        		maxValue : new Date()},
		    	        		
		    	        		]
		    },
		    {
		    	xtype: "container",
		    	layout: "hbox",
		    	items: [
		    	        
		    	        { xtype:'datefield', name:'startUpdateTime', fieldLabel:'更新日期', format : 'Y-m-d',editable:false,id:'startUpdateTime',value:'',
		    	        	maxValue : new Date()},
		    	        	{ xtype:'datefield', name:'endUpdateTime', fieldLabel:'至', format : 'Y-m-d',editable:false,id:'endUpdateTime',value:'',
		    	        		maxValue : new Date()},
		    	        		
		    	        		]
		    },
		    
		    
		    
		  ],
		    buttonAlign: 'center',
		    buttons: [
		{
		    text: '查找',
		    id : 'saveButton',
		    iconCls: 'icon-search',
		    handler: function () {
		    	
		    	store.reload({ params:{
		    		'academyId':academyId,
	    			 'grade':grade,'classId':classId,
		    		'num':getFieldValue('num'),
		    		'name':getFieldValue('name'),
		    		'sex':getFieldValue('sex'),
		    		'status':getFieldValue('status'),
		    		'address':getFieldValue('address'),
		    		'nativePlace':getFieldValue('nativePlace'),
		    		'homeAddress':getFieldValue('homeAddress'),
		    		'mobile':getFieldValue('mobile'),
		    		'idCard':getFieldValue('idCard'),
		    		'tel':getFieldValue('tel'),
		    		'startBirth':getFieldValue('startBirth'),
		    		'endBirth':getFieldValue('endBirth'),
		    		'startAdmissionDate':getFieldValue('startAdmissionDate'),
		    		'endAdmissionDate':getFieldValue('endAdmissionDate'),
		    		'startJoinDate':getFieldValue('startJoinDate'),
		    		'endJoinDate':getFieldValue('endJoinDate'),
		    		'startCreateTime':getFieldValue('startCreateTime'),
		    		'endCreateTime':getFieldValue('endCreateTime'),
		    		'startUpdateTime':getFieldValue('startUpdateTime'),
		    		'endUpdateTime':getFieldValue('endUpdateTime'),
		    		} });
                checkWin.close(this);
		    }
		}, {
		    text: '关闭',
		    iconCls: 'icon-close',
		    handler: function () {
		    	checkWin.close(this);
		    }
		}
		]
		});
		
		var checkWin = Ext.create("Ext.window.Window", {
		    title: "高级查询",       //标题
		    maximizable :true,
		    draggable: true,
		    constrainHeader:true,//true将窗口约束到可见区域，false不限制窗体头部位置
		    iconCls: 'icon-search',
		    height: 300,                          //高度
		    width: 600,                           //宽度
		    layout: "fit",                        //窗口布局类型
		    modal: true, //是否模态窗口，默认为false
		    resizable: false,
		    items: [searchForm]
		});
			

	
		checkWin.show();
	 
	
}

//获取EXTJS中的FormPanel的所有控件值和属性  
var getFieldValue = function(id){
	  
	return Ext.getCmp(id).getValue();
}

