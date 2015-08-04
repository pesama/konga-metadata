package org.kongaproject.metadata.definition;

import java.util.ArrayList;

import org.kongaproject.metadata.definition.enumerations.FormMode;

public class ScopedConfiguration extends ArrayList<ConfigurationParam> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6974918681276633486L;
	
	private FormMode scope;

	public FormMode getScope() {
		return scope;
	}

	public void setScope(FormMode scope) {
		this.scope = scope;
	}
}
