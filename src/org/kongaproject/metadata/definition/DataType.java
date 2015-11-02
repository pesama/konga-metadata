package org.kongaproject.metadata.definition;

import java.util.List;
import java.util.Map;

import org.kongaproject.metadata.annotations.Createable;
import org.kongaproject.metadata.annotations.Defaults;
import org.kongaproject.metadata.annotations.Deleteable;
import org.kongaproject.metadata.annotations.Editable;
import org.kongaproject.metadata.annotations.Entity;
import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.annotations.EntityKey;
import org.kongaproject.metadata.annotations.Field;
import org.kongaproject.metadata.annotations.FieldType;
import org.kongaproject.metadata.annotations.Label;
import org.kongaproject.metadata.annotations.Linked;
import org.kongaproject.metadata.annotations.Raw;
import org.kongaproject.metadata.annotations.Required;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.annotations.ShowInUpdate;
import org.kongaproject.metadata.annotations.Type;
import org.kongaproject.metadata.definition.enumerations.DataTypes;
import org.kongaproject.metadata.definition.enumerations.FieldTypes;

@Entity("data-type")
@Label("Data type")
@Createable
@Searchable
@Editable
@Deleteable
public class DataType {
	
	@Field
	@EntityId
	private Integer id;
	
	@Field
	@Label("Type")
	@ShowInUpdate
	@EntityKey
	@Editable
	@Required
	@Type(value=DataTypes.STRING, list={
		@Raw(key="STRING", value="String"),
		@Raw(key="NUMBER", value="Number"),
		@Raw(key="BOOLEAN", value="Boolean"),
		@Raw(key="DATE", value="Date"),
		@Raw(key="COMPLEX", value="Complex (Reference to another object)"),
		@Raw(key="FILE", value="File")
	})
	@FieldType(FieldTypes.COMBOBOX)
	@Defaults("STRING")
	private org.kongaproject.metadata.definition.enumerations.DataTypes type;
	
	@Field
	@Label("Complex type")
	@ShowInUpdate
	@Editable
	@Linked(to="type", via="complex-type-selector")
	private String complexType;
	
//	@Field
//	@Label("Filter")
//	@Hint("Enter the name of a custom angular filter for this entities")
//	@ShowInUpdate
//	@Editable
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
