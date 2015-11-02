package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.annotations.Createable;
import org.kongaproject.metadata.annotations.Deleteable;
import org.kongaproject.metadata.annotations.Editable;
import org.kongaproject.metadata.annotations.Entity;
import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.annotations.EntityKey;
import org.kongaproject.metadata.annotations.EntityLabel;
import org.kongaproject.metadata.annotations.Field;
import org.kongaproject.metadata.annotations.FormStyle;
import org.kongaproject.metadata.annotations.Label;
import org.kongaproject.metadata.annotations.Multiplicity;
import org.kongaproject.metadata.annotations.Required;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.annotations.ShowInResults;
import org.kongaproject.metadata.annotations.ShowInUpdate;
import org.kongaproject.metadata.definition.enumerations.FormStyles;
import org.kongaproject.metadata.definition.enumerations.Multiplicities;

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
