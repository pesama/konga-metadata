package io.konga.metadata.definition;

import io.konga.metadata.definition.enumerations.ValidatorTypes;

public class Validator {
	private ValidatorTypes type;
	private String value;
	public ValidatorTypes getType() {
		return type;
	}
	public void setType(ValidatorTypes type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
