package org.kongaproject.metadata.definition;

import java.util.List;

public class FieldType {
	private org.kongaproject.metadata.definition.enumerations.FieldType search;
	private org.kongaproject.metadata.definition.enumerations.FieldType results;
	private org.kongaproject.metadata.definition.enumerations.FieldType details;
	private org.kongaproject.metadata.definition.enumerations.FieldType update;
	
	private List<ScopedConfiguration> configuration;
	
	public org.kongaproject.metadata.definition.enumerations.FieldType getSearch() {
		return search;
	}
	public void setSearch(
			org.kongaproject.metadata.definition.enumerations.FieldType search) {
		this.search = search;
	}
	public org.kongaproject.metadata.definition.enumerations.FieldType getResults() {
		return results;
	}
	public void setResults(
			org.kongaproject.metadata.definition.enumerations.FieldType results) {
		this.results = results;
	}
	public org.kongaproject.metadata.definition.enumerations.FieldType getDetails() {
		return details;
	}
	public void setDetails(
			org.kongaproject.metadata.definition.enumerations.FieldType details) {
		this.details = details;
	}
	public org.kongaproject.metadata.definition.enumerations.FieldType getUpdate() {
		return update;
	}
	public void setUpdate(
			org.kongaproject.metadata.definition.enumerations.FieldType update) {
		this.update = update;
	}
	public List<ScopedConfiguration> getConfiguration() {
		return configuration;
	}
	public void setConfiguration(List<ScopedConfiguration> configuration) {
		this.configuration = configuration;
	}
}
