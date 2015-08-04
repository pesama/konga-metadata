package org.kongaproject.metadata.definition;


public class ConfigurationParam {

	private String key;
	
	private Object value;
	
	public ConfigurationParam() {
		// Constructor by default. Nothing to do
	}
	
	public ConfigurationParam(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
