package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.AccessModes;
import org.kongaproject.metadata.definition.enumerations.FormStyles;
import org.kongaproject.metadata.definition.enumerations.FormTypes;
import org.kongaproject.metadata.definition.enumerations.Stereotypes;

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
	private AccessModes access;
	
	/**
	 * Stereotypes for the entity
	 */
	private List<Stereotypes> stereotypes;
	
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
	private FormTypes searchType;
	
	/**
	 * Form style for search panels
	 */
	private FormStyles searchStyle;
	
	/**
	 * Form type for the results pane
	 */
	private FormTypes resultsType;
	
	/**
	 * Form style for results panels
	 */
	private FormStyles resultsStyle;
	
	/**
	 * Form type for the details pane
	 */
	private FormTypes detailsType;
	
	/**
	 * Form style for details panels
	 */
	private FormStyles detailsStyle;
	
	/**
	 * Form type for the update pane
	 */
	private FormTypes updateType;
	
	/**
	 * Form style for update panels
	 */
	private FormStyles updateStyle;
	
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
	public AccessModes getAccess() {
		return access;
	}
	public void setAccess(AccessModes access) {
		this.access = access;
	}
	public List<Stereotypes> getStereotypes() {
		return stereotypes;
	}
	public void setStereotypes(List<Stereotypes> stereotypes) {
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
	public FormTypes getSearchType() {
		return searchType;
	}
	public void setSearchType(FormTypes searchType) {
		this.searchType = searchType;
	}
	public FormTypes getResultsType() {
		return resultsType;
	}
	public void setResultsType(FormTypes resultsType) {
		this.resultsType = resultsType;
	}
	public FormTypes getDetailsType() {
		return detailsType;
	}
	public void setDetailsType(FormTypes detailsType) {
		this.detailsType = detailsType;
	}
	public FormTypes getUpdateType() {
		return updateType;
	}
	public void setUpdateType(FormTypes updateType) {
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
	public FormStyles getSearchStyle() {
		return searchStyle;
	}
	public void setSearchStyle(FormStyles searchStyle) {
		this.searchStyle = searchStyle;
	}
	public FormStyles getResultsStyle() {
		return resultsStyle;
	}
	public void setResultsStyle(FormStyles resultsStyle) {
		this.resultsStyle = resultsStyle;
	}
	public FormStyles getDetailsStyle() {
		return detailsStyle;
	}
	public void setDetailsStyle(FormStyles detailsStyle) {
		this.detailsStyle = detailsStyle;
	}
	public FormStyles getUpdateStyle() {
		return updateStyle;
	}
	public void setUpdateStyle(FormStyles updateStyle) {
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
