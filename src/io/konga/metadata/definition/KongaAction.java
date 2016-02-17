package io.konga.metadata.definition;

import io.konga.metadata.definition.enumerations.FormModes;
import io.konga.metadata.definition.enumerations.FormStyles;
import io.konga.metadata.annotations.Action;
import io.konga.metadata.annotations.ApiPath;
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
import io.konga.metadata.annotations.MaxLength;
import io.konga.metadata.annotations.OverrideDefaults;
import io.konga.metadata.annotations.Raw;
import io.konga.metadata.annotations.Required;
import io.konga.metadata.annotations.Searchable;
import io.konga.metadata.annotations.ShowInResults;
import io.konga.metadata.annotations.ShowInUpdate;
import io.konga.metadata.annotations.Type;
import io.konga.metadata.definition.enumerations.DataTypes;

@Entity("konga-action")
@Label("Action")
@ApiPath("actions")
@Searchable
@Createable
@Editable
@Deleteable
@FormStyle(update= FormStyles.HORIZONTAL)
@OverrideDefaults(
	@Action(overrides="save", name="save-action-to-item")
)
public class KongaAction {
	
	@Field
	@EntityId
	@Searchable("SUPER_ADMIN")
	@ShowInResults("SUPER_ADMIN")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	private Integer id;
	
	/**
	 * The name of the action
	 */
	@Field
	@Label("Name")
	@Type(DataTypes.STRING)
	@EntityKey
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Editable
	@Required
	@MaxLength(40)
	private String name;
	
	/**
	 * Placeholder to the action label
	 */
	@Field
	@Label("Label")
	@Type(DataTypes.STRING)
	@EntityLabel
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Editable
	@Required
	@MaxLength(40)
	private String label;
	
	/**
	 * Icon for placing near the label
	 */
	@Field
	@Label("Icon")
	@Type(DataTypes.STRING)
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Editable
	@Required
	private String icon;
	
	/**
	 * Where the action is engaged
	 */
	@Field
	@Label("Form mode")
	@Type(value=DataTypes.STRING, list={
		@Raw(key="SEARCH", value="Search"),
		@Raw(key="RESULTS", value="Results"),
		@Raw(key="DETAILS", value="Details"),
		@Raw(key="UPDATE", value="Update"),
		@Raw(key="ALL", value="All")
	})
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Editable
	@Required
	private FormModes scope;
	
	/**
	 * If overriding a native action, name of the action to set-up
	 */
	@Field
	@Label("Action to override")
	@Type(DataTypes.STRING)
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Editable
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
