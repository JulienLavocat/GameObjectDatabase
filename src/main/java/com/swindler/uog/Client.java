package com.swindler.uog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable {

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	
	public Client(Socket socket) throws IOException {
		this.socket = socket;
		this.in = socket.getInputStream();
		this.out = socket.getOutputStream();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
