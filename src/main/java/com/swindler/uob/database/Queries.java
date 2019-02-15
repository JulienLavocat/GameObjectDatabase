package com.swindler.uob.database;

public class Queries {

	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `objects` (`pos` point NOT NULL,`z` float NOT NULL,`data` blob NOT NULL)";
	public static final String CREATE_INDEX = "ALTER TABLE `objects` ADD SPATIAL `pos` (`pos`)";
	public static final String EXIST_TABLE = "SELECT count(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'objects' AND TABLE_SCHEMA = 'uob'";
	public static final String EXIST_SPATIAL_INDEX = "SELECT COUNT(1) IndexIsThere FROM INFORMATION_SCHEMA.STATISTICS WHERE table_schema=DATABASE() AND table_name='objects' AND index_name='pos'";
	public static final String FIND = "SELECT X(pos), Y(pos), z, data FROM objects";
	public static final String PUSH = "INSERT INTO objects (pos,z,data) VALUES (point(?,?),?,?)";

}
