package org.kongaproject.metadata.definition;

import java.util.List;

public class Validation {
	private boolean required;
	private int minLength;
	private int maxLength;
	private List<Validator> validators;
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public int getMinLength() {
		return minLength;
	}
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public List<Validator> getValidators() {
		return validators;
	}
	public void setValidators(List<Validator> validators) {
		this.validators = validators;
	}
	
	
}
