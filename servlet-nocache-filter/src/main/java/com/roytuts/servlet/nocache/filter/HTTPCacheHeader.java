package com.roytuts.servlet.nocache.filter;

public enum HTTPCacheHeader {

	CACHE_CONTROL("Cache-Control"), //
	EXPIRES("Expires"), //
	PRAGMA("Pragma");

	private String name;

	private HTTPCacheHeader(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
