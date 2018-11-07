package com.websocket.simple;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatroomServerEndpoint")
public class ChatroomServerEndpoint {
	static Set<Session> allUsers = Collections.synchronizedSet(new HashSet<>());

	// main 페이지 입장 시 : 소켓 연결이 될 때, 
	@OnOpen
	public void handleOpen(Session userSession) {
		System.out.println("ChatroomServerEndpoint reached");
		System.out.println("Socket Opened for user_id : " + userSession.getId());
		
		// 유저의 세션을 모든 유저들의 세션집합에 추가 
		allUsers.add(userSession);
	} // close method
	
	// client로부터 메시지를 받았을 때, 
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		System.out.println("server : message received from user : " + userSession.getId());
		System.out.println("message : " + message);
		String username = (String) userSession.getUserProperties().get("username");
		if (username == null) {
			userSession.getUserProperties().put("username", message);
			userSession.getBasicRemote().sendText(buildJsonData("System", "you are now connected as " + message));
		
		} else {
			Iterator<Session> iterator = allUsers.iterator();
			while (iterator.hasNext()) {
				iterator.next().getBasicRemote().sendText(buildJsonData(username, message));
			}  // close while-loop
		}  // close if-else
	} // close method
	
	// main 페이지 이탈 시 처리 함수 
	@OnClose
	public void handleClose(Session userSession) {
		System.out.println("Close session : user " + userSession.getId());
		allUsers.remove(userSession);

	} // close method

	private String buildJsonData(String username, String message) {
		System.out.println("Building Json data for user " + username);
		
		JsonObject jsonObject = Json.createObjectBuilder().add("message", username + ": " + message).build();
		StringWriter stringWriter = new StringWriter();
		try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
			jsonWriter.write(jsonObject);
		} // close try
		
		return stringWriter.toString();
	} // close method

} // close class
