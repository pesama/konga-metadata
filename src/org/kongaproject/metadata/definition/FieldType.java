package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.annotations.Createable;
import org.kongaproject.metadata.annotations.Deleteable;
import org.kongaproject.metadata.annotations.Editable;
import org.kongaproject.metadata.annotations.Entity;
import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.annotations.Field;
import org.kongaproject.metadata.annotations.FormStyle;
import org.kongaproject.metadata.annotations.Label;
import org.kongaproject.metadata.annotations.Raw;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.annotations.ShowInUpdate;
import org.kongaproject.metadata.annotations.Type;
import org.kongaproject.metadata.definition.enumerations.DataTypes;
import org.kongaproject.metadata.definition.enumerations.FieldTypes;
import org.kongaproject.metadata.definition.enumerations.FormStyles;

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
	@org.kongaproject.metadata.annotations.FieldType(FieldTypes.COMBOBOX)
	private org.kongaproject.metadata.definition.enumerations.FieldTypes search;
	
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
	@org.kongaproject.metadata.annotations.FieldType(FieldTypes.COMBOBOX)
	private org.kongaproject.metadata.definition.enumerations.FieldTypes results;
	
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
	@org.kongaproject.metadata.annotations.FieldType(FieldTypes.COMBOBOX)
	private org.kongaproject.metadata.definition.enumerations.FieldTypes details;
	
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
	@org.kongaproject.metadata.annotations.FieldType(FieldTypes.COMBOBOX)
	private org.kongaproject.metadata.definition.enumerations.FieldTypes update;
	
	// TODO Annotate
	private List<ScopedConfiguration> configuration;
	
	public org.kongaproject.metadata.definition.enumerations.FieldTypes getSearch() {
		return search;
	}
	public void setSearch(
			org.kongaproject.metadata.definition.enumerations.FieldTypes search) {
		this.search = search;
	}
	public org.kongaproject.metadata.definition.enumerations.FieldTypes getResults() {
		return results;
	}
	public void setResults(
			org.kongaproject.metadata.definition.enumerations.FieldTypes results) {
		this.results = results;
	}
	public org.kongaproject.metadata.definition.enumerations.FieldTypes getDetails() {
		return details;
	}
	public void setDetails(
			org.kongaproject.metadata.definition.enumerations.FieldTypes details) {
		this.details = details;
	}
	public org.kongaproject.metadata.definition.enumerations.FieldTypes getUpdate() {
		return update;
	}
	public void setUpdate(
			org.kongaproject.metadata.definition.enumerations.FieldTypes update) {
		this.update = update;
	}
	public List<ScopedConfiguration> getConfiguration() {
		return configuration;
	}
	public void setConfiguration(List<ScopedConfiguration> configuration) {
		this.configuration = configuration;
	}
}
