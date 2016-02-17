package io.konga.metadata.definition;

import java.util.List;

import io.konga.metadata.definition.enumerations.AccessModes;
import io.konga.metadata.definition.enumerations.DataTypes;
import io.konga.metadata.definition.enumerations.FieldTypes;
import io.konga.metadata.definition.enumerations.FormStyles;
import io.konga.metadata.annotations.Action;
import io.konga.metadata.annotations.ApiPath;
import io.konga.metadata.annotations.Categories;
import io.konga.metadata.annotations.Createable;
import io.konga.metadata.annotations.Defaults;
import io.konga.metadata.annotations.Deleteable;
import io.konga.metadata.annotations.Editable;
import io.konga.metadata.annotations.Entity;
import io.konga.metadata.annotations.EntityId;
import io.konga.metadata.annotations.EntityKey;
import io.konga.metadata.annotations.EntityLabel;
import io.konga.metadata.annotations.Field;
import io.konga.metadata.annotations.FormStyle;
import io.konga.metadata.annotations.FormType;
import io.konga.metadata.annotations.Label;
import io.konga.metadata.annotations.MaxLength;
import io.konga.metadata.annotations.Multiplicity;
import io.konga.metadata.annotations.OverrideDefaults;
import io.konga.metadata.annotations.Raw;
import io.konga.metadata.annotations.Required;
import io.konga.metadata.annotations.Searchable;
import io.konga.metadata.annotations.ShowInResults;
import io.konga.metadata.annotations.ShowInUpdate;
import io.konga.metadata.annotations.Type;
import io.konga.metadata.definition.enumerations.FormTypes;
import io.konga.metadata.definition.enumerations.Multiplicities;

@Entity("konga-field")
@Label("Field")
@ApiPath("fields")
@Searchable
@Createable
@Editable
@Deleteable
@FormType(update=FormTypes.TABBED)
@FormStyle(update= FormStyles.HORIZONTAL)
@OverrideDefaults(
	@Action(overrides="save", name="inner-save")
)
public class KongaField {
	
	@Field
	@EntityId
	@Searchable("SUPER_ADMIN")
	@ShowInResults("SUPER_ADMIN")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	private Integer id;
	
	/**
	 * The name of the field
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
	@Categories("Definition")
	private String name;
	
	/**
	 * Label of the field (placeholder)
	 */
	@Field
	@Label("Label")
	@EntityLabel
	@ShowInResults
	@ShowInUpdate
	@Editable
	@Required
	@Categories("Definition")
	private String label;
	
	/**
	 * Short Label of the field (placeholder)
	 */
	@Field
	@Label("Short label")
	@ShowInUpdate
	@Editable
	@Categories("Definition")
	private String shortLabel;
	
	/**
	 * Hint to the user
	 */
	@Field
	@Label("Hint")
	@ShowInUpdate
	@Editable
	@Categories("Definition")
	private String hint;
	
	/**
	 * Data type of the field
	 */
	@Field
	@Label("Data Type")
	@ShowInUpdate
	@Editable
	@Categories("Typology")
	@Type(value=DataTypes.COMPLEX, complexType="data-type")
	@Required
	@io.konga.metadata.annotations.FieldType(FieldTypes.LINK)
	@OverrideDefaults(
		@Action(overrides="open-link", name="set-modal-entity")
	)
	private DataType type;
	
	/**
	 * Access configuration
	 */
	private AccessModes access;
	
	/**
	 * Whether the field is the unique DB key
	 */
	@Field
	@Label("Entity ID")
	@ShowInResults("SUPER_ADMIN")
	@ShowInUpdate
	@Editable
	@io.konga.metadata.annotations.FieldType(FieldTypes.SWITCH)
	@Categories("Identification")
	private Boolean isId;
	
	/**
	 * Whether the field is the human-readable key
	 */
	@Field
	@Label("Entity key")
	@ShowInResults("SUPER_ADMIN")
	@ShowInUpdate
	@Editable
	@io.konga.metadata.annotations.FieldType(FieldTypes.SWITCH)
	@Categories("Identification")
	private Boolean isKey;
	
	/**
	 * Whether the field is the human-readable name of the entity
	 */
	@Field
	@Label("Entity label")
	@ShowInResults("SUPER_ADMIN")
	@ShowInUpdate
	@Editable
	@io.konga.metadata.annotations.FieldType(FieldTypes.SWITCH)
	@Categories("Identification")
	private Boolean isLabel;
	
	// TODO Go!
	private Linked linked;
	
	/**
	 * Whether the field defines a parent for the entity (for hiearchized elements)
	 */
	private Boolean isParent;
	
	/**
	 * Configuration for quick searching by that field
	 */
//	@Field
//	@Label("Quick search configuration")
//	@ShowInUpdate
//	@Editable
//	@Type(value=DataTypes.COMPLEX, complexType="show-configuration")
//	@Categories("Operations")
	private ShowConfiguration quickSearch;
	
	/**
	 * Configuration for search rendering
	 */
//	@Field
//	@Label("Search configuration")
//	@ShowInUpdate
//	@Editable
//	@Type(value=DataTypes.COMPLEX, complexType="show-configuration")
//	@Categories("Operations")
	private ShowConfiguration searchable;
	
	/**
	 * Configuration for update permissions
	 */
//	@Field
//	@Label("Edit configuration")
//	@ShowInUpdate
//	@Editable
//	@Type(value=DataTypes.COMPLEX, complexType="show-configuration")
//	@Categories("Operations")
	private ShowConfiguration editable;
	
	/**
	 * Configuration for results rendering
	 */
//	@Field
//	@Label("Results show configuration")
//	@ShowInUpdate
//	@Editable
//	@Type(value=DataTypes.COMPLEX, complexType="show-configuration")
//	@Categories("Operations")
	private ShowConfiguration showInResults;
	
	/**
	 * Configuration for update rendering
	 */
//	@Field
//	@Label("Update show configuration")
//	@ShowInUpdate
//	@Editable
//	@Type(value=DataTypes.COMPLEX, complexType="show-configuration")
//	@Categories("Operations")
	private ShowConfiguration showInUpdate;
	
	/**
	 * Configuration for details rendering
	 */
//	@Field
//	@Label("Details show configuration")
//	@ShowInUpdate
//	@Editable
//	@Type(value=DataTypes.COMPLEX, complexType="show-configuration")
//	@Categories("Operations")
	private ShowConfiguration showInDetails;
	
	/**
	 * Multiplicity of the field within the entity
	 */
	@Field
	@Label("Multiplicity")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="ONE", value="One to One"),
		@Raw(key="MANY", value="One to Many")
	})
	@io.konga.metadata.annotations.FieldType(update=FieldTypes.COMBOBOX)
	@Categories("Typology")
	@Defaults("ONE")
	private Multiplicities multiplicity;
	
	/**
	 * Categories for the field
	 */
	@Field
	@Label("Categories")
	@ShowInUpdate
	@Editable
	@Multiplicity(Multiplicities.MANY)
	@Categories("Typology")
	private List<String> categories;
	
	/**
	 * Overrides the name of the field for searching and filtering
	 */
	private List<String> apiName;
	
	/**
	 * Field type configuration (for rendering)
	 */
	@Field
	@Label("Appearance")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.COMPLEX, complexType="field-type")
	@Categories("Typology")
	@io.konga.metadata.annotations.FieldType(FieldTypes.LINK)
	@OverrideDefaults(
		@Action(overrides="open-link", name="set-modal-entity")
	)
	private io.konga.metadata.definition.FieldType fieldType;
	
	/**
	 * Default value
	 * TODO Perform the cast here and convert this class into generic
	 */
	@Field
	@Label("Default value")
	@ShowInUpdate
	@Editable
	@Categories("Typology")
	private String defaults;
	
	/**
	 * Search configuration for the field
	 */
//	@Field
//	@Label("Search configuration")
//	@ShowInUpdate
//	@Editable
//	@Type(value=DataTypes.COMPLEX, complexType="search-configuration")
//	@FieldType(update=FieldTypes.PLAIN)
//	@Categories("Configuration")
	private SearchConf searchConf;
	
	/**
	 * Whether the value of the field must be unique
	 */
	@Field
	@Label("Unique value")
	@ShowInUpdate
	@Editable
	@io.konga.metadata.annotations.FieldType(FieldTypes.SWITCH)
	@Categories("Validation")
	private Boolean unique;
	
	/**
	 * Security configuration
	 */
	private Security security;
	
	/**
	 * Data validation configuration
	 */
	@Field
	@Label("Validation rules")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.COMPLEX, complexType="validation")
	@io.konga.metadata.annotations.FieldType(FieldTypes.LINK)
	@Categories("Validation")
	@OverrideDefaults(
		@Action(overrides="open-link", name="set-modal-entity")
	)
	private Validation validation;
	
	/**
	 * Available triggers for the field
	 */
//	@Field
//	@Label("Triggers")
//	@ShowInUpdate
//	@Editable
////	@FieldType(update=FieldTypes.PICK_LIST)
//	@Categories("Triggers")
	private List<Trigger> triggers;
	
	/**
	 * Order of the field
	 */
//	@Field
//	@Label("Priority")
//	@ShowInUpdate
//	@Editable
////	@FieldType(update=FieldTypes.BOOLEAN)
//	@Categories("Identification")
	private Priority priority;
	
	/**
	 * Set for the field (placeholder)
	 */
//	@Field
//	@Label("Field set")
//	@ShowInUpdate
//	@Editable
////	@FieldType(update=FieldTypes.BOOLEAN)
//	@Categories("Typology")
	private String fieldSet;
	
	/**
	 * Entity actions
	 */
	@Field
	@Label("Actions")
	@ShowInUpdate(fields={"name", "icon", "scope"})
	@Editable
	@Type(value=DataTypes.COMPLEX, complexType="konga-action")
	@io.konga.metadata.annotations.FieldType(update=FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	@Categories("Customization")
	private List<KongaAction> actions;
	
	/**
	 * List of overriden native actions
	 */
	@Field
	@Label("Override defaults")
	@ShowInUpdate(fields={"overrides", "name", "icon"})
	@Editable
	@Type(value=DataTypes.COMPLEX, complexType="konga-action")
	@io.konga.metadata.annotations.FieldType(update=FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	@Categories("Customization")
	private List<KongaAction> overrideDefaults;
	
	/**
	 * Defines the owner of the field (for nested and inherited properties)
	 */
	private String owner;
	
	/**
	 * Defines whether the field is sortable (for tables)
	 */
	@Field
	@Label("Sortable")
	@ShowInUpdate
	@Editable
	@io.konga.metadata.annotations.FieldType(update=FieldTypes.BOOLEAN)
	@Multiplicity(Multiplicities.MANY)
	@Categories("Configuration")
	private Boolean sortable;

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
	
	public String getShortLabel() {
		return shortLabel;
	}

	public void setShortLabel(String shortLabel) {
		this.shortLabel = shortLabel;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public DataType getType() {
		return type;
	}

	public void setType(DataType type) {
		this.type = type;
	}

	public AccessModes getAccess() {
		return access;
	}

	public void setAccess(AccessModes access) {
		this.access = access;
	}

	public Boolean getIsId() {
		return isId;
	}

	public void setIsId(Boolean isId) {
		this.isId = isId;
	}

	public Boolean getIsKey() {
		return isKey;
	}

	public void setIsKey(Boolean isKey) {
		this.isKey = isKey;
	}

	public Boolean getIsLabel() {
		return isLabel;
	}

	public void setIsLabel(Boolean isLabel) {
		this.isLabel = isLabel;
	}
	
	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public ShowConfiguration getSearchable() {
		return searchable;
	}

	public void setSearchable(ShowConfiguration searchable) {
		this.searchable = searchable;
	}

	public ShowConfiguration getEditable() {
		return editable;
	}

	public void setEditable(ShowConfiguration editable) {
		this.editable = editable;
	}

	public ShowConfiguration getShowInResults() {
		return showInResults;
	}

	public void setShowInResults(ShowConfiguration showInResults) {
		this.showInResults = showInResults;
	}

	public ShowConfiguration getShowInUpdate() {
		return showInUpdate;
	}

	public void setShowInUpdate(ShowConfiguration showInUpdate) {
		this.showInUpdate = showInUpdate;
	}

	public ShowConfiguration getShowInDetails() {
		return showInDetails;
	}

	public void setShowInDetails(ShowConfiguration showInDetails) {
		this.showInDetails = showInDetails;
	}

	public Multiplicities getMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity(Multiplicities multiplicity) {
		this.multiplicity = multiplicity;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getApiName() {
		return apiName;
	}

	public void setApiName(List<String> apiName) {
		this.apiName = apiName;
	}

	public io.konga.metadata.definition.FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(io.konga.metadata.definition.FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public String getDefaults() {
		return defaults;
	}

	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}

	public SearchConf getSearchConf() {
		return searchConf;
	}

	public void setSearchConf(SearchConf searchConf) {
		this.searchConf = searchConf;
	}

	public Boolean isUnique() {
		return unique;
	}

	public void setUnique(Boolean unique) {
		this.unique = unique;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public Validation getValidation() {
		return validation;
	}

	public void setValidation(Validation validation) {
		this.validation = validation;
	}

	public List<Trigger> getTriggers() {
		return triggers;
	}

	public void setTriggers(List<Trigger> triggers) {
		this.triggers = triggers;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getFieldSet() {
		return fieldSet;
	}

	public void setFieldSet(String fieldSet) {
		this.fieldSet = fieldSet;
	}

	public ShowConfiguration getQuickSearch() {
		return quickSearch;
	}

	public void setQuickSearch(ShowConfiguration quickSearch) {
		this.quickSearch = quickSearch;
	}

	public List<KongaAction> getActions() {
		return actions;
	}

	public void setActions(List<KongaAction> actions) {
		this.actions = actions;
	}

	public List<KongaAction> getOverrideDefaults() {
		return overrideDefaults;
	}

	public void setOverrideDefaults(List<KongaAction> overrideDefaults) {
		this.overrideDefaults = overrideDefaults;
	}

	public Boolean getSortable() {
		return sortable;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

	public Linked getLinked() {
		return linked;
	}

	public void setLinked(Linked linked) {
		this.linked = linked;
	}
}
