package io.konga.metadata.definition;

import io.konga.metadata.definition.enumerations.DataTypes;
import io.konga.metadata.definition.enumerations.TriggerSources;

public class TriggerParam {
	private TriggerSources source;
	private DataTypes type;
	private String value;
	public TriggerSources getSource() {
		return source;
	}
	public void setSource(TriggerSources source) {
		this.source = source;
	}
	public DataTypes getType() {
		return type;
	}
	public void setType(DataTypes type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
