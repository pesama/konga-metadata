package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.annotations.Action;
import org.kongaproject.metadata.annotations.Actions;
import org.kongaproject.metadata.annotations.ApiPath;
import org.kongaproject.metadata.annotations.Categories;
import org.kongaproject.metadata.annotations.Createable;
import org.kongaproject.metadata.annotations.Defaults;
import org.kongaproject.metadata.annotations.Deleteable;
import org.kongaproject.metadata.annotations.Editable;
import org.kongaproject.metadata.annotations.Entity;
import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.annotations.EntityKey;
import org.kongaproject.metadata.annotations.EntityLabel;
import org.kongaproject.metadata.annotations.Field;
import org.kongaproject.metadata.annotations.FieldType;
import org.kongaproject.metadata.annotations.FormStyle;
import org.kongaproject.metadata.annotations.FormType;
import org.kongaproject.metadata.annotations.Hint;
import org.kongaproject.metadata.annotations.Label;
import org.kongaproject.metadata.annotations.Linked;
import org.kongaproject.metadata.annotations.MaxLength;
import org.kongaproject.metadata.annotations.Multiplicity;
import org.kongaproject.metadata.annotations.OverrideDefaults;
import org.kongaproject.metadata.annotations.Raw;
import org.kongaproject.metadata.annotations.Required;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.annotations.ShowInResults;
import org.kongaproject.metadata.annotations.ShowInUpdate;
import org.kongaproject.metadata.annotations.Type;
import org.kongaproject.metadata.definition.enumerations.AccessModes;
import org.kongaproject.metadata.definition.enumerations.DataTypes;
import org.kongaproject.metadata.definition.enumerations.FieldTypes;
import org.kongaproject.metadata.definition.enumerations.FormModes;
import org.kongaproject.metadata.definition.enumerations.FormStyles;
import org.kongaproject.metadata.definition.enumerations.FormTypes;
import org.kongaproject.metadata.definition.enumerations.Multiplicities;
import org.kongaproject.metadata.definition.enumerations.Stereotypes;


@Entity("konga-entity")
@Label("Entity")
@ApiPath("entities")
@Searchable
@Createable
@Editable
@Deleteable
@FormType(update=FormTypes.TABBED)
@FormStyle(update=FormStyles.HORIZONTAL)
@OverrideDefaults(
	@Action(overrides="save", name="save-entity-to-metadata")
)
public class KongaEntity {
	
	private Class<?> classFor;
	
	@Field
	@EntityId
	@Searchable("SUPER_ADMIN")
	@ShowInResults("SUPER_ADMIN")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	private Integer id;
	
	/**
	 * Name of the entity
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
	 * Superclass of the entity
	 */
	@Field
	@Label("Parent entity")
	@Type(value=DataTypes.COMPLEX, complexType="konga-entity")
	@FieldType(FieldTypes.SELECT)
	@EntityLabel
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Editable
	@Categories("Relationships")
	private String superClass;
	
	/**
	 * Label for the entity (placeholder name)
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
	 * Short Label for the entity (placeholder name)
	 */
	@Field
	@Label("Short label")
	@ShowInUpdate
	@Editable
	@Categories("Definition")
	private String shortLabel;
	
	/**
	 * Access configuration 
	 */
	@Field
	@Label("Visibility")
	@Searchable
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="public", value="Visible"),
		@Raw(key="hidden", value="Hidden (System entity)"),
	})
	@Defaults("public")
	@FieldType(FieldTypes.COMBOBOX)
	@Categories("Operations")
	private AccessModes access;
	
	/**
	 * Stereotypes for the entity
	 */
	private List<Stereotypes> stereotypes;
	
	/**
	 * Permission needed for searching the entity
	 */
	@Field("searchable")
	@Label("Searchable")
	@FieldType(update=FieldTypes.BOOLEAN)
	@ShowInUpdate
	@Editable
	@Defaults("false")
	@Categories("Operations")
	private boolean searchEnabled;
	
	@Field("searchPermissions")
	@Label("For who?")
	@Hint("Permission for search. Left blank for public")
	@ShowInUpdate
	@Categories("Operations")
	@Linked(to="searchable", via="permissions-checked")
	private String searchable;
	
	/**
	 * Permission needed for creating entities
	 */
	@Field("createable")
	@Label("Createable")
	@FieldType(update=FieldTypes.BOOLEAN)
	@ShowInUpdate
	@Editable
	@Defaults("false")
	@Categories("Operations")
	private boolean createEnabled;
	
	@Field("createPermissions")
	@Label("For who?")
	@Hint("Permission for creating. Left blank for public")
	@ShowInUpdate
	@Categories("Operations")
	@Linked(to="createable", via="permissions-checked")
	private String createable;
	
	/**
	 * Permission needed for updating the entity
	 */
	@Field("editable")
	@Label("Editable")
	@FieldType(update=FieldTypes.BOOLEAN)
	@ShowInUpdate
	@Editable
	@Defaults("false")
	@Categories("Operations")
	private boolean editPermissions;
	
	@Field("editPermissions")
	@Label("For who?")
	@Hint("Permission for edition. Left blank for public")
	@ShowInUpdate
	@Categories("Operations")
	@Linked(to="editable", via="permissions-checked")
	private String editable;
	
	/**
	 * Permission needed for deleting 
	 */
	@Field("deleteable")
	@Label("Deleteable")
	@FieldType(update=FieldTypes.BOOLEAN)
	@ShowInUpdate
	@Editable
	@Defaults("false")
	@Categories("Operations")
	private boolean deletePermissions;
	
	@Field("deletePermissions")
	@Label("For who?")
	@Hint("Permission for search. If left blank, anybody could search this entity")
	@ShowInUpdate
	@Categories("Operations")
	@Linked(to="deleteable", via="permissions-checked")
	private String deleteable;
	
	/**
	 * Form type for searching the entity
	 */
	@Field
	@Label("Search form")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="CASCADE", value="Cascade"),
		@Raw(key="CATEGORIZED_CASCADE", value="Categorized Cascade"),
		@Raw(key="TABBED", value="Tabbed"),
		@Raw(key="STEPPED", value="Stepped"),
		@Raw(key="CUSTOM_TABBED", value="Fieldset tabbed (custom views)"),
		@Raw(key="CUSTOM", value="Custom")
	})
	@Defaults("CASCADE")
	@Categories("Appearance")
	@FieldType(FieldTypes.COMBOBOX)
	private FormTypes searchType;
	
	/**
	 * Form style for search panels
	 */
	@Field
	@Label("Search form style")
	@Type(value=DataTypes.STRING, list={
		@Raw(key="STANDARD", value="Label and input in block"),
		@Raw(key="HORIZONTAL", value="Label and input inline")
	})
	@Defaults("HORIZONTAL")
	@Categories("Appearance")
	@FieldType(FieldTypes.COMBOBOX)
	private FormStyles searchStyle;
	
	/**
	 * Form type for the results pane
	 */
	@Field
	@Label("Results form type")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="CASCADE", value="Cascade"),
		@Raw(key="CATEGORIZED_CASCADE", value="Categorized Cascade"),
		@Raw(key="TABBED", value="Tabbed"),
		@Raw(key="STEPPED", value="Stepped"),
		@Raw(key="CUSTOM_TABBED", value="Fieldset tabbed (custom views)"),
		@Raw(key="CUSTOM", value="Custom")
	})
	@Defaults("CASCADE")
	@Categories("Appearance")
	@FieldType(FieldTypes.COMBOBOX)
	private FormTypes resultsType;
	
	/**
	 * Form style for results panels
	 */
	@Field
	@Label("Results form style")
	@Type(value=DataTypes.STRING, list={
		@Raw(key="STANDARD", value="Label and input in block"),
		@Raw(key="HORIZONTAL", value="Label and input inline")
	})
	@Defaults("HORIZONTAL")
	@Categories("Appearance")
	@FieldType(FieldTypes.COMBOBOX)
	private FormStyles resultsStyle;
	
	/**
	 * Form type for the details pane
	 */
	@Field
	@Label("Details form type")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="CASCADE", value="Cascade"),
		@Raw(key="CATEGORIZED_CASCADE", value="Categorized Cascade"),
		@Raw(key="TABBED", value="Tabbed"),
		@Raw(key="STEPPED", value="Stepped"),
		@Raw(key="CUSTOM_TABBED", value="Fieldset tabbed (custom views)"),
		@Raw(key="CUSTOM", value="Custom")
	})
	@Defaults("CASCADE")
	@Categories("Appearance")
	@FieldType(FieldTypes.COMBOBOX)
	private FormTypes detailsType;
	
	/**
	 * Form style for details panels
	 */
	@Field
	@Label("Details form style")
	@Type(value=DataTypes.STRING, list={
		@Raw(key="STANDARD", value="Label and input in block"),
		@Raw(key="HORIZONTAL", value="Label and input inline")
	})
	@Defaults("HORIZONTAL")
	@Categories("Appearance")
	@FieldType(FieldTypes.COMBOBOX)
	private FormStyles detailsStyle;
	
	/**
	 * Form type for the update pane
	 */
	@Field
	@Label("Update form type")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.STRING, list={
		@Raw(key="CASCADE", value="Cascade"),
		@Raw(key="CATEGORIZED_CASCADE", value="Categorized Cascade"),
		@Raw(key="TABBED", value="Tabbed"),
		@Raw(key="STEPPED", value="Stepped"),
		@Raw(key="CUSTOM_TABBED", value="Fieldset tabbed (custom views)"),
		@Raw(key="CUSTOM", value="Custom")
	})
	@Defaults("CASCADE")
	@Categories("Appearance")
	@FieldType(FieldTypes.COMBOBOX)
	private FormTypes updateType;
	
	/**
	 * Form style for update panels
	 */
	@Field
	@Label("Update form style")
	@Type(value=DataTypes.STRING, list={
		@Raw(key="STANDARD", value="Label and input in block"),
		@Raw(key="HORIZONTAL", value="Label and input inline")
	})
	@Defaults("HORIZONTAL")
	@Categories("Appearance")
	@FieldType(FieldTypes.COMBOBOX)
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
	@Field
	@Label("API Path")
	@Searchable("SUPER_ADMIN")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	@Categories("Configuration")
	private String apiPath;
	
	/**
	 * Set of categories of the entity
	 */
	@Field
	@Label("API Path")
	@Searchable
	@ShowInUpdate
	@Editable
	@Type(DataTypes.STRING)
	@Multiplicity(Multiplicities.MANY)
	@Categories("Definition")
	private List<String> categories;
	
	/**
	 * Security configuration for the entity
	 */
	private Security security;
	
	/**
	 * Entity fields
	 */
	@Field
	@Label("Fields")
	@ShowInUpdate(fields={"id", "name", "type"})
	@Editable
	@Type(value=DataTypes.COMPLEX, complexType="konga-field")
	@FieldType(FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	@Categories("Fields")
	@OverrideDefaults(
		@Action(overrides="add", name="add-field-to-entity")
	)
	@Actions({
		@Action(icon="fa fa-edit", name="edit-field", label="Edit", scope=FormModes.UPDATE),
		@Action(icon="fa fa-remove", name="remove-field", label="Remove", scope=FormModes.UPDATE)
	})
	private List<KongaField> fields;
	
	/**
	 * List of field sets for the entity
	 */
	@Field
	@Label("Field sets")
	@Hint("Define here your field groupings, if you are going to do any customization to them")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	@Type(value=DataTypes.COMPLEX, complexType="konga-fieldset")
	@FieldType(FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	@Categories("Fields")
	private List<FieldSet> fieldSets;
	
	/**
	 * Entity actions
	 */
	@Field
	@Label("Actions")
	@Hint("Define here the custom actions you will implement over this entity")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	@Type(value=DataTypes.COMPLEX, complexType="konga-action")
	@FieldType(FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	@Categories("Customization")
	private List<KongaAction> actions;
	
	/**
	 * Override defaults
	 */
	@Field
	@Label("Defaults overriden")
	@Hint("Add here the actions you will develop for overriding standard content")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	@Type(value=DataTypes.COMPLEX, complexType="konga-action")
	@FieldType(FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	@Categories("Customization")
	private List<KongaAction> overrideDefaults;
	
	/**
	 * Entity configuration
	 */
	@Field
	@Label("Configuration")
	@Hint("Configure your entity here")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	@Type(value=DataTypes.COMPLEX, complexType="konga-configuration")
	@FieldType(FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
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
