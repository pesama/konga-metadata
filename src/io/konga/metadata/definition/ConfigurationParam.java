package io.konga.metadata.definition;

import io.konga.metadata.definition.enumerations.AccessModes;
import io.konga.metadata.annotations.Access;
import io.konga.metadata.annotations.Createable;
import io.konga.metadata.annotations.Deleteable;
import io.konga.metadata.annotations.Editable;
import io.konga.metadata.annotations.Entity;
import io.konga.metadata.annotations.EntityId;
import io.konga.metadata.annotations.EntityKey;
import io.konga.metadata.annotations.EntityLabel;
import io.konga.metadata.annotations.Field;
import io.konga.metadata.annotations.Hint;
import io.konga.metadata.annotations.Label;
import io.konga.metadata.annotations.Searchable;

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
	
	@Field
	@Label("Value")
	@Hint("Choose a value for your configuration")
	@EntityLabel
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
