package org.kongaproject.metadata.definition;

import org.kongaproject.metadata.definition.enumerations.DataType;
import org.kongaproject.metadata.definition.enumerations.TriggerSource;

public class TriggerParam {
	private TriggerSource source;
	private DataType type;
	private String value;
	public TriggerSource getSource() {
		return source;
	}
	public void setSource(TriggerSource source) {
		this.source = source;
	}
	public DataType getType() {
		return type;
	}
	public void setType(DataType type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
