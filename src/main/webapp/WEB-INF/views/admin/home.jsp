<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校务服务系统</title>
</head>
<body>
<jsp:include page="/extPath.jsp"></jsp:include>
<jsp:include page="schoolMessagePanel.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/extjs5/ux/TabCloseMenu.js"></script>



<script type="text/javascript">



Ext.onReady(function () {
	//panel布局 	
	 
	   
	    var centerPanel = Ext.create('Ext.TabPanel', {  
	       // title: '内容显示',  
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
               loader: { 
            	 url: basePath+'schoolMessage/findMessage.do',
            	 renderer: function(loader, response, active) {
                     var text = response.responseText;
                     loader.getTarget().update(text,true);
                     return true;
                 },
            	 scripts: true,
            	 autoLoad: true
             },
               closable: false,              
           }]
	       
	    });  
	    
	    var eastPanel = Ext.create('Ext.panel.Panel', {  
		      title: '在线用户',  
		      collapsible: true,  
		      region: 'east',
		      width: 120,
		      html : '',
		      bbar:{xtype:'label',text:'',id:'online'},
		  });  

	    
	    var viewport = Ext.create('Ext.container.Viewport', {  
	        title: 'Border Layout',  
	        layout: 'border',  
	        items: [northPanel, treePanel, centerPanel,eastPanel],  
	        renderTo: Ext.getBody()  
	    });  
//menu item click
	    treePanel.on("itemclick",function(tree, record, item, index, e, options) {
       		
	    	   var nodeText = record.data.text, 
	           tabPanel = viewport.items.get(2), 
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
	                           title : record.data.text,
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
	                           },*/
	                     		html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" '
	                         	+' src="${pageContext.request.contextPath}/'+record.data.url+'" '
	                         	+' ></iframe>' 
	                       }).show();
	               tabIndex = tabPanel.items.length - 1;
	           }
	           tabPanel.setActiveTab(tabIndex);
	    })
	    
	    
	    var websocket = null;
	  //判断当前浏览器是否支持WebSocket
	  if ('WebSocket' in window) {
	      websocket = new WebSocket("ws://localhost:8080/school/chatService");
	  }
	  else {
	      alert('当前浏览器 Not support websocket')
	  }

	  //接收到消息的回调方法
	  websocket.onmessage = function (event) {
	  		var json = JSON.parse(event.data);
	  		console.info(json);
	  		if ('message' == json.type){
	  			if ('${user.id}' == json.message.fromUserId){
	  				$('#groupChatDiv').append('<p align="" style="position:relative;left:150px;width:130px;word-wrap:break-word;word-break:break-all;padding:5px">'+
	  					'<a style="color:red">我</a>:'+'<a>'+json.message.message+'</p>');
	  			}else{
	  				$('#groupChatDiv').append('<p align="" style="width:130px;word-wrap:break-word;word-break:break-all;padding:5px">'+
	  					'<a style="color:blue">'+json.message.fromUserName+'</a>'+':'+
	  						json.message.message+'</p>');
	  			}
	  			chatWinFun();
	  		}else if('onlineUsers' == json.type){
	  			var users = json.onlineUsers;
	  			myMsg('提示',json.onlineUser.name+',刚刚上线');
	  			var html = '';
	  			for(var i=0;i<users.length;i++){
	  				html += '<h4 style="padding-left:5px"><a onclick=function(){}>'+users[i].name+'</a></h4>'; 
	  			}
	  			eastPanel.update(html);
	  			
	  		}else if('offlineUsers' == json.type){
	  			var users = json.onlineUsers;
	  			myMsg('提示',json.offlineUser.name+',刚刚下线');
	  			var html = '';
	  			for(var i=0;i<users.length;i++){
	  				html += '<h4 style="padding-left:5px"><a onclick="">'+users[i].name+'</a></h4>'; 
	  			}
	  			eastPanel.update(html);
	  		}


	  }
//user list 
	  //连接发生错误的回调方法
	  websocket.onerror = function () {
	      myWarn('警告',"网络连接发生错误");
	  };

	  //连接成功建立的回调方法
	  websocket.onopen = function () {
		 // myMsg('提示',"登陆成功");
	     Ext.getCmp('online').setText('在线');
	  }


	  //连接关闭的回调方法
	  websocket.onclose = function () {
		  myMsg('警告',"你已离线");
	  	Ext.getCmp('online').setText('离线');
	  }

	  //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	  window.onbeforeunload = function () {
	     // closeWebSocket();
	  }

	  //关闭WebSocket连接
	  function closeWebSocket() {
	      websocket.close();
	  }

	  //发送消息
	  function send() {
	      var message = Ext.getCmp('inputMessage').getValue();
	      var toUserId = Ext.getCmp('toUserId').getValue();
	      if (null != message && '' != message){
	         	 websocket.send('{fromUserId:"${user.id}",message:"'+message+'",fromUserName:"${user.name}",toUserId:"'+toUserId+'"}');
	         	 Ext.getCmp('inputMessage').setValue('')
	         	 Ext.getCmp('toUserId').setValue('')
	      }
	  }

	var chatPanel =   Ext.create('Ext.panel.Panel', {
			autoScroll:true,
		    html: '<div id="groupChatDiv"></div>',
		    bbar: [
		           { xtype: 'textfield',id:'inputMessage',height:30,width:220 },
		           { xtype: 'textfield',id:'toUserId',height:30,width:220,hidden:true },
		           { xtype: 'button',scale:'large', text: '发送',handler:function(){send()} }
		         ]
		});
	 
	  
	  function chatWinFun(){
		  chatWin.show();
		  
	  }
	  var chatWin = Ext.create('Ext.window.Window', {
		  title : '会话窗',
		  //minimizable : true,
		  //maximizable: true,
		  
		  collapsible:true,
		  closable:false,
	      height: 360,
	      width: 320,
	      layout: 'fit',
	      items :[chatPanel],
	      x:520,
	      y:10,
	      listeners: {
	    	   
	    	},
	  }).show();     
	 
	    
});


</script>
<jsp:include page="treePanel.jsp" flush="true"></jsp:include>
<jsp:include page="northPanel.jsp" flush="true"></jsp:include>

    
     
     

</body>

</html>