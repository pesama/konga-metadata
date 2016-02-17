package io.konga.metadata.definition;

import java.util.ArrayList;

import io.konga.metadata.definition.enumerations.FormModes;

public class ScopedConfiguration extends ArrayList<ConfigurationParam> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6974918681276633486L;
	
	private FormModes scope;

	public FormModes getScope() {
		return scope;
	}

	public void setScope(FormModes scope) {
		this.scope = scope;
	}
}
