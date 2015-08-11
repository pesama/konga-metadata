package org.kongaproject.metadata.definition;

import java.util.List;

public class FieldType {
	private org.kongaproject.metadata.definition.enumerations.FieldTypes search;
	private org.kongaproject.metadata.definition.enumerations.FieldTypes results;
	private org.kongaproject.metadata.definition.enumerations.FieldTypes details;
	private org.kongaproject.metadata.definition.enumerations.FieldTypes update;
	
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
