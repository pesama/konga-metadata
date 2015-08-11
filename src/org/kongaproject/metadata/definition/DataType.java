package org.kongaproject.metadata.definition;

import java.util.List;
import java.util.Map;

public class DataType {
	private org.kongaproject.metadata.definition.enumerations.DataTypes type;
	
	private String complexType;
	
	private String filter;
	
	private Map<String, String> query;
	
	private List<ConfigurationParam> list;
	
	private String from;

	public org.kongaproject.metadata.definition.enumerations.DataTypes getType() {
		return type;
	}

	public void setType(
			org.kongaproject.metadata.definition.enumerations.DataTypes type) {
		this.type = type;
	}

	public String getComplexType() {
		return complexType;
	}

	public void setComplexType(String complexType) {
		this.complexType = complexType;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public Map<String, String> getQuery() {
		return query;
	}

	public void setQuery(Map<String, String> query) {
		this.query = query;
	}

	public List<ConfigurationParam> getList() {
		return list;
	}

	public void setList(List<ConfigurationParam> list) {
		this.list = list;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
