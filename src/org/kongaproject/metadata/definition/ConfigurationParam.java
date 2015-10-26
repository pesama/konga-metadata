package org.kongaproject.metadata.definition;

import org.kongaproject.metadata.annotations.Access;
import org.kongaproject.metadata.annotations.Createable;
import org.kongaproject.metadata.annotations.Deleteable;
import org.kongaproject.metadata.annotations.Editable;
import org.kongaproject.metadata.annotations.Entity;
import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.annotations.EntityKey;
import org.kongaproject.metadata.annotations.Field;
import org.kongaproject.metadata.annotations.Hint;
import org.kongaproject.metadata.annotations.Label;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.definition.enumerations.AccessModes;

@Entity("configuration-parameter")
@Label("Configuration parameter")
@Access(AccessModes.HIDDEN)
@Createable
@Editable
@Searchable
@Deleteable
public class ConfigurationParam {

	@Field
	@Label("ID")
	@EntityId
	private Integer id;
		
	@Field
	@Label("Key")
	@Hint("Enter the key for your configuration parameter")
	@EntityKey
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
