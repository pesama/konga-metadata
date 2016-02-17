package io.konga.metadata.definition;

import java.util.List;

import io.konga.metadata.annotations.Editable;
import io.konga.metadata.annotations.EntityId;
import io.konga.metadata.annotations.Label;
import io.konga.metadata.definition.enumerations.FieldTypes;
import io.konga.metadata.annotations.Createable;
import io.konga.metadata.annotations.Deleteable;
import io.konga.metadata.annotations.Entity;
import io.konga.metadata.annotations.EntityKey;
import io.konga.metadata.annotations.Field;
import io.konga.metadata.annotations.FieldType;
import io.konga.metadata.annotations.Searchable;
import io.konga.metadata.annotations.ShowInUpdate;

@Entity("validation")
@Label("Validation rules")
@Createable
@Searchable
@Editable
@Deleteable
public class Validation {
	
	@Field
	@EntityId
	@EntityKey
	private Integer id;
	
	@Field
	@Label("Required field")
	@ShowInUpdate
	@FieldType(FieldTypes.SWITCH)
	@Editable
	private Boolean required;
	
	@Field
	@Label("Minimum")
	@ShowInUpdate
	@Editable
	private Integer minLength;
	
	@Field
	@Label("Maximum")
	@ShowInUpdate
	@Editable
	private Integer maxLength;
	
//	TODO
	private List<Validator> validators;
	
	public Boolean isRequired() {
		return required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
	}
	public Integer getMinLength() {
		return minLength;
	}
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
	public Integer getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	public List<Validator> getValidators() {
		return validators;
	}
	public void setValidators(List<Validator> validators) {
		this.validators = validators;
	}
	
	
}
