package com.swindler.gob.configuration;

public class ConfigurationException extends Exception {

	private static final long serialVersionUID = -450734285116293989L;

	public ConfigurationException() {
		super("An error occurend while reading configuration");
	}
	
	public ConfigurationException(String message) {
		super(message);
	}
	
}
