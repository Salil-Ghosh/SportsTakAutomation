package com.utilities;



import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	private Map<String, Object> context;

	public ScenarioContext() {
		context = new HashMap<>();
	}

	/**
	 * This method set the value in given Key
	 * 
	 * @param key
	 * @param value
	 */
	public void setContext(String key, Object value) {
		context.put(key, value);
	}

	/**
	 * This method returns the value of given key
	 * 
	 * @param key
	 * @return
	 */

	public Object getContext(String key) {
		return context.get(key);
	}

	/**
	 * checked key contains or not
	 * 
	 * @param key
	 * @return
	 */
	public Boolean isContains(String key) {
		return context.containsKey(key.toString());
	}
}

