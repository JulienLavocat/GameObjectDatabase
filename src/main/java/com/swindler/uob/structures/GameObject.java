package com.swindler.uob.structures;

public class GameObject {

	private float x;
	private float y;
	private float z;
	private byte[] data;
	
	public GameObject(float x, float y, float z, byte[] data) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.data = data;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
	
	@Override
	public String toString() {
		return "(" + x + ";" + y + ";" + z + ") " + new String(data);
	}
	
}
