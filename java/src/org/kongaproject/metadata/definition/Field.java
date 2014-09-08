package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.Access;
import org.kongaproject.metadata.definition.enumerations.DataType;
import org.kongaproject.metadata.definition.enumerations.FieldType;
import org.kongaproject.metadata.definition.enumerations.Multiplicity;

public class Field {
	private String name;
	private String label;
	private DataType type;
	private Access access;
	private boolean isId;
	private boolean isKey;
	private boolean isLabel;
	private boolean searchable;
	private boolean editable;
	private boolean showInResults;
	private boolean showInUpdate;
	private boolean showInDetails;
	private Multiplicity multiplicity;
	private List<String> categories;
	private String apiName;
	private FieldType fieldType;
	private String defaults;
	private SearchConf searchConf;
	private boolean unique;
	private Security security;
	private Validation validation;
	private List<Trigger> triggers;
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
	public Access getAccess() {
		return access;
	}
	public void setAccess(Access access) {
		this.access = access;
	}
	public boolean isId() {
		return isId;
	}
	public void setId(boolean isId) {
		this.isId = isId;
	}
	public boolean isKey() {
		return isKey;
	}
	public void setKey(boolean isKey) {
		this.isKey = isKey;
	}
	public boolean isLabel() {
		return isLabel;
	}
	public void setLabel(boolean isLabel) {
		this.isLabel = isLabel;
	}
	public boolean isSearchable() {
		return searchable;
	}
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public boolean isShowInResults() {
		return showInResults;
	}
	public void setShowInResults(boolean showInResults) {
		this.showInResults = showInResults;
	}
	public boolean isShowInUpdate() {
		return showInUpdate;
	}
	public void setShowInUpdate(boolean showInUpdate) {
		this.showInUpdate = showInUpdate;
	}
	public boolean isShowInDetails() {
		return showInDetails;
	}
	public void setShowInDetails(boolean showInDetails) {
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
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
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
