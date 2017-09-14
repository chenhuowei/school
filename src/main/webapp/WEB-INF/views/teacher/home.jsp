<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教工中心</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<jsp:include page="menuList.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/ux/TabCloseMenu.js"></script>
<script type="text/javascript">

Ext.onReady(function(){
	var store = Ext.create('Ext.data.TreeStore', {
	    proxy: {
	      type: 'ajax',
	      url: '${pageContext.request.contextPath}/menuList/list.do?type=teacher'
	    },
	    
	  });
	
	var treePanel = Ext.create('Ext.tree.Panel', {
		 icon: '${pageContext.request.contextPath}/jslib/icon/myIcon/Menu_mini.png',
	    collapsible: true,
	    width: 200,
	    height: 150,
	   	store: store,
	    root: {  
	    	text: "服务列表",
	        expanded: true,
	        nodeType: 'async'  
	    }, 
	    region: 'west',
	   // renderTo: Ext.getBody()
	});
	
	var northPanel = Ext.create('Ext.panel.Panel', {
	    region: 'north',
	   tbar:[
	         {xtype:'label', text :'教工服务中心'},
	         '->',
	         {xtype:'button',scale:'large', 
	        	 icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/Mail_Info.png'},'-',
	         {xtype:'button',scale:'large', icon:'${pageContext.request.contextPath}/jslib/icon/myIcon/User.png'},
	         {xtype:'label',text:'当前用户:${user.teacherNum}'},'-',
	         {xtype:'splitbutton',text:'${user.name}',width:122,scale:'medium', 
	        	 menu:[
	        	       {text:'退出账号',handler:function(){
	        	    	   $.ajax({
		                    	 url:'${pageContext.request.contextPath}/common/logout.do',
		                    	 dataType:'json',
		                    	 type:'get',
		                    	 success:function(m){
		                    		myMsg('提示',m.message);
		                    		window.location.href = '${pageContext.request.contextPath}/common/loginIndex.do';
		                    	 }
		                     })
	        	       },
	        	       }
	        	       ],
	        	 listeners:{
	        	    	   'mouseover':function( button,  e, eOpts ){
	        	    		   button.showMenu();
	        	    	   },
	        	    	   mouseout:function( button,  e, eOpts ){
	        	    		 //  button.hideMenu();
	        	    	   }
	        	       }
	         },'-',
	         
	         
	         
	         ]
	});
	
	 var centerPanel = Ext.create('Ext.TabPanel', {  
	       // title: '内容显示', 
	       header:false,
	        deferredRender : false,  
	        activeTab : 0,  
	        enableTabScroll : true,   
	        region: 'center',
	       
	        plugins : Ext.create('Ext.ux.TabCloseMenu', {  
             closeTabText : '关闭当前页',  
             closeOthersTabsText : '关闭其他页',  
             closeAllTabsText : '关闭所有页'  
         }),
         items: [{
             id: "first",
             title: '首页',
             autoScroll :true,
            // html: "这只是一个非常普通的Tab。",
             //items:[messagePanel],
             closable: false, 
             loader: { 
            	 url: basePath+'schoolMessage/findMessage.do',
            	 renderer: function(loader, response, active) {
                     var text = response.responseText;
                     loader.getTarget().update(text,true);
                     return true;
                 },
            	 scripts: true,
            	 autoLoad: true
             }
         }]
	       
	    });  
	 var viewport = Ext.create('Ext.container.Viewport', {  
	        title: 'Border Layout',  
	        layout: 'border',  
	        items: [treePanel, centerPanel,northPanel],  
	        renderTo: Ext.getBody()  
	    }); 
	 
	 
	 
	 treePanel.on("itemclick",function(tree, record, item, index, e, options) {
		 if (record.data.leaf){
    		var headText = tree.getStore().findRecord('id',record.data.pid).data.text;
			 
		 }
  	   var nodeText = headText+" / "+record.data.text, 
         tabPanel = viewport.items.get(1), 
         tabBar = tabPanel.getTabBar(), 
         tabIndex;
         for (var i = 0; i < tabBar.items.length; i++) {
             if (tabBar.items.get(i).getText() === nodeText) {
                 tabIndex = i;
             }
         }
         
         if (Ext.isEmpty(tabIndex)) {
         	 if (!record.data.leaf){
              	return;
              }
             tabPanel.add({
            				//id : 'centerPanel',
                         title : nodeText,
                         //bodyPadding : 10,
                         closable : true,
                         renderTo: Ext.getBody(),
                       /**  
                         loader: { 
                        	 url: basePath+record.data.url,
                        	 renderer: function(loader, response, active) {
                                 var text = response.responseText;
                                 loader.getTarget().update(text,true);
                                 return true;
                             },
                        	 scripts: true,
                        	 autoLoad: true
                         }
             */
                   		html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" '
                       	+' src="${pageContext.request.contextPath}/'+record.data.url+'" '
                       	+' ></iframe>' 
                     }).show();
             tabIndex = tabPanel.items.length - 1;
         }
         tabPanel.setActiveTab(tabIndex);
  })
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
})



</script>


</body>
</html>