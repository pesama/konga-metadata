package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.AccessMode;
import org.kongaproject.metadata.definition.FieldType;
import org.kongaproject.metadata.definition.enumerations.Multiplicity;

public class Field {
	private String name;
	private String label;
	private DataType type;
	private AccessMode access;
	private boolean isId;
	private boolean isKey;
	private boolean isLabel;
	private ShowConfiguration searchable;
	private ShowConfiguration editable;
	private ShowConfiguration showInResults;
	private ShowConfiguration showInUpdate;
	private ShowConfiguration showInDetails;
	private Multiplicity multiplicity;
	private List<String> categories;
	private List<String> apiName;
	private FieldType fieldType;
	private String defaults;
	private SearchConf searchConf;
	private boolean unique;
	private Security security;
	private Validation validation;
	private List<Trigger> triggers;
	private int priority;
	
	private String owner;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
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
	public boolean getIsId() {
		return isId;
	}
	public void setIsId(boolean isId) {
		this.isId = isId;
	}
	public boolean getIsKey() {
		return isKey;
	}
	public void setIsKey(boolean isKey) {
		this.isKey = isKey;
	}
	public boolean getIsLabel() {
		return isLabel;
	}
	public void setIsLabel(boolean isLabel) {
		this.isLabel = isLabel;
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
	
}
