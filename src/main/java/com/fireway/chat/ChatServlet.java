package com.fireway.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.resource.spi.RetryableUnavailableException;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.fireway.entity.ChatRecord;
import com.fireway.entity.User;
import com.fireway.sys.service.ChatRecordService;
import com.fireway.utils.MessageUtils;
import com.fireway.utils.Utils;
import com.sun.mail.handlers.message_rfc822;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint(value = "/chatService",configurator=GetHttpSessionConfigurator.class)
public class ChatServlet {
 
 
	
    private static final Map<HttpSession,ChatServlet> onlineUsers = new HashMap<HttpSession, ChatServlet>();
 
    private static int onlineCount = 0;
 
    private HttpSession httpSession;
 
    private Session session;
 
 
    @OnOpen
    public void onOpen(Session session,EndpointConfig config){
 
        this.session = session;
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        if(httpSession.getAttribute("user") != null){
            onlineUsers.put(httpSession, this);
            addOnlineCount();           //在线数加1
            Map<String, Object> online = getOnlineUsers("onlineUsers");
            online.put("onlineUser", httpSession.getAttribute("user"));//add this user
            broadcastAll(JSON.toJSON(online).toString());
        }
       
        System.out.println("有新连接加入!当前在线人数为" + onlineUsers.size());
    }
 
    @OnClose
    public void onClose(){
    	User user = (User) this.httpSession.getAttribute("user");
        onlineUsers.remove(this.httpSession);  //从set中删除
        subOnlineCount();           //在线数减1 
        Map<String, Object> online = getOnlineUsers("offlineUsers");
        online.put("offlineUser", user);
        broadcastAll(JSON.toJSON(online).toString());
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }
 
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        broadcastAll(getUserMessage(message).toString());
    }
 
    private void singleChat(String fromName, String toName, String mapContent) throws IOException {
    	
    }
    private void sendOffLine(String fromName, String toName) throws IOException {
        String msgContentString = toName + "不在线";
        for (HttpSession key : onlineUsers.keySet()) {
            if(key.getAttribute("user").equals(fromName) || key.getAttribute("user").equals(toName)){
                onlineUsers.get(key).session.getBasicRemote().sendText("");
            }
        }
    }
    private static void broadcastAll(String msg) {
        for (HttpSession key : onlineUsers.keySet()) {
            try {
                onlineUsers.get(key).session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("error");
        error.printStackTrace();
    }
 
 
    private Object getUserMessage(String message){
    	Map<String,Object> map = new HashMap<String, Object>();
    		ChatRecord chatRecord = JSON.parseObject(message, ChatRecord.class);
    		chatRecord.setId(Utils.uuid());
    		map.put("type", "message");
    		map.put("message", chatRecord);
    	
    	return JSON.toJSON(map);
    }
    
    private Map<String, Object> getOnlineUsers(String type) {
       Map<String, Object> map = new HashMap<String, Object>();
       List<User> list = new ArrayList<User>();
       for(HttpSession key : onlineUsers.keySet()){
    	  User user = (User) key.getAttribute("user");
    	  list.add(user);
       }
       map.put("onlineUsers", list);
       map.put("type", type);
        return map;
    }
 
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
 
    public static synchronized void addOnlineCount() {
    	ChatServlet.onlineCount++;
    }
 
    public static synchronized void subOnlineCount() {
    	ChatServlet.onlineCount--;
    }
}
