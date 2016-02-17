package io.konga.metadata.definition;

/**
 * Defines a field set that configures a group of fields within an entity to behave differently
 * @author psanchezmarg
 *
 */
public class FieldSet {

	/**
	 * Name of the field set (placeholder)
	 */
	private String name;
	
	/**
	 * Configuration of the field set
	 */
	private FieldSetConfiguration configuration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FieldSetConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(FieldSetConfiguration configuration) {
		this.configuration = configuration;
	}
}
