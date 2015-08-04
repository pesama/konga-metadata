package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.AccessMode;
import org.kongaproject.metadata.definition.enumerations.FormStyle;
import org.kongaproject.metadata.definition.enumerations.FormType;
import org.kongaproject.metadata.definition.enumerations.Stereotype;

public class KongaEntity {
	
	private Class<?> classFor;
	
	/**
	 * Name of the entity
	 */
	private String name;
	
	/**
	 * Superclass of the entity
	 */
	private String superClass;
	
	/**
	 * Label for the entity (placeholder name)
	 */
	private String label;
	
	/**
	 * Short Label for the entity (placeholder name)
	 */
	private String shortLabel;
	
	/**
	 * Access configuration 
	 */
	private AccessMode access;
	
	/**
	 * Stereotypes for the entity
	 */
	private List<Stereotype> stereotypes;
	
	/**
	 * Permission needed for searching the entity
	 */
	private String searchable;
	
	/**
	 * Permission needed for creating entities
	 */
	private String createable;
	
	/**
	 * Permission needed for updating the entity
	 */
	private String editable;
	
	/**
	 * Permission needed for deleting 
	 */
	private String deleteable;
	
	/**
	 * Form type for searching the entity
	 */
	private FormType searchType;
	
	/**
	 * Form style for search panels
	 */
	private FormStyle searchStyle;
	
	/**
	 * Form type for the results pane
	 */
	private FormType resultsType;
	
	/**
	 * Form style for results panels
	 */
	private FormStyle resultsStyle;
	
	/**
	 * Form type for the details pane
	 */
	private FormType detailsType;
	
	/**
	 * Form style for details panels
	 */
	private FormStyle detailsStyle;
	
	/**
	 * Form type for the update pane
	 */
	private FormType updateType;
	
	/**
	 * Form style for update panels
	 */
	private FormStyle updateStyle;
	
	/**
	 * Template for the update form
	 * TODO Change to allow customization on all forms
	 */
	private String template;
	
	/**
	 * Overrides the name of the entity for api requests
	 */
	private String apiName;
	
	/**
	 * Overrides the standard api path for requests
	 */
	private String apiPath;
	
	/**
	 * Set of categories of the entity
	 */
	private List<String> categories;
	
	/**
	 * Security configuration for the entity
	 */
	private Security security;
	
	/**
	 * Entity fields
	 */
	private List<KongaField> fields;
	
	/**
	 * List of field sets for the entity
	 */
	private List<FieldSet> fieldSets;
	
	/**
	 * Entity actions
	 */
	private List<KongaAction> actions;
	
	/**
	 * Override defaults
	 */
	private List<KongaAction> overrideDefaults;
	
	/**
	 * Entity configuration
	 */
	private List<ConfigurationParam> configuration;
	
	/**
	 * Defines whether the entity could save favorite filters
	 */
	private Boolean favoriteable;
	
	/**
	 * Overrides native action on clicking a result row
	 */
	private List<KongaAction> resultClick;
	
	public Class<?> getClassFor() {
		return classFor;
	}
	public void setClassFor(Class<?> classFor) {
		this.classFor = classFor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuperClass() {
		return superClass;
	}
	public void setSuperClass(String superClass) {
		this.superClass = superClass;
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
	public AccessMode getAccess() {
		return access;
	}
	public void setAccess(AccessMode access) {
		this.access = access;
	}
	public List<Stereotype> getStereotypes() {
		return stereotypes;
	}
	public void setStereotypes(List<Stereotype> stereotypes) {
		this.stereotypes = stereotypes;
	}
	public String getSearchable() {
		return searchable;
	}
	public void setSearchable(String searchable) {
		this.searchable = searchable;
	}
	public String getCreateable() {
		return createable;
	}
	public void setCreateable(String createable) {
		this.createable = createable;
	}
	public String getEditable() {
		return editable;
	}
	public void setEditable(String editable) {
		this.editable = editable;
	}
	public String getDeleteable() {
		return deleteable;
	}
	public void setDeleteable(String deleteable) {
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
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
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
	public List<KongaField> getFields() {
		return fields;
	}
	public void setFields(List<KongaField> fields) {
		this.fields = fields;
	}
	public List<KongaAction> getActions() {
		return actions;
	}
	public void setActions(List<KongaAction> actions) {
		this.actions = actions;
	}
	public List<KongaAction> getResultClick() {
		return resultClick;
	}
	public void setResultClick(List<KongaAction> resultClick) {
		this.resultClick = resultClick;
	}
	public List<FieldSet> getFieldSets() {
		return fieldSets;
	}
	public void setFieldSets(List<FieldSet> fieldSets) {
		this.fieldSets = fieldSets;
	}
	public FormStyle getSearchStyle() {
		return searchStyle;
	}
	public void setSearchStyle(FormStyle searchStyle) {
		this.searchStyle = searchStyle;
	}
	public FormStyle getResultsStyle() {
		return resultsStyle;
	}
	public void setResultsStyle(FormStyle resultsStyle) {
		this.resultsStyle = resultsStyle;
	}
	public FormStyle getDetailsStyle() {
		return detailsStyle;
	}
	public void setDetailsStyle(FormStyle detailsStyle) {
		this.detailsStyle = detailsStyle;
	}
	public FormStyle getUpdateStyle() {
		return updateStyle;
	}
	public void setUpdateStyle(FormStyle updateStyle) {
		this.updateStyle = updateStyle;
	}
	public List<ConfigurationParam> getConfiguration() {
		return configuration;
	}
	public void setConfiguration(List<ConfigurationParam> configuration) {
		this.configuration = configuration;
	}
	public List<KongaAction> getOverrideDefaults() {
		return overrideDefaults;
	}
	public void setOverrideDefaults(List<KongaAction> overrideDefaults) {
		this.overrideDefaults = overrideDefaults;
	}
	public Boolean getFavoriteable() {
		return favoriteable;
	}
	public void setFavoriteable(Boolean favoriteable) {
		this.favoriteable = favoriteable;
	}
}
