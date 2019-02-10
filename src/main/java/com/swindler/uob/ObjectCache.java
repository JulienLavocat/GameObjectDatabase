package com.swindler.uob;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.swindler.uob.structures.Point;

/**
 * Part of the old system but may be useful in the future for request caching, deprecated for now.
 * @author Julien Lavocat
 *
 */
@Deprecated
public class ObjectCache {

	/*
	 * Requesting a chunk -> request processed by engine and then cached in a "result cache"
	 * When chunk is updated -> all cached chunks are invalidated
	 */
	private LoadingCache<Point, byte[]> cache;
	
	public ObjectCache(String name) {
		
		cache = Caffeine.newBuilder()
				.build(key -> loadKey(key));
		
	}

	public LoadingCache<Point, byte[]> getCache() {
		return cache;
	}
	
	private byte[] loadKey(Point key) {
		return null;
	}
	
}
