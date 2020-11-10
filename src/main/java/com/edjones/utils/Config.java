package com.edjones.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Config {
	static Logger LOGGER = Logger.getLogger(Config.class);

	private Properties properties;

	// Getters and Setters
	public Properties getProperties() {
		return properties;
	}

	// Constructor
	/**
	 * PropertyFileUtils Constructor - Initializes Properties Object for the file
	 * path specified
	 * 
	 * @param propertyFilePath
	 * @throws IOException
	 */
	public Config(String configFile) {
		properties = new Properties();
		try {
			FileInputStream Master = new FileInputStream(configFile);
			properties.load(Master);
			Master.close();
		} catch (IOException e) {
			LOGGER.error("Unable to load file", e);
		}
	}

	/**
	 * getPropertyValue function, returns value of the property key identified by
	 * parameter
	 * 
	 * @param propertyKey
	 * @return String value of the property key, returns null if not found
	 */
	public String getPropertyValue(String key) {
		return properties.getProperty(key, null);
	}

	/**
	 * isKeyExist function
	 * 
	 * @param propertyKey
	 * @return true, if key exist, false otherwise
	 */
	public boolean isKeyExist(String propertyKey) {
		return properties.containsKey(propertyKey);
	}
}
