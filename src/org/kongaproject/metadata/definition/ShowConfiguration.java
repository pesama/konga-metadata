package org.kongaproject.metadata.definition;

import java.util.List;

public class ShowConfiguration {
	private String value;
	
	private List<String> fields;
	
	private List<ConfigurationParam> configuration;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public List<ConfigurationParam> getConfiguration() {
		return configuration;
	}

	public void setConfiguration(List<ConfigurationParam> configuration) {
		this.configuration = configuration;
	}
}
