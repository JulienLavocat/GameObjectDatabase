package com.swindler.gob.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swindler.gob.configuration.Cfg;
import com.swindler.gob.structures.GameObject;

public class DB {

	private static Connection con;
	private static PreparedStatement FIND;
	private static PreparedStatement PUSH;
	
	private static Logger log = LoggerFactory.getLogger("GOB");
	
	public static void start() throws SQLException {

		log.info("Connecting to SQL Server");
		
		con = DriverManager.getConnection("jdbc:mariadb://" + Cfg.DB_HOST + "/" + Cfg.DB_DATABASE, Cfg.DB_USER, Cfg.DB_PASSWORD);
		
		checkDatabaseStructure();
		
		FIND 	= con.prepareStatement(Queries.FIND);
		PUSH 	= con.prepareStatement(Queries.PUSH);
		
		log.info("Database intialized");
		
	}

	public static ArrayList<GameObject> find(float x1, float y1, float x2, float y2) throws SQLException {
	
		ResultSet rs = FIND.executeQuery();
		ArrayList<GameObject> objs = new ArrayList<>();
		
		while(rs.next())
			objs.add(new GameObject(rs.getFloat(1), rs.getFloat(2), rs.getFloat(3), rs.getBytes(4)));
		
		return objs;
		
	}	
	public static synchronized void push(GameObject[] objs) throws SQLException {
		
		PUSH.clearBatch();
		
		for(GameObject o : objs) {
			PUSH.setFloat(1, o.getX());
			PUSH.setFloat(2, o.getY());
			PUSH.setFloat(3, o.getZ());
			PUSH.setBlob(4, new SerialBlob(o.getData()));
			PUSH.addBatch();
		}
		
		PUSH.execute();
		
	}

	private static void checkDatabaseStructure() throws SQLException {
		
		log.info("Checking database");
		
		Statement st = con.createStatement();
		
		ResultSet rs;
		
		//Create table if not exists
		st.execute(Queries.EXIST_TABLE);	//Query table presence
		rs = st.getResultSet();
		rs.next();
		long existTable = rs.getLong(1);
		
		if(existTable == 0) {
			log.warn("Missing objects table, creating it");
			st.execute(Queries.CREATE_TABLE);
		}
		
		
		//Checking for spatial index on position
		rs = st.executeQuery(Queries.EXIST_SPATIAL_INDEX);
		rs.next();
		if(rs.getInt(1) != 1) {	//No spatial index on pos if = 0
			log.warn("Missing SPATIAL index on pos, creating it");
			st.execute(Queries.CREATE_INDEX);
		}
		
		log.info("Database checked");
		
	}

}
