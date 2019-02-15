package com.swindler.uob;

import java.sql.SQLException;

import com.swindler.uob.database.DB;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		DB.start();
	
		WS ws = new WS();
		ws.start();
		
	}

}
