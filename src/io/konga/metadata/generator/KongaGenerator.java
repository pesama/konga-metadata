package io.konga.metadata.generator;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.konga.metadata.annotations.FieldSet;
import io.konga.metadata.annotations.FieldType;
import io.konga.metadata.annotations.Linked;
import io.konga.metadata.annotations.Priority;
import io.konga.metadata.annotations.Role;
import io.konga.metadata.annotations.SearchConf;
import io.konga.metadata.annotations.Trigger;
import io.konga.metadata.annotations.Validator;
import io.konga.metadata.definition.*;
import io.konga.metadata.definition.enumerations.AccessModes;
import io.konga.metadata.definition.enumerations.FieldTypes;
import io.konga.metadata.definition.enumerations.FormTypes;
import io.konga.metadata.definition.enumerations.Multiplicities;
import io.konga.metadata.annotations.Access;
import io.konga.metadata.annotations.Action;
import io.konga.metadata.annotations.Actions;
import io.konga.metadata.annotations.ApiName;
import io.konga.metadata.annotations.ApiPath;
import io.konga.metadata.annotations.Categories;
import io.konga.metadata.annotations.Configuration;
import io.konga.metadata.annotations.Createable;
import io.konga.metadata.annotations.Defaults;
import io.konga.metadata.annotations.Deleteable;
import io.konga.metadata.annotations.Editable;
import io.konga.metadata.annotations.Entity;
import io.konga.metadata.annotations.EntityId;
import io.konga.metadata.annotations.EntityKey;
import io.konga.metadata.annotations.EntityLabel;
import io.konga.metadata.annotations.EntityParent;
import io.konga.metadata.annotations.Extends;
import io.konga.metadata.annotations.Favoriteable;
import io.konga.metadata.annotations.FieldSets;
import io.konga.metadata.annotations.FormStyle;
import io.konga.metadata.annotations.FormType;
import io.konga.metadata.annotations.Hint;
import io.konga.metadata.annotations.Label;
import io.konga.metadata.annotations.MaxLength;
import io.konga.metadata.annotations.MinLength;
import io.konga.metadata.annotations.Multiplicity;
import io.konga.metadata.annotations.OverrideDefaults;
import io.konga.metadata.annotations.Permissions;
import io.konga.metadata.annotations.QuickSearch;
import io.konga.metadata.annotations.Raw;
import io.konga.metadata.annotations.Required;
import io.konga.metadata.annotations.ResultClick;
import io.konga.metadata.annotations.Searchable;
import io.konga.metadata.annotations.ShortLabel;
import io.konga.metadata.annotations.ShowInDetails;
import io.konga.metadata.annotations.ShowInResults;
import io.konga.metadata.annotations.ShowInUpdate;
import io.konga.metadata.annotations.Sortable;
import io.konga.metadata.annotations.Type;
import io.konga.metadata.annotations.Unique;
import io.konga.metadata.definition.ConfigurationParam;
import io.konga.metadata.definition.FieldSetConfiguration;
import io.konga.metadata.definition.KongaAction;
import io.konga.metadata.definition.KongaDefinition;
import io.konga.metadata.definition.KongaEntity;
import io.konga.metadata.definition.KongaField;
import io.konga.metadata.definition.KongaMetadata;
import io.konga.metadata.definition.ScopedConfiguration;
import io.konga.metadata.definition.Security;
import io.konga.metadata.definition.ShowConfiguration;
import io.konga.metadata.definition.Validation;
import io.konga.metadata.definition.enumerations.DataTypes;
import io.konga.metadata.definition.enumerations.Stereotypes;
import io.konga.metadata.definition.enumerations.ValidatorTypes;
import org.reflections.Reflections;

public class KongaGenerator {
	
	// Annotation classes
	private static Class<Entity> annotationEntity = Entity.class;
	private static Class<Extends> annotationExtends = Extends.class;
	private static Class<Label> annotationLabel = Label.class;
	private static Class<ShortLabel> annotationShortLabel = ShortLabel.class;
	private static Class<Searchable> annotationSearchable = Searchable.class;
	private static Class<Createable> annotationCreateable = Createable.class;
	private static Class<Editable> annotationEditable = Editable.class;
	private static Class<Deleteable> annotationDeleteable = Deleteable.class;
	private static Class<Access> annotationAccess = Access.class;
	private static Class<FormType> annotationFormType = FormType.class;
	private static Class<FormStyle> annotationFormStyle = FormStyle.class;
	private static Class<Categories> annotationCategories = Categories.class;
	private static Class<Permissions> annotationPermissions = Permissions.class;
	private static Class<Role> annotationRole = Role.class;
	private static Class<ApiName> annotationApiName = ApiName.class;
	private static Class<ApiPath> annotationApiPath = ApiPath.class;
	private static Class<io.konga.metadata.annotations.Field> annotationField = io.konga.metadata.annotations.Field.class;
	private static Class<Multiplicity> annotationMultiplicity = Multiplicity.class;
	private static Class<ShowInResults> annotationShowInResults = ShowInResults.class;
	private static Class<ShowInUpdate> annotationShowInUpdate = ShowInUpdate.class;
	private static Class<ShowInDetails> annotationShowInDetails = ShowInDetails.class;
	private static Class<Type> annotationType = Type.class;
	private static Class<Required> annotationRequired = Required.class;
	private static Class<MinLength> annotationMinLength = MinLength.class;
	private static Class<MaxLength> annotationMaxLength = MaxLength.class;
	private static Class<Validator> annotationValidator = Validator.class;
	private static Class<Trigger> annotationTrigger = Trigger.class;
	private static Class<Unique> annotationUnique = Unique.class;
	private static Class<EntityId> annotationEntityId = EntityId.class;
	private static Class<EntityKey> annotationEntityKey = EntityKey.class;
	private static Class<EntityLabel> annotationEntityLabel = EntityLabel.class;
	private static Class<EntityParent> annotationEntityParent = EntityParent.class;
	private static Class<FieldType> annotationFieldType = FieldType.class;
	private static Class<Defaults> annotationDefaults = Defaults.class;
	private static Class<Priority> annotationPriority = Priority.class;
	private static Class<SearchConf> annotationSearchConf = SearchConf.class;
	private static Class<Actions> annotationActions = Actions.class;
	private static Class<ResultClick> annotationResultClick = ResultClick.class;
	private static Class<FieldSets> annotationFieldSets = FieldSets.class;
	private static Class<FieldSet> annotationFieldSet = FieldSet.class;
	private static Class<QuickSearch> annotationQuickSearch = QuickSearch.class;
	private static Class<Configuration> annotationConfiguration = Configuration.class;
	private static Class<OverrideDefaults> annotationOverrideDefaults = OverrideDefaults.class;
	private static Class<Sortable> annotationSortable = Sortable.class;
	private static Class<Favoriteable> annotationFavoriteable = Favoriteable.class;
	private static Class<Hint> annotationHint = Hint.class;
	private static Class<Linked> annotationLinked = Linked.class;
	
	// Store registered metadata
	private static List<KongaMetadata> registeredApplications = new ArrayList<KongaMetadata>();
	
	public static void registerApplication(KongaMetadata source) {
		
		// TODO Verify duplicity and all
		KongaGenerator.registeredApplications.add(source);
	}
	
	public static List<KongaMetadata> getAllApplications() {
		return KongaGenerator.registeredApplications;
	}

	public static KongaMetadata readPackage(KongaDefinition input) {
		
		// Create the metadata object
		KongaMetadata result = new KongaMetadata();
		
		// Setup the name
		result.setName(input.getAppName());
		
		// Generate the reflections object
		Reflections reflections = new Reflections(input.getModelPackage());
		
		Set<Class<?>> sourceList = reflections.getTypesAnnotatedWith(Entity.class);
		
		// Generate all entities
		List<KongaEntity> entities = new ArrayList<KongaEntity>();
		for(Class<?> source : sourceList) {
			KongaEntity entity = KongaGenerator.generateEntity(source);
			entities.add(entity);
		}
		
		// Setup the entities
		result.setEntities(entities);
		
		KongaGenerator.registerApplication(result);
		
		return result;
	}
	
	private static KongaEntity generateEntity(Class<?> source) {
		KongaEntity result = new KongaEntity();
		
		result.setClassFor(source);
		
		// Get the entity annotation
		Entity entityAnnotation = source.getAnnotation(annotationEntity);
		
		// Setup the name
		result.setName(KongaGenerator.getEntityName(source, entityAnnotation));
		
		// Setup the superclass
		result.setSuperClass(KongaGenerator.getSuperClass(source));
		
		// Setup the label
		result.setLabel(KongaGenerator.getLabel(source));
		
		// Setup the label
		result.setShortLabel(KongaGenerator.getShortLabel(source));
		
		// Setup access
		result.setAccess(KongaGenerator.getAccess(source));
		
		// Setup stereotypes
		result.setStereotypes(KongaGenerator.getStereotypes(source));
		
		// Setup createable			
		result.setCreateable(KongaGenerator.getCreateable(source));
		
		// Setup searchable			
		result.setSearchable(KongaGenerator.getSearchable(source));
		
		// Setup editable
		result.setEditable(KongaGenerator.getEditable(source));
		
		// Setup deleteable
		result.setDeleteable(KongaGenerator.getDeleteable(source));
		
		/*
		 *  Setup native actions
		 */
		// Result click actions
		result.setResultClick(KongaGenerator.getResultClick(source));
		
		// Setup extra actions
		result.setActions(KongaGenerator.getActions(source));
		
		// Setup form types
		if(source.isAnnotationPresent(annotationFormType)) {
			FormType annotation = source.getAnnotation(annotationFormType);
			
			result.setSearchType(annotation.search());
			result.setResultsType(annotation.results());
			result.setDetailsType(annotation.details());
			result.setUpdateType(annotation.update());
			result.setTemplate(annotation.template());
		}
		else {
			result.setSearchType(FormTypes.CASCADE);
			result.setResultsType(FormTypes.CASCADE);
			result.setDetailsType(FormTypes.CASCADE);
			result.setUpdateType(FormTypes.CASCADE);
			result.setTemplate(null);
		}
		
		// Setup form styles
		if(source.isAnnotationPresent(annotationFormStyle)) {
			FormStyle annotation = source.getAnnotation(annotationFormStyle);
			
			result.setSearchStyle(annotation.search());
			result.setResultsStyle(annotation.results());
			result.setDetailsStyle(annotation.details());
			result.setUpdateStyle(annotation.update());
		}
		
		// Setup api name
		result.setApiName(KongaGenerator.getApiName(source));
		
		// Setup api path
		result.setApiPath(KongaGenerator.getApiPath(source));
		
		// Setup categories
		result.setCategories(KongaGenerator.getCategories(source));
		
		// Setup security
		result.setSecurity(KongaGenerator.getSecurity(source));
		
		// Add all field sets
		result.setFieldSets(KongaGenerator.getFieldSets(source));
		
		// Add all fields
		List<KongaField> fields = new ArrayList<KongaField>();
		for(java.lang.reflect.Field field : source.getDeclaredFields()) {
			if(field.isAnnotationPresent(annotationField)) {
				KongaField fieldMetadata = KongaGenerator.generateField(field);
				fieldMetadata.setOwner(result.getName());
				
				if(fieldMetadata != null) {
					fields.add(fieldMetadata);
				}
			}
		}
		result.setFields(fields);
		
		// Setup configuration
		result.setConfiguration(KongaGenerator.getConfiguration(source));
		
		// Setup action overriding
		result.setOverrideDefaults(KongaGenerator.getOverrideDefaults(source));
		
		// Setup favoriteable
		result.setFavoriteable(KongaGenerator.getFavoriteable(source));
		
		return result;
	}
	
	private static Boolean getFavoriteable(Class<?> source) {
		if(source.isAnnotationPresent(annotationFavoriteable)) {
			Favoriteable annotation = source.getAnnotation(annotationFavoriteable);
			return annotation.value();
		}
		return false;
	}

	private static List<ConfigurationParam> getConfiguration(
			Class<?> source) {
		List<ConfigurationParam> configuration = new ArrayList<ConfigurationParam>();
		
		if(source.isAnnotationPresent(annotationConfiguration)) {
			Configuration annotation = source.getAnnotation(annotationConfiguration);
			
			Raw[] params = annotation.value();
			
			for(int i = 0; i < params.length; i++) {
				ConfigurationParam current = new ConfigurationParam();
				
				current.setKey(params[i].key().toString());
				current.setValue(params[i].value());
				
				configuration.add(current);
			}
		}
		
		return configuration;
	}
	
	private static List<ConfigurationParam> getConfiguration(Raw[] params) {
		List<ConfigurationParam> configuration = new ArrayList<ConfigurationParam>();
		
		for(int i = 0; i < params.length; i++) {
			ConfigurationParam current = new ConfigurationParam();
			
			current.setKey(params[i].key().toString());
			current.setValue(params[i].value());
			
			configuration.add(current);
		}
		return configuration;
	}
	
	private static void getConfiguration(Raw[] params, List<ConfigurationParam> configuration) {
		for(int i = 0; i < params.length; i++) {
			ConfigurationParam current = new ConfigurationParam();
			
			current.setKey(params[i].key().toString());
			current.setValue(params[i].value());
			
			configuration.add(current);
		}
	}

	private static String getEntityName(Class<?> source, Entity entityAnnotation) {
		String annotationValue = entityAnnotation.value();
		
		if(!annotationValue.isEmpty()) {
			return annotationValue;
		}
		
		// FIXME This will fail for entities in default package
		return source.getName().substring(source.getName().lastIndexOf('.') + 1);
	}

	private static List<io.konga.metadata.definition.FieldSet> getFieldSets(
			Class<?> source) {
		List<io.konga.metadata.definition.FieldSet> result = new ArrayList<io.konga.metadata.definition.FieldSet>();
		
		if(source.isAnnotationPresent(annotationFieldSets)) {
			FieldSets setConfiguration = source.getAnnotation(annotationFieldSets);
			FieldSet[] sets = setConfiguration.value();
			
			for(FieldSet set : sets) {
				io.konga.metadata.definition.FieldSet setDefinition = new io.konga.metadata.definition.FieldSet();
				
				setDefinition.setName(set.value());
				setDefinition.setConfiguration(KongaGenerator.getFieldSetConfiguration(set));
				
				result.add(setDefinition);
			}
		}
		
		return result;
	}

	private static FieldSetConfiguration getFieldSetConfiguration(FieldSet set) {
		FieldSetConfiguration result = new FieldSetConfiguration();
		Raw[] fieldSetConfiguration = set.configuration();
		
		for(Raw configuration : fieldSetConfiguration) {
			switch(configuration.key()) {
			case "USE_VIEW":
				result.setView(configuration.value());
				break;
			default:
			}
		}
		
		return result;
	}

	private static List<KongaAction> getResultClick(Class<?> source) {
		List<KongaAction> result = new ArrayList<KongaAction>();
		if(source.isAnnotationPresent(annotationResultClick)) {
			ResultClick annotation = source.getAnnotation(annotationResultClick);
			
			Action[] actions = annotation.value();
			
			result = KongaGenerator.parseActions(actions);
		}
		return result;
	}

	private static List<KongaAction> getActions(Class<?> source) {
		List<KongaAction> result = new ArrayList<KongaAction>();
		
		if(source.isAnnotationPresent(annotationActions)) {
			Actions actions = source.getAnnotation(annotationActions);
			
			Action[] definedActions = actions.value();
			
			result = KongaGenerator.parseActions(definedActions);
		}
		
		
		return result;
	}
	
	private static List<KongaAction> getActions(Field source) {
		List<KongaAction> result = new ArrayList<KongaAction>();
		
		if(source.isAnnotationPresent(annotationActions)) {
			Actions actions = source.getAnnotation(annotationActions);
			
			Action[] definedActions = actions.value();
			
			result = KongaGenerator.parseActions(definedActions);
		}
		
		
		return result;
	}
	
	private static List<KongaAction> parseActions(Action[] source) {
		List<KongaAction> result = new ArrayList<KongaAction>();
		
		for(int i = 0; i < source.length; i++) {
			KongaAction action = new KongaAction();
			
			action.setLabel(source[i].label());
			action.setName(source[i].name());
			action.setScope(source[i].scope());
			action.setIcon(source[i].icon());
			action.setOverrides(source[i].overrides());
			
			result.add(action);
		}
		
		return result;
	}

	private static String getCreateable(Class<?> source) {
		if(source.isAnnotationPresent(annotationCreateable)) {
			Createable annotation = source.getAnnotation(annotationCreateable);
			
			String value = annotation.value(); 
			
			return value;
		}
		return null;
	}

	private static KongaField generateField(java.lang.reflect.Field source) {
		KongaField result = new KongaField();
		
		io.konga.metadata.annotations.Field fieldAnnotation = source.getAnnotation(annotationField);
		
		// Setup the name
		result.setName(KongaGenerator.getFieldName(source, fieldAnnotation));
		
		// Setup the label
		result.setLabel(KongaGenerator.getLabel(source));
		
		// Setup the short label
		result.setShortLabel(KongaGenerator.getShortLabel(source));
		
		// Setup the hint
		result.setHint(KongaGenerator.getHint(source));
		
		// Setup data type
		result.setType(KongaGenerator.getDataType(source));
		
		// Setup entityId
		result.setIsId(KongaGenerator.getEntityId(source));
		
		// Setup entityKey
		result.setIsKey(KongaGenerator.getEntityKey(source));
		
		// Setup entityLabel
		result.setIsLabel(KongaGenerator.getEntityLabel(source));
		
		// Setup entityParent
		result.setIsParent(KongaGenerator.getEntityParent(source));
		
		// Setup access
		result.setAccess(KongaGenerator.getAccess(source));
		
		// Setup multiplicity
		result.setMultiplicity(KongaGenerator.getMultiplicity(source));
		
		// Setup searchable
		result.setSearchable(KongaGenerator.getSearchable(source));
		
		// Setup editable
		result.setEditable(KongaGenerator.getEditable(source));
		
		// Setup show in details
		result.setShowInDetails(KongaGenerator.getShowInDetails(source));
		
		// Setup show in results
		result.setShowInResults(KongaGenerator.getShowInResults(source));
		
		// Setup show in update
		result.setShowInUpdate(KongaGenerator.getShowInUpdate(source));
		
		// Setup categories
		result.setCategories(KongaGenerator.getCategories(source));
		
		// Setup api name
		result.setApiName(KongaGenerator.getApiName(source));
		
		// Setup field type
		result.setFieldType(KongaGenerator.getFieldType(source));
		
		// Setup defaults
		result.setDefaults(KongaGenerator.getDefaults(source));
		
		// Setup search configuration
		result.setSearchConf(KongaGenerator.getSearchConf(source));
		
		// Setup unique
		result.setUnique(KongaGenerator.getUnique(source));
		
		// Setup security
		result.setSecurity(KongaGenerator.getSecurity(source));
		
		// Setup validation
		result.setValidation(KongaGenerator.getValidation(source));
		
		// Setup triggers
		result.setTriggers(KongaGenerator.getTriggers(source));
		
		// Setup priority
		result.setPriority(KongaGenerator.getPriority(source));
		
		// Setup field set
		result.setFieldSet(KongaGenerator.getFieldSet(source));
		
		// Setup quick search
		result.setQuickSearch(KongaGenerator.getQuickSearch(source));
		
		// Setup actions
		result.setActions(KongaGenerator.getActions(source));
		
		// Setup default overriding
		result.setOverrideDefaults(KongaGenerator.getOverrideDefaults(source));
		
		// Setup sortable
		result.setSortable(KongaGenerator.getSortable(source));
		
		result.setLinked(KongaGenerator.getLinked(source));
		
		return result;
	}
	
	private static io.konga.metadata.definition.Linked getLinked(Field source) {
		if(source.isAnnotationPresent(annotationLinked)) {
			Linked annotation = source.getAnnotation(annotationLinked);
			io.konga.metadata.definition.Linked linkedField = new io.konga.metadata.definition.Linked();
			
			linkedField.setTo(annotation.to());
			linkedField.setVia(annotation.via());
			
			return linkedField;
		}
		return null;
	}

	private static String getHint(Field source) {
		if(source.isAnnotationPresent(annotationHint)) {
			Hint annotation = source.getAnnotation(annotationHint);
			
			return annotation.value();
		}
		return null;
	}

	private static Boolean getSortable(Field source) {
		if(source.isAnnotationPresent(annotationSortable)) {
			Sortable annotation = source.getAnnotation(annotationSortable);
			
			return annotation.value();
		}
		return true;
	}

	private static Boolean getEntityParent(Field source) {
		if(source.isAnnotationPresent(annotationEntityParent)) {
			EntityParent annotation = source.getAnnotation(annotationEntityParent);
			
			return annotation.value();
		}
		return false;
	}

	private static List<KongaAction> getOverrideDefaults(Field source) {
		List<KongaAction> result = new ArrayList<KongaAction>();
		if(source.isAnnotationPresent(annotationOverrideDefaults)) {
			OverrideDefaults annotation = source.getAnnotation(annotationOverrideDefaults);
			
			Action[] actions = annotation.value();
			result = KongaGenerator.parseActions(actions);
		}
		return result;
	}
	
	private static List<KongaAction> getOverrideDefaults(Class<?> source) {
		List<KongaAction> result = new ArrayList<KongaAction>();
		if(source.isAnnotationPresent(annotationOverrideDefaults)) {
			OverrideDefaults annotation = source.getAnnotation(annotationOverrideDefaults);
			
			Action[] actions = annotation.value();
			result = KongaGenerator.parseActions(actions);
		}
		return result;
	}

	private static String getFieldName(Field source,
			io.konga.metadata.annotations.Field fieldAnnotation) {
		if(!fieldAnnotation.value().isEmpty()) {
			return fieldAnnotation.value();
		}
		return source.getName();
	}

	private static ShowConfiguration getQuickSearch(Field source) {
		ShowConfiguration result = new ShowConfiguration();
		if(source.isAnnotationPresent(annotationQuickSearch)) {
			QuickSearch annotation = source.getAnnotation(annotationQuickSearch);
			
			result.setValue(annotation.value());
			result.setFields(Arrays.asList(annotation.fields()));
		}
		else {
			result.setValue(null);
		}
		return result;
	}

	private static String getFieldSet(Field source) {
		if(source.isAnnotationPresent(annotationFieldSet)) {
			FieldSet annotation = source.getAnnotation(annotationFieldSet);
			
			return annotation.value();
		}
		return null;
	}

	private static DataType getDataType(java.lang.reflect.Field source) {
		DataType result = new DataType();
		if(source.isAnnotationPresent(annotationType)) {
			Type annotation = source.getAnnotation(annotationType);
			
			result.setType(annotation.value());
			result.setComplexType(annotation.complexType());
			result.setFilter(annotation.filter());
			
			Raw[] queryValues = annotation.query();
			Map<String, String> query = new HashMap<String, String>();
			
			for(Raw queryParam : queryValues) {
				query.put(queryParam.key(), queryParam.value());
			}
			
			result.setQuery(query);
			
			List<ConfigurationParam> list = new ArrayList<ConfigurationParam>();
			for(Raw listItem : annotation.list()) {
				ConfigurationParam param = new ConfigurationParam(listItem.key(), listItem.value());
				list.add(param);
			}
			
			// Set from (Data retrieving function)
			String from = annotation.from();
			if(!from.isEmpty()) {
				result.setFrom(from);
			}
			
			result.setList(list);
		}
		else {
			Class<?> fieldType = source.getType();
			
			if(String.class.equals(fieldType)) {
				result.setType(DataTypes.STRING);
			}
			else if(Integer.class.equals(fieldType) ||
					Float.class.equals(fieldType) ||
					Double.class.equals(fieldType)) {
				result.setType(DataTypes.NUMBER);
			}
			else if(Boolean.class.equals(fieldType)) {
				result.setType(DataTypes.BOOLEAN);
			}
			else if(Date.class.equals(fieldType)) {
				result.setType(DataTypes.DATE);
			}
			// TODO Other values
			else  {
//				result.setType(DataType.COMPLEX);
//				result.setComplexType(complexType);
				// TODO Throw exception
			}
		}
		return result;
	}

	private static io.konga.metadata.definition.Priority getPriority(java.lang.reflect.Field source) {
		int defaultValue = 1000;
		if(source.isAnnotationPresent(annotationPriority)) {
			Priority annotation = source.getAnnotation(annotationPriority);
			
			io.konga.metadata.definition.Priority priority = new io.konga.metadata.definition.Priority();
			int value = annotation.value() != 0 ? annotation.value() : defaultValue;
			priority.setDetails(priority, annotation.details(), value);
			priority.setResults(priority, annotation.results(), value);
			priority.setSearch(priority, annotation.search(), value);
			priority.setUpdate(priority, annotation.update(), value);
			
			return priority;
		}
		return new io.konga.metadata.definition.Priority(defaultValue);
	}
	


	private static Boolean getEntityId(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationEntityId)) {
			EntityId annotation = source.getAnnotation(annotationEntityId);
			
			return annotation.value();
		}
		return false;
	}
	
	private static Boolean getEntityKey(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationEntityKey)) {
			EntityKey annotation = source.getAnnotation(annotationEntityKey);
			
			return annotation.value();
		}
		return false;
	}
	
	private static Boolean getEntityLabel(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationEntityLabel)) {
			EntityLabel annotation = source.getAnnotation(annotationEntityLabel);
			
			return annotation.value();
		}
		return false;
	}

	private static Multiplicities getMultiplicity(
			java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationMultiplicity)) {
			Multiplicity annotation = source.getAnnotation(annotationMultiplicity);
			
			return annotation.value();
		}
		return Multiplicities.ONE;
	}

	private static Security getSecurity(Class<?> source) {
		Security security = new Security();
		
		// Setup permissions
		if(source.isAnnotationPresent(annotationPermissions)) {
			Permissions annotation = source.getAnnotation(annotationPermissions);
			
			security.setPermissions(annotation.value());
		}
		
//		 Setup roles
		if(source.isAnnotationPresent(annotationRole)) {
			Role annotation = source.getAnnotation(annotationRole);
			
			security.setRoles(Arrays.asList(annotation.value()));
		}
		
		return security;
	}
	
	private static Security getSecurity(java.lang.reflect.Field source) {
		Security security = new Security();
		
		// Setup permissions
		if(source.isAnnotationPresent(annotationPermissions)) {
			Permissions annotation = source.getAnnotation(annotationPermissions);
			
			security.setPermissions(annotation.value());
		}
		
		// Setup roles
		if(source.isAnnotationPresent(annotationRole)) {
		Role annotation = source.getAnnotation(annotationRole);
		
		security.setRoles(Arrays.asList(annotation.value()));
	}
		
		return security;
	}

	private static List<String> getCategories(Class<?> source) {
		if(source.isAnnotationPresent(annotationCategories)) {
			Categories annotation = source.getAnnotation(annotationCategories);
			
			return Arrays.asList(annotation.value());
		}
		return new ArrayList<String>();
	}
	
	private static List<String> getCategories(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationCategories)) {
			Categories annotation = source.getAnnotation(annotationCategories);
			
			return Arrays.asList(annotation.value());
		}
		return new ArrayList<String>();
	}

	private static String getApiPath(Class<?> source) {
		if(source.isAnnotationPresent(annotationApiPath)) {
			ApiPath annotation = source.getAnnotation(annotationApiPath);
			
			return annotation.value();
		}
		return null;
	}

	private static String getApiName(Class<?> source) {
		if(source.isAnnotationPresent(annotationApiName)) {
			ApiName annotation = source.getAnnotation(annotationApiName);
			
			return annotation.value()[0];
//			TODO Change this
		}
		return null;
	}
	
	private static List<String> getApiName(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationApiName)) {
			ApiName annotation = source.getAnnotation(annotationApiName);
			
			return Arrays.asList(annotation.value());
		}
		return null;
	}

	private static String getDeleteable(Class<?> source) {
		if(source.isAnnotationPresent(annotationDeleteable)) {
			Deleteable annotation = source.getAnnotation(annotationDeleteable);
			
			String value = annotation.value(); 
			
			return value;
		}
		return null;
	}

	private static String getEditable(Class<?> source) {
		if(source.isAnnotationPresent(annotationEditable)) {
			Editable annotation = source.getAnnotation(annotationEditable);
			
			String value = annotation.value(); 
			
			return value;
		}
		return null;
	}
	
	private static ShowConfiguration getEditable(java.lang.reflect.Field source) {
		ShowConfiguration result = new ShowConfiguration();
		if(source.isAnnotationPresent(annotationEditable)) {
			Editable annotation = source.getAnnotation(annotationEditable);
			
			String value = annotation.value(); 
			
			result.setValue(value);
			List<String> fields = Arrays.asList(annotation.fields());
			if(fields.size() > 1 || !"".equals(fields.get(0))) {
				result.setFields(fields);
			}
			else {
				result.setFields(new ArrayList<String>());
			}
		}
		else {
			result.setValue(null);
		}
		return result;
	}

	private static String getSearchable(Class<?> source) {
		if(source.isAnnotationPresent(annotationSearchable)) {
			Searchable annotation = source.getAnnotation(annotationSearchable);
			
			String value = annotation.value(); 
			
			return value;
		}
		return null;
	}
	
	private static ShowConfiguration getSearchable(java.lang.reflect.Field source) {
		ShowConfiguration result = new ShowConfiguration();
		if(source.isAnnotationPresent(annotationSearchable)) {
			Searchable annotation = source.getAnnotation(annotationSearchable);
			
			String value = annotation.value(); 
			
			result.setValue(value);
			List<String> fields = Arrays.asList(annotation.fields());
			result.setFields(fields);
			result.setConfiguration(getConfiguration(annotation.configuration()));
		}
		else {
			result.setValue(null);
		}
		return result;
	}

	private static List<Stereotypes> getStereotypes(Class<?> source) {
		List<Stereotypes> stereotypes = new ArrayList<Stereotypes>();
		// Is it abstract?
		if(Modifier.isAbstract(source.getModifiers())) {
			stereotypes.add(Stereotypes.ABSTRACT);
		}
		// Is it final?
		if(Modifier.isFinal(source.getModifiers())) {
			stereotypes.add(Stereotypes.FINAL);
		}
		
		return stereotypes;
	}

	private static AccessModes getAccess(
			Class<?> source) {
		if(source.isAnnotationPresent(annotationAccess)) {
			Access annotation = source.getAnnotation(annotationAccess);
			
			return annotation.value();
		}
		return AccessModes.PUBLIC;
	}
	
	private static AccessModes getAccess(
			java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationAccess)) {
			Access annotation = source.getAnnotation(annotationAccess);
			
			return annotation.value();
		}
		return AccessModes.PUBLIC;
	}

	private static String getLabel(Class<?> source) {
		if(source.isAnnotationPresent(annotationLabel)) {
			Label annotation = source.getAnnotation(annotationLabel);
			
			return annotation.value();
		}
		return null;
	}
	
	private static String getShortLabel(Class<?> source) {
		if(source.isAnnotationPresent(annotationShortLabel)) {
			ShortLabel annotation = source.getAnnotation(annotationShortLabel);
			
			return annotation.value();
		}
		return null;
	}
	
	private static String getLabel(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationLabel)) {
			Label annotation = source.getAnnotation(annotationLabel);
			
			return annotation.value();
		}
		return null;
	}
	
	private static String getShortLabel(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationShortLabel)) {
			ShortLabel annotation = source.getAnnotation(annotationShortLabel);
			
			return annotation.value();
		}
		return null;
	}

	private static String getSuperClass(Class<?> source) {
		if(source.isAnnotationPresent(annotationExtends)) {
			Extends annotation = source.getAnnotation(annotationExtends);
			
			return annotation.value();
		}
		return null;
	}

	private static List<io.konga.metadata.definition.Trigger> getTriggers(
			java.lang.reflect.Field source) {
		List<io.konga.metadata.definition.Trigger> triggers = new ArrayList<io.konga.metadata.definition.Trigger>();
		
		if(source.isAnnotationPresent(annotationTrigger)) {
			io.konga.metadata.definition.Trigger trigger = new io.konga.metadata.definition.Trigger();
			
			Trigger annotation = source.getAnnotation(annotationTrigger);
			
			trigger.setMatch(annotation.match());
			trigger.setMatchType(annotation.matchType());
			trigger.setMoment(annotation.moment());
			trigger.setName(annotation.name());
			trigger.setParameters(Arrays.asList(annotation.parameters()));
			trigger.setValue(annotation.value());
			trigger.setType(annotation.type());
			
			triggers.add(trigger);
		}
		
		return triggers;
	}

	private static Validation getValidation(java.lang.reflect.Field source) {
		Validation validation = new Validation();
		
		// Setup required
		if(source.isAnnotationPresent(annotationRequired)) {
			Required annotation = source.getAnnotation(annotationRequired);
			
			validation.setRequired(annotation.value());
		}
		
		// Setup min length
		if(source.isAnnotationPresent(annotationMinLength)) {
			MinLength annotation = source.getAnnotation(annotationMinLength);
			
			validation.setMinLength(annotation.value());
		}
		
		// Setup max length
		if(source.isAnnotationPresent(annotationMaxLength)) {
			MaxLength annotation = source.getAnnotation(annotationMaxLength);
			
			validation.setMaxLength(annotation.value());
		}
		
		// Setup validators
		List<io.konga.metadata.definition.Validator> validators = new ArrayList<io.konga.metadata.definition.Validator>();
		if(source.isAnnotationPresent(annotationValidator)) {
			Validator annotation = source.getAnnotation(annotationValidator);
			io.konga.metadata.definition.Validator validator = new io.konga.metadata.definition.Validator();
			
			validator.setType(annotation.type());
			validator.setValue(annotation.value());
			
			validators.add(validator);
			validation.setValidators(validators);
		}
		
		return validation;
	}

	private static boolean getUnique(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationUnique)) {
			Unique annotation = source.getAnnotation(annotationUnique);
			
			return annotation.value();
		}
		return false;
	}

	private static io.konga.metadata.definition.SearchConf getSearchConf(
			java.lang.reflect.Field source) {
		io.konga.metadata.definition.SearchConf configuration = new io.konga.metadata.definition.SearchConf();
		
		if(source.isAnnotationPresent(annotationSearchConf)) {
			SearchConf annotation = source.getAnnotation(annotationSearchConf);
			
			// Setup policy
			configuration.setPolicy(annotation.policy());
			
			// Setup multiplicity
			configuration.setMultiplicity(annotation.multiplicity());
			
			// Setup fields
			configuration.setFields(Arrays.asList(annotation.fields()));
		}
		else {
			configuration.setPolicy(ValidatorTypes.EXACT_MATCH);
			
			configuration.setMultiplicity(Multiplicities.ONE);
			
			configuration.setFields(new ArrayList<String>());
		}
		return configuration;
	}

	private static String getDefaults(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationDefaults)) {
			Defaults annotation = source.getAnnotation(annotationDefaults);
			
			return annotation.value();
		}
		return null;
	}

	private static io.konga.metadata.definition.FieldType getFieldType(
			java.lang.reflect.Field source) {
		io.konga.metadata.definition.FieldType result = new io.konga.metadata.definition.FieldType();
		if(source.isAnnotationPresent(annotationFieldType)) {
			FieldType annotation = source.getAnnotation(annotationFieldType);
			
			result.setDetails(annotation.value());
			result.setUpdate(annotation.value());
			result.setResults(annotation.value());
			result.setSearch(annotation.value());
			
			if(annotation.details() != FieldTypes.UNDEFINED) {
				result.setDetails(annotation.details());
			}
			
			if(annotation.update() != FieldTypes.UNDEFINED) {
				result.setUpdate(annotation.update());
			}
			
			if(annotation.results() != FieldTypes.UNDEFINED) {
				result.setResults(annotation.results());
			}
			
			if(annotation.search() != FieldTypes.UNDEFINED) {
				result.setSearch(annotation.search());
			}
			
			Configuration[] configuration = annotation.configuration();
			List<ScopedConfiguration> resultConfiguration = new ArrayList<ScopedConfiguration>();
			for(int i = 0; i < configuration.length; i++) {
				ScopedConfiguration scopedConfiguration = new ScopedConfiguration();
				scopedConfiguration.setScope(configuration[i].scope());
				KongaGenerator.getConfiguration(configuration[i].value(), scopedConfiguration);
				resultConfiguration.add(scopedConfiguration);
			}
			
			result.setConfiguration(resultConfiguration);
		}
		else {
			FieldTypes type = FieldTypes.PLAIN;
			Class<?> fieldType = source.getType();
			
			if(String.class.equals(fieldType)) {
				type = FieldTypes.PLAIN;
			}
			else if(Integer.class.equals(fieldType)) {
				type = FieldTypes.PLAIN;
			}
			else if(Boolean.class.equals(fieldType)) {
				type = FieldTypes.BOOLEAN;
			}
			else if(Date.class.equals(fieldType)) {
				type = FieldTypes.DATE;
			}
			result.setDetails(type);
			result.setUpdate(type);
			result.setResults(type);
			result.setSearch(type);
		}
		return result;
	}

	private static ShowConfiguration getShowInDetails(java.lang.reflect.Field source) {
		ShowConfiguration result = new ShowConfiguration();
		if(source.isAnnotationPresent(annotationShowInDetails)) {
			ShowInDetails annotation = source.getAnnotation(annotationShowInDetails);
			
			String value = annotation.value(); 
			
			result.setValue(value);
			List<String> fields = Arrays.asList(annotation.fields());
			result.setFields(fields);
			result.setConfiguration(getConfiguration(annotation.configuration()));
		}
		else {
			result.setValue(null);
		}
		return result;
	}
	
	private static ShowConfiguration getShowInResults(java.lang.reflect.Field source) {
		ShowConfiguration result = new ShowConfiguration();
		if(source.isAnnotationPresent(annotationShowInResults)) {
			ShowInResults annotation = source.getAnnotation(annotationShowInResults);
			
			String value = annotation.value(); 
			
			result.setValue(value);
			List<String> fields = Arrays.asList(annotation.fields());
			result.setFields(fields);
			result.setConfiguration(getConfiguration(annotation.configuration()));
		}
		else {
			result.setValue(null);
		}
		return result;
	}
	
	private static ShowConfiguration getShowInUpdate(java.lang.reflect.Field source) {
		ShowConfiguration result = new ShowConfiguration();
		if(source.isAnnotationPresent(annotationShowInUpdate)) {
			ShowInUpdate annotation = source.getAnnotation(annotationShowInUpdate);
			
			String value = annotation.value(); 
			
			result.setValue(value);
			List<String> fields = Arrays.asList(annotation.fields());
			result.setFields(fields);
			result.setConfiguration(getConfiguration(annotation.configuration()));
		}
		else {
			result.setValue(null);
		}
		return result;
	}
}
