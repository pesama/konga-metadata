package org.kongaproject.metadata.definition;

public class DataType {
	private org.kongaproject.metadata.definition.enumerations.DataType type;
	
	private String complexType;

	public org.kongaproject.metadata.definition.enumerations.DataType getType() {
		return type;
	}

	public void setType(
			org.kongaproject.metadata.definition.enumerations.DataType type) {
		this.type = type;
	}

	public String getComplexType() {
		return complexType;
	}

	public void setComplexType(String complexType) {
		this.complexType = complexType;
	}
	
	
}
