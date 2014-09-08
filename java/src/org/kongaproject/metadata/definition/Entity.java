package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.Access;
import org.kongaproject.metadata.definition.enumerations.FormType;
import org.kongaproject.metadata.definition.enumerations.Stereotype;

public class Entity {
	
	private String name;
	private String superClass;
	private String label;
	private Access access;
	private List<Stereotype> stereotypes;
	private boolean searchable;
	private boolean createable;
	private boolean editable;
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	private boolean deleteable;
	private FormType searchType;
	private FormType resultsType;
	private FormType detailsType;
	private FormType updateType;
	private String apiName;
	private String apiPath;
	private List<String> categories;
	private Security security;
	private List<Field> fields;
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
	public Access getAccess() {
		return access;
	}
	public void setAccess(Access access) {
		this.access = access;
	}
	public List<Stereotype> getStereotypes() {
		return stereotypes;
	}
	public void setStereotypes(List<Stereotype> stereotypes) {
		this.stereotypes = stereotypes;
	}
	public boolean isSearchable() {
		return searchable;
	}
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}
	public boolean isCreateable() {
		return createable;
	}
	public void setCreateable(boolean createable) {
		this.createable = createable;
	}
	public boolean isDeleteable() {
		return deleteable;
	}
	public void setDeleteable(boolean deleteable) {
		this.deleteable = deleteable;
	}
	public FormType getSearchType() {
		return searchType;
	}
	public void setSearchType(FormType searchType) {
		this.searchType = searchType;
	}
	public FormType getResultsType() {
		return resultsType;
	}
	public void setResultsType(FormType resultsType) {
		this.resultsType = resultsType;
	}
	public FormType getDetailsType() {
		return detailsType;
	}
	public void setDetailsType(FormType detailsType) {
		this.detailsType = detailsType;
	}
	public FormType getUpdateType() {
		return updateType;
	}
	public void setUpdateType(FormType updateType) {
		this.updateType = updateType;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getApiPath() {
		return apiPath;
	}
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public Security getSecurity() {
		return security;
	}
	public void setSecurity(Security security) {
		this.security = security;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public String getSuperClass() {
		return superClass;
	}
	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}
	
	
}
