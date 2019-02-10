package com.swindler.uog;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.swindler.uog.structures.Point;

public class ObjectCache {

	/*
	 * Requesting a chunk -> request processed by engine and then cached in a "result cache"
	 * When chunk is updated -> all cached chunks are invalidated
	 */
	
	private LoadingCache<Point, byte[]> cache;
	
	public ObjectCache(String name) {
		
//		cache = Caffeine.newBuilder()
//				.build(loadKey());
//		
	}
	
}
