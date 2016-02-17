package io.konga.metadata.definition;

import java.util.List;
import java.util.Map;

import io.konga.metadata.annotations.Linked;
import io.konga.metadata.definition.enumerations.FieldTypes;
import io.konga.metadata.annotations.Createable;
import io.konga.metadata.annotations.Defaults;
import io.konga.metadata.annotations.Deleteable;
import io.konga.metadata.annotations.Editable;
import io.konga.metadata.annotations.Entity;
import io.konga.metadata.annotations.EntityId;
import io.konga.metadata.annotations.EntityKey;
import io.konga.metadata.annotations.Field;
import io.konga.metadata.annotations.FieldType;
import io.konga.metadata.annotations.Label;
import io.konga.metadata.annotations.Raw;
import io.konga.metadata.annotations.Required;
import io.konga.metadata.annotations.Searchable;
import io.konga.metadata.annotations.ShowInUpdate;
import io.konga.metadata.annotations.Type;
import io.konga.metadata.definition.enumerations.DataTypes;

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
	private DataTypes type;
	
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

	public DataTypes getType() {
		return type;
	}

	public void setType(
			DataTypes type) {
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
