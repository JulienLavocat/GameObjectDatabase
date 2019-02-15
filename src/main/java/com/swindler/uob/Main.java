package com.swindler.uob;

import com.swindler.uob.configuration.Cfg;
import com.swindler.uob.database.DB;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Cfg.start();
		
		DB.start();
	
		WS ws = new WS();
		ws.start();
		
	}

}
