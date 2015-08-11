package org.kongaproject.metadata.definition;

import org.kongaproject.metadata.definition.enumerations.FormModes;

public class KongaAction {
	
	/**
	 * Name of the action
	 */
	private String name;
	
	/**
	 * Placeholder to the action label
	 */
	private String label;
	
	/**
	 * Icon for placing near the label
	 */
	private String icon;
	
	/**
	 * Where the action is engaged
	 */
	private FormModes scope;
	
	/**
	 * If overriding a native action, name of the action to set-up
	 */
	private String overrides;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public FormModes getScope() {
		return scope;
	}
	public void setScope(FormModes scope) {
		this.scope = scope;
	}
	public String getOverrides() {
		return overrides;
	}
	public void setOverrides(String overrides) {
		this.overrides = overrides;
	}
}
