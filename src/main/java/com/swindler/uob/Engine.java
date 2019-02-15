package com.swindler.uob;

import java.nio.ByteBuffer;

import com.swindler.uob.structures.GameObject;

/**
 * Used to serve PUSH and FIND request
 * @author Julien
 *
 */
public class Engine {

	public static ByteBuffer find(float x1, float y1, float x2, float y2) {
		
		//TODO: merge feature/database before implementing this function
		
		return null;
	}

	public static void push(ByteBuffer bb) {
		
		GameObject[] objects = new GameObject[bb.getInt()];
		
		for(int i = 0; i < objects.length; i++) {
			byte[] data = new byte[bb.getInt()];
			objects[i] = new GameObject(bb.getFloat(), bb.getFloat(), bb.getFloat(), data);
		}
		
		//TODO: batch update to database
		
	}

}
