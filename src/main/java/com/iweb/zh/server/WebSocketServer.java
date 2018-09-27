package com.iweb.zh.server;
 
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
 

@Slf4j
@ServerEndpoint("/webSocket/{token}")
@Component
public class WebSocketServer {
	
	//
    private static final Map<String, Session> rooms = new ConcurrentHashMap();

//    private 
    
    @OnOpen
    public void connect(@PathParam("token") String token, Session session) throws Exception {
        // 将session按照用户名来存储
        if (!rooms.containsKey(token)) {
            // 创建房间不存在时，创建房间
            Set<Session> room = new HashSet<>();
            // 添加用户
            rooms.put(token, session);
        } else {
            session.close();
        }
        log.info("a client has connected!");
    }
 
    @OnClose
    public void disConnect(@PathParam("token") String token, Session session) {
        rooms.remove(token);
        log.info("a client has disconnected!");
    }
 
    @OnMessage
    public void receiveMsg(@PathParam("token") String token,
                           String msg, Session session) throws Exception {
        // 此处应该有html过滤
        msg = token + ":" + msg;
        log.info(msg);
        // 接收到信息后进行广播
        //broadcast(token, msg);
    }

    // 按照用户名名进行推送消息
    public static void broadcast(String token, String msg) throws Exception {
        rooms.get(token).getBasicRemote().sendText(msg);
    }
 
}
