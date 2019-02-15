package com.swindler.uob;

import java.nio.ByteBuffer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/*
 * Find request: 0 / x1 / y1 / x1 / x2 -> total length: 1 + 4 * 4 = 17 bytes (1 byte for id + 16 bytes of float coordinates)
 * Push request: 1 / objectCount / objectCount * (x / y / z / dataLength / data) -> header length: 1 + 4 = 5 bytes (1 byte for id + 4 bytes of integer object count)
 */
public class WS extends WebSocketServer {
	
	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		try {

			if(!Utils.splitQuery(handshake.getResourceDescriptor().substring(2)).get("token").equals(Cfg.ACCESS_TOKEN))
				throw new Exception("Invalid access token");
			else
				conn.send("Connected to UnityObjectDatabase");
			
		} catch (Exception e) { conn.close(4001, e.getMessage()); }
		
	}
	
	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		
	}
	
	@Override
	public void onMessage(WebSocket conn, ByteBuffer bb) {
		
		switch(bb.get()) {
			
			case 0: //Find request
				
				if(bb.remaining() != 16) //Check if request size is normal, see line 10
					return;
				
				conn.send(Engine.find(bb.getFloat(), bb.getFloat(), bb.getFloat(), bb.getFloat()));
				
			break;
				
			case 1:	//Push request
				
				//Since serialized gameobject size, type, format, etc... could not be determined, pushed data are not checked
				
				Engine.push(bb);
				
				break;
		
		}
		
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		
	}

	@Override
	public void onStart() {
		System.out.println("Unity Object Database started");
	}

}
