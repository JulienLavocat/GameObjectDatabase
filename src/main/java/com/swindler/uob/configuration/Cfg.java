package com.swindler.uob.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cfg {
	
	private static final Path path = Paths.get("config.properties");
	
	public static String 	WS_HOST;
	public static int 		WS_PORT;
	public static String 	WS_ACCESS_KEY;
	public static String 	DB_HOST;
	public static String 	DB_DATABASE;
	public static String 	DB_USER;
	public static String 	DB_PASSWORD;
	//public static String 	DB_JDBC_URL;

	public static void start() throws Exception {
		
		ensureFileExist();
		loadAndValidate();
		
	}

	private static void ensureFileExist() throws FileNotFoundException, IOException {
		
		if(Files.exists(path)) return;
		
		OrderedProperties props = new OrderedProperties();
		
		props.setProperty("ws_host", "localhost");
		props.setProperty("ws_port", "80");
		props.setProperty("ws_accesskey", "keyToSecureDatabaseAccess");
		props.setProperty("db_host", "localhost");
		props.setProperty("db_database", "uob");
		props.setProperty("db_user", "root");
		props.setProperty("db_password", "");
		//props.setProperty("db_jdbc_url", "");
		
		props.store(new FileOutputStream(path.toFile()), "UnityObjectDatabase default configuration.");
		
	}
	
	private static void loadAndValidate() throws FileNotFoundException, IOException, ConfigurationException {
		
		OrderedProperties props = new OrderedProperties();
		props.load(new FileInputStream(path.toFile()));
		
		if(props.isEmpty())	//Shouldn't happen
			throw new ConfigurationException("Configuration is empty");
		
		WS_HOST 		= props.getProperty("ws_host");
		WS_PORT 		= Integer.parseInt(props.getProperty("ws_port"));
		WS_ACCESS_KEY 	= props.getProperty("ws_accesskey");
		DB_HOST 		= props.getProperty("db_host");
		DB_DATABASE 	= props.getProperty("db_database");
		DB_USER 		= props.getProperty("db_user");
		DB_PASSWORD 	= props.getProperty("db_password");
		
	}
	
}
