package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.annotations.Createable;
import org.kongaproject.metadata.annotations.Deleteable;
import org.kongaproject.metadata.annotations.Editable;
import org.kongaproject.metadata.annotations.Entity;
import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.annotations.EntityKey;
import org.kongaproject.metadata.annotations.Field;
import org.kongaproject.metadata.annotations.FieldType;
import org.kongaproject.metadata.annotations.Label;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.annotations.ShowInUpdate;
import org.kongaproject.metadata.definition.enumerations.FieldTypes;

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
