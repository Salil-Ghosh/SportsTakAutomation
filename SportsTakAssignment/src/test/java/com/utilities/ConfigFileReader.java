package com.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.PatternSyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.util.StringUtils;

public class ConfigFileReader {

	private Properties properties;
	private static final String PROPERTY_FILE_PATH = System.getProperty("user.dir") + "/configs/config.properties";
	private static Class<?> className = ConfigFileReader.class;
	Logger LogUtils = LogManager.getLogger(className);
	public ConfigFileReader() {
		try (FileReader fileReader = new FileReader(PROPERTY_FILE_PATH)) {
			try (BufferedReader reader = new BufferedReader(fileReader)) {
				loadProperties(reader);
			}
		} catch (FileNotFoundException e) {
			LogUtils.error( "FileNotFoundException=" + e);
		} catch (IOException e) {
			LogUtils.error( "IOException = " + e);
		}

	}

	public ConfigFileReader(String configFilePath) {
		try (FileReader fileReader = new FileReader(configFilePath)) {
			try (BufferedReader reader = new BufferedReader(fileReader)) {
				loadProperties(reader);
			}
		} catch (FileNotFoundException e) {
			LogUtils.error( "FileNotFoundException=" + e);
		} catch (IOException e) {
			LogUtils.error( "IOException = " + e);
		}
	}

	private void loadProperties(BufferedReader reader) {
		properties = new Properties();
		try {
			properties.load(reader);
		} catch (IOException e) {
			LogUtils.error( "IOException = " + e);
			throw new RuntimeException(e);
		}
	}


	public String getBrowserName() {

		String testEnv = properties.getProperty("BrowserName");
		return testEnv;
	}
	

	public String getDisableNotification() {

		String disableNotification = properties.getProperty("disableNotification");
		return disableNotification;
	}






	public String getApplicationUrl() {
		String url;

		LogUtils.info("Default Test Environment is : " + properties.getProperty("TestEnv"));
		url = properties.getProperty("URL_" + properties.getProperty("TestEnv"));

		if (url != null) {
			LogUtils.info("Test URl - " + url);
			return url;
		} else {
			throw new RuntimeException("Test Env not specified in the config.properties file.");
		}
	}

	/**
	 * This method return TestEnvironment as per the input from Maven command. In
	 * case maven does not specify any input, it takes default value from config
	 * file.
	 * 
	 * @return
	 */
	public String getTestEnv() {

		String testEnv = properties.getProperty("TestEnv");
		return testEnv;
	}
	


}


