package com.swindler.uog;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Net {

	private static ServerSocket ss;
	
	public static void start(int port) throws IOException {
		
		ss = new ServerSocket(port);
		
		run();
		
	}

	private static void run() throws IOException {
		
		while(true) {
			
			Socket cSocket = ss.accept();
			
			
		}
		
	}
	
}
