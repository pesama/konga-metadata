package org.kongaproject.metadata.definition;

import org.kongaproject.metadata.annotations.Action;
import org.kongaproject.metadata.annotations.ApiPath;
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
import org.kongaproject.metadata.annotations.MaxLength;
import org.kongaproject.metadata.annotations.OverrideDefaults;
import org.kongaproject.metadata.annotations.Raw;
import org.kongaproject.metadata.annotations.Required;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.annotations.ShowInResults;
import org.kongaproject.metadata.annotations.ShowInUpdate;
import org.kongaproject.metadata.annotations.Type;
import org.kongaproject.metadata.definition.enumerations.DataTypes;
import org.kongaproject.metadata.definition.enumerations.FormModes;
import org.kongaproject.metadata.definition.enumerations.FormStyles;

@Entity("konga-action")
@Label("Action")
@ApiPath("actions")
@Searchable
@Createable
@Editable
@Deleteable
@FormStyle(update=FormStyles.HORIZONTAL)
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
