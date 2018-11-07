package com.websocket.home;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint("/actions")
public class DeviceWebSocketServer {
	

	private DeviceSessionHandler sessionHandler = new DeviceSessionHandler();

	@OnOpen
	public void open(Session session) {
		sessionHandler.addSession(session);
	} // close method
	
	@OnClose
	public void close(Session session) {
		sessionHandler.removeSession(session);
	} // close method
	
	@OnError
	public void onError(Throwable error) {
		Logger.getLogger(DeviceWebSocketServer.class.getName()).log(Level.SEVERE, null, error);
	} // close method
	
	@OnMessage
	public void handleMessage(String message, Session session) {
		
		 try (JsonReader reader = Json.createReader(new StringReader(message))) {
	            JsonObject jsonMessage = reader.readObject();

	            if ("add".equals(jsonMessage.getString("action"))) {
	                Device device = new Device();
	                device.setName(jsonMessage.getString("name"));
	                device.setDescription(jsonMessage.getString("description"));
	                device.setType(jsonMessage.getString("type"));
	                device.setStatus("Off");
	                sessionHandler.addDevice(device);
	            } // close if

	            if ("remove".equals(jsonMessage.getString("action"))) {
	                int id = (int) jsonMessage.getInt("id");
	                sessionHandler.removeDevice(id);
	            } // close if

	            if ("toggle".equals(jsonMessage.getString("action"))) {
	                int id = (int) jsonMessage.getInt("id");
	                sessionHandler.toggleDevice(id);
	            } // close if
	            
	        } // close try
		 
	} // close method
	
} // close class
