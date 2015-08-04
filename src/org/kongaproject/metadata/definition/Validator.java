package org.kongaproject.metadata.definition;

import org.kongaproject.metadata.definition.enumerations.ValidatorType;

public class Validator {
	private ValidatorType type;
	private String value;
	public ValidatorType getType() {
		return type;
	}
	public void setType(ValidatorType type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
