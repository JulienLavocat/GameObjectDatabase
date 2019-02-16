package com.swindler.gob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swindler.gob.configuration.Cfg;
import com.swindler.gob.database.DB;

public class Main {

	public static final Logger log = LoggerFactory.getLogger("GOB");
	
	public static void main(String[] args) throws Exception {
		
		Cfg.start();
		
		DB.start();
	
		WS ws = new WS();
		ws.start();
		
	}

	public static void logOnMain(String string) {
		log.info(string);
	}

}
