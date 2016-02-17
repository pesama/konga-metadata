package io.konga.metadata.definition;

import java.util.List;

import io.konga.metadata.annotations.Editable;
import io.konga.metadata.annotations.FormStyle;
import io.konga.metadata.annotations.Label;
import io.konga.metadata.annotations.Raw;
import io.konga.metadata.definition.enumerations.FieldTypes;
import io.konga.metadata.annotations.Createable;
import io.konga.metadata.annotations.Deleteable;
import io.konga.metadata.annotations.Entity;
import io.konga.metadata.annotations.EntityId;
import io.konga.metadata.annotations.Field;
import io.konga.metadata.annotations.Searchable;
import io.konga.metadata.annotations.ShowInUpdate;
import io.konga.metadata.annotations.Type;
import io.konga.metadata.definition.enumerations.DataTypes;
import io.konga.metadata.definition.enumerations.FormStyles;

@Entity("field-type")
@Label("Field Type")
@Searchable
@Createable
@Editable
@Deleteable
@FormStyle(update=FormStyles.HORIZONTAL)
public class FieldType {
	
	@Field
	@EntityId
	private Integer id;
	
	@Field
	@Label("Search")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="PLAIN", value="Plain"),
		@Raw(key="DATE", value="Date"),
		@Raw(key="DATETIME", value="Date & Time"),
		@Raw(key="NUMBER", value="Number"),
		@Raw(key="QUANTITY", value="Quantity"),
		@Raw(key="PRICE", value="Price"),
		@Raw(key="SELECT", value="Select"),
		@Raw(key="TABLE", value="Table"),
		@Raw(key="PICK_LIST", value="Pick list"),
		@Raw(key="BOOLEAN", value="Boolean"),
		@Raw(key="OPTION", value="Option"),
		@Raw(key="COMPLEX", value="Complex"),
		@Raw(key="COMBOBOX", value="Combobox"),
		@Raw(key="PASSWORD", value="Password"),
		@Raw(key="COLOR", value="Color"),
		@Raw(key="CSS", value="Css"),
		@Raw(key="FILE ", value="File"),
		@Raw(key="IMAGE", value="Image"),
		@Raw(key="CUSTOM", value="Custom")
	})
	@io.konga.metadata.annotations.FieldType(FieldTypes.COMBOBOX)
	private FieldTypes search;
	
	@Field
	@Label("Results")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="PLAIN", value="Plain"),
		@Raw(key="DATE", value="Date"),
		@Raw(key="DATETIME", value="Date & Time"),
		@Raw(key="NUMBER", value="Number"),
		@Raw(key="QUANTITY", value="Quantity"),
		@Raw(key="PRICE", value="Price"),
		@Raw(key="SELECT", value="Select"),
		@Raw(key="TABLE", value="Table"),
		@Raw(key="PICK_LIST", value="Pick list"),
		@Raw(key="BOOLEAN", value="Boolean"),
		@Raw(key="OPTION", value="Option"),
		@Raw(key="COMPLEX", value="Complex"),
		@Raw(key="COMBOBOX", value="Combobox"),
		@Raw(key="PASSWORD", value="Password"),
		@Raw(key="COLOR", value="Color"),
		@Raw(key="CSS", value="Css"),
		@Raw(key="FILE ", value="File"),
		@Raw(key="IMAGE", value="Image"),
		@Raw(key="CUSTOM", value="Custom")
	})
	@io.konga.metadata.annotations.FieldType(FieldTypes.COMBOBOX)
	private FieldTypes results;
	
	@Field
	@Label("Details")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="PLAIN", value="Plain"),
		@Raw(key="DATE", value="Date"),
		@Raw(key="DATETIME", value="Date & Time"),
		@Raw(key="NUMBER", value="Number"),
		@Raw(key="QUANTITY", value="Quantity"),
		@Raw(key="PRICE", value="Price"),
		@Raw(key="SELECT", value="Select"),
		@Raw(key="TABLE", value="Table"),
		@Raw(key="PICK_LIST", value="Pick list"),
		@Raw(key="BOOLEAN", value="Boolean"),
		@Raw(key="OPTION", value="Option"),
		@Raw(key="COMPLEX", value="Complex"),
		@Raw(key="COMBOBOX", value="Combobox"),
		@Raw(key="PASSWORD", value="Password"),
		@Raw(key="COLOR", value="Color"),
		@Raw(key="CSS", value="Css"),
		@Raw(key="FILE ", value="File"),
		@Raw(key="IMAGE", value="Image"),
		@Raw(key="CUSTOM", value="Custom")
	})
	@io.konga.metadata.annotations.FieldType(FieldTypes.COMBOBOX)
	private FieldTypes details;
	
	@Field
	@Label("Update")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="PLAIN", value="Plain"),
		@Raw(key="DATE", value="Date"),
		@Raw(key="DATETIME", value="Date & Time"),
		@Raw(key="NUMBER", value="Number"),
		@Raw(key="QUANTITY", value="Quantity"),
		@Raw(key="PRICE", value="Price"),
		@Raw(key="SELECT", value="Select"),
		@Raw(key="TABLE", value="Table"),
		@Raw(key="PICK_LIST", value="Pick list"),
		@Raw(key="BOOLEAN", value="Boolean"),
		@Raw(key="OPTION", value="Option"),
		@Raw(key="COMPLEX", value="Complex"),
		@Raw(key="COMBOBOX", value="Combobox"),
		@Raw(key="PASSWORD", value="Password"),
		@Raw(key="COLOR", value="Color"),
		@Raw(key="CSS", value="Css"),
		@Raw(key="FILE ", value="File"),
		@Raw(key="IMAGE", value="Image"),
		@Raw(key="CUSTOM", value="Custom")
	})
	@io.konga.metadata.annotations.FieldType(FieldTypes.COMBOBOX)
	private FieldTypes update;
	
	// TODO Annotate
	private List<ScopedConfiguration> configuration;
	
	public FieldTypes getSearch() {
		return search;
	}
	public void setSearch(
			FieldTypes search) {
		this.search = search;
	}
	public FieldTypes getResults() {
		return results;
	}
	public void setResults(
			FieldTypes results) {
		this.results = results;
	}
	public FieldTypes getDetails() {
		return details;
	}
	public void setDetails(
			FieldTypes details) {
		this.details = details;
	}
	public FieldTypes getUpdate() {
		return update;
	}
	public void setUpdate(
			FieldTypes update) {
		this.update = update;
	}
	public List<ScopedConfiguration> getConfiguration() {
		return configuration;
	}
	public void setConfiguration(List<ScopedConfiguration> configuration) {
		this.configuration = configuration;
	}
}
