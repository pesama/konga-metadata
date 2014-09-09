package org.kongaproject.metadata.definition;

import java.util.List;

public class ShowConfiguration {
	private boolean value;
	
	private List<String> fields;

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}
}
