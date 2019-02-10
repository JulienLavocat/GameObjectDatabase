package com.swindler.uog.structures;

import java.util.Objects;

public class Point {

	private float x;
	private float y;
	private float z;
	private int hashCode;
	
	public Point() {
		this(0, 0, 0);
	}
	
	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.hashCode = Objects.hash(x, y, z);
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof Point))
			return false;
		
		if(obj == this)
			return true;
		
		Point b = (Point)obj;
		
		return Float.floatToIntBits(x) == Float.floatToIntBits(b.x)
				&& Float.floatToIntBits(y) == Float.floatToIntBits(b.y)
				&& Float.floatToIntBits(z) == Float.floatToIntBits(b.z);
		
	}
	
}
