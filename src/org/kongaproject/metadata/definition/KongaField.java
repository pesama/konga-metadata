package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.AccessMode;
import org.kongaproject.metadata.definition.enumerations.Multiplicity;

public class KongaField {
	
	/**
	 * The name of the field
	 */
	private String name;
	
	/**
	 * Label of the field (placeholder)
	 */
	private String label;
	
	/**
	 * Short Label of the field (placeholder)
	 */
	private String shortLabel;
	
	/**
	 * Data type of the field
	 */
	private DataType type;
	
	/**
	 * Access configuration
	 */
	private AccessMode access;
	
	/**
	 * Whether the field is the unique DB key
	 */
	private Boolean isId;
	
	/**
	 * Whether the field is the human-readable key
	 */
	private Boolean isKey;
	
	/**
	 * Whether the field is the human-readable name of the entity
	 */
	private Boolean isLabel;
	
	/**
	 * Whether the field defines a parent for the entity (for hiearchized elements)
	 */
	private Boolean isParent;
	
	/**
	 * Configuration for quick searching by that field
	 */
	private ShowConfiguration quickSearch;
	
	/**
	 * Configuration for search rendering
	 */
	private ShowConfiguration searchable;
	
	/**
	 * Configuration for update permissions
	 */
	private ShowConfiguration editable;
	
	/**
	 * Configuration for results rendering
	 */
	private ShowConfiguration showInResults;
	
	/**
	 * Configuration for update rendering
	 */
	private ShowConfiguration showInUpdate;
	
	/**
	 * Configuration for details rendering
	 */
	private ShowConfiguration showInDetails;
	
	/**
	 * Multiplicity of the field within the entity
	 */
	private Multiplicity multiplicity;
	
	/**
	 * Categories for the field
	 */
	private List<String> categories;
	
	/**
	 * Overrides the name of the field for searching and filtering
	 */
	private List<String> apiName;
	
	/**
	 * Field type configuration (for rendering)
	 */
	private FieldType fieldType;
	
	/**
	 * Default value
	 * TODO Perform the cast here and convert this class into generic
	 */
	private String defaults;
	
	/**
	 * Search configuration for the field
	 */
	private SearchConf searchConf;
	
	/**
	 * Whether the value of the field must be unique
	 */
	private boolean unique;
	
	/**
	 * Security configuration
	 */
	private Security security;
	
	/**
	 * Data validation configuration
	 */
	private Validation validation;
	
	/**
	 * Available triggers for the field
	 */
	private List<Trigger> triggers;
	
	/**
	 * Order of the field
	 */
	private Priority priority;
	
	/**
	 * Set for the field (placeholder)
	 */
	private String fieldSet;
	
	/**
	 * Entity actions
	 */
	private List<KongaAction> actions;
	
	/**
	 * List of overriden native actions
	 */
	private List<KongaAction> overrideDefaults;
	
	/**
	 * Defines the owner of the field (for nested and inherited properties)
	 */
	private String owner;
	
	/**
	 * Defines whether the field is sortable (for tables)
	 */
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

	public DataType getType() {
		return type;
	}

	public void setType(DataType type) {
		this.type = type;
	}

	public AccessMode getAccess() {
		return access;
	}

	public void setAccess(AccessMode access) {
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

	public Multiplicity getMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity(Multiplicity multiplicity) {
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

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
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

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
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
}
