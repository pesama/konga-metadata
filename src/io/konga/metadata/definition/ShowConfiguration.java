package io.konga.metadata.definition;

import java.util.List;

import io.konga.metadata.annotations.Createable;
import io.konga.metadata.annotations.Deleteable;
import io.konga.metadata.annotations.Editable;
import io.konga.metadata.annotations.Entity;
import io.konga.metadata.annotations.EntityId;
import io.konga.metadata.annotations.EntityKey;
import io.konga.metadata.annotations.EntityLabel;
import io.konga.metadata.annotations.Field;
import io.konga.metadata.annotations.FormStyle;
import io.konga.metadata.annotations.Label;
import io.konga.metadata.annotations.Multiplicity;
import io.konga.metadata.annotations.Required;
import io.konga.metadata.annotations.Searchable;
import io.konga.metadata.annotations.ShowInResults;
import io.konga.metadata.annotations.ShowInUpdate;
import io.konga.metadata.definition.enumerations.FormStyles;
import io.konga.metadata.definition.enumerations.Multiplicities;

@Entity("show-configuration")
@Label("Show configuration")
@Searchable
@Createable
@Editable
@Deleteable
@FormStyle(update=FormStyles.HORIZONTAL)
public class ShowConfiguration {
	
	@Field
	@EntityId
	@EntityKey
	private Integer id;
	
	@Field
	@EntityLabel
	@Label("Permission")
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Required
	@Editable
	private String value;
	
	@Field
	@Label("Fields")
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Required
	@Editable
	@Multiplicity(Multiplicities.MANY)
	private List<String> fields;
	
	private List<ConfigurationParam> configuration;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public List<ConfigurationParam> getConfiguration() {
		return configuration;
	}

	public void setConfiguration(List<ConfigurationParam> configuration) {
		this.configuration = configuration;
	}
}
