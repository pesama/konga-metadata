package org.kongaproject.metadata.generator;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kongaproject.metadata.annotations.Access;
import org.kongaproject.metadata.annotations.ApiName;
import org.kongaproject.metadata.annotations.ApiPath;
import org.kongaproject.metadata.annotations.Categories;
import org.kongaproject.metadata.annotations.Createable;
import org.kongaproject.metadata.annotations.Defaults;
import org.kongaproject.metadata.annotations.Deleteable;
import org.kongaproject.metadata.annotations.Editable;
import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.annotations.EntityKey;
import org.kongaproject.metadata.annotations.EntityLabel;
import org.kongaproject.metadata.annotations.Extends;
import org.kongaproject.metadata.annotations.FieldType;
import org.kongaproject.metadata.annotations.FormType;
import org.kongaproject.metadata.annotations.Label;
import org.kongaproject.metadata.annotations.MaxLength;
import org.kongaproject.metadata.annotations.MinLength;
import org.kongaproject.metadata.annotations.Multiplicity;
import org.kongaproject.metadata.annotations.Permissions;
import org.kongaproject.metadata.annotations.Required;
import org.kongaproject.metadata.annotations.Role;
import org.kongaproject.metadata.annotations.SearchConf;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.annotations.ShowInDetails;
import org.kongaproject.metadata.annotations.ShowInResults;
import org.kongaproject.metadata.annotations.ShowInUpdate;
import org.kongaproject.metadata.annotations.Trigger;
import org.kongaproject.metadata.annotations.TriggerParam;
import org.kongaproject.metadata.annotations.Unique;
import org.kongaproject.metadata.annotations.Validator;
import org.kongaproject.metadata.definition.Entity;
import org.kongaproject.metadata.definition.Field;
import org.kongaproject.metadata.definition.KongaDefinition;
import org.kongaproject.metadata.definition.KongaMetadata;
import org.kongaproject.metadata.definition.Security;
import org.kongaproject.metadata.definition.Validation;
import org.kongaproject.metadata.definition.enumerations.Stereotype;

public class KongaGenerator {
	
	// Annotation classes
	private static Class<org.kongaproject.metadata.annotations.Entity> annotationEntity = org.kongaproject.metadata.annotations.Entity.class;
	private static Class<Extends> annotationExtends = Extends.class;
	private static Class<Label> annotationLabel = Label.class;
	private static Class<Searchable> annotationSearchable = Searchable.class;
	private static Class<Createable> annotationCreateable = Createable.class;
	private static Class<Editable> annotationEditable = Editable.class;
	private static Class<Deleteable> annotationDeleteable = Deleteable.class;
	private static Class<Access> annotationAccess = Access.class;
	private static Class<FormType> annotationFormType = FormType.class;
	private static Class<Categories> annotationCategories = Categories.class;
	private static Class<Permissions> annotationPermissions = Permissions.class;
	private static Class<Role> annotationRole = Role.class;
	private static Class<ApiName> annotationApiName = ApiName.class;
	private static Class<ApiPath> annotationApiPath = ApiPath.class;
	private static Class<org.kongaproject.metadata.annotations.Field> annotationField = org.kongaproject.metadata.annotations.Field.class;
	private static Class<Multiplicity> annotationMultiplicity = Multiplicity.class;
	private static Class<ShowInResults> annotationShowInResults = ShowInResults.class;
	private static Class<ShowInUpdate> annotationShowInUpdate = ShowInUpdate.class;
	private static Class<ShowInDetails> annotationShowInDetails = ShowInDetails.class;
	private static Class<Required> annotationRequired = Required.class;
	private static Class<MinLength> annotationMinLength = MinLength.class;
	private static Class<MaxLength> annotationMaxLength = MaxLength.class;
	private static Class<Validator> annotationValidator = Validator.class;
	private static Class<Trigger> annotationTrigger = Trigger.class;
	private static Class<TriggerParam> annotationTriggerParam = TriggerParam.class;
	private static Class<Unique> annotationUnique = Unique.class;
	private static Class<EntityId> annotationEntityId = EntityId.class;
	private static Class<EntityKey> annotationEntityKey = EntityKey.class;
	private static Class<EntityLabel> annotationEntityLabel = EntityLabel.class;
	private static Class<FieldType> annotationFieldType = FieldType.class;
	private static Class<Defaults> annotationDefaults = Defaults.class;
	private static Class<SearchConf> annotationSearchConf = SearchConf.class;



	public static KongaMetadata readPackage(KongaDefinition input) {
		
		// Create the metadata object
		KongaMetadata result = new KongaMetadata();
		
		// Setup the name
		result.setName(input.getAppName());
		
		List<Class<?>> sourceList = null; // TODO Retrieve from reflections
		
		// Generate all entities
		List<Entity> entities = new ArrayList<Entity>();
		for(Class<?> source : sourceList) {
			Entity entity = KongaGenerator.generateEntity(source);
			entities.add(entity);
		}
		
		// Setup the entities
		result.setEntities(entities);
		return result;
	}
	
	private static Entity generateEntity(Class<?> source) {
		Entity result = new Entity();
		
		// Get the entity annotation
		org.kongaproject.metadata.annotations.Entity entityAnnotation = source.getAnnotation(annotationEntity); 
		
		// Setup the name
		result.setName(entityAnnotation.value());
		
		// Setup the superclass
		result.setSuperClass(KongaGenerator.getSuperClass(source));
		
		// Setup the label
		result.setLabel(KongaGenerator.getLabel(source));
		
		// Setup access
		result.setAccess(KongaGenerator.getAccess(source));
		
		// Setup stereotypes
		result.setStereotypes(KongaGenerator.getStereotypes(source));
		
		// Setup searchable			
		result.setSearchable(KongaGenerator.getSearchable(source));
		
		// Setup editable
		result.setEditable(KongaGenerator.getEditable(source));
		
		// Setup deleteable
		result.setDeleteable(KongaGenerator.getDeleteable(source));
		
		// Setup form types
		if(source.isAnnotationPresent(annotationFormType)) {
			FormType annotation = source.getAnnotation(annotationFormType);
			
			result.setSearchType(annotation.search());
			result.setResultsType(annotation.search());
			result.setDetailsType(annotation.search());
			result.setUpdateType(annotation.search());
		}
		
		
		// Setup api name
		result.setApiName(KongaGenerator.getApiName(source));
		
		// Setup api path
		result.setApiPath(KongaGenerator.getApiPath(source));
		
		// Setup categories
		result.setCategories(KongaGenerator.getCategories(source));
		
		// Setup security
		result.setSecurity(KongaGenerator.getSecurity(source));
		
		// Add all fields
		List<Field> fields = new ArrayList<Field>();
		for(java.lang.reflect.Field field : source.getDeclaredFields()) {
			if(field.isAnnotationPresent(annotationField)) {
				Field fieldMetadata = KongaGenerator.generateField(field);
				
				if(fieldMetadata != null) {
					fields.add(fieldMetadata);
				}
			}
		}
		result.setFields(fields);
		
		return result;
	}
	
	private static Field generateField(java.lang.reflect.Field source) {
		Field result = new Field();
		
		org.kongaproject.metadata.annotations.Field fieldAnnotation = source.getAnnotation(annotationField);
		
		// Setup the name
		result.setName(fieldAnnotation.value());
		
		// Setup the label
		result.setLabel(KongaGenerator.getLabel(source));
		
		// Setup access
		result.setAccess(KongaGenerator.getAccess(source));
		
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
		
		return result;
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
		return null;
	}
	
	private static List<String> getCategories(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationCategories)) {
			Categories annotation = source.getAnnotation(annotationCategories);
			
			return Arrays.asList(annotation.value());
		}
		return null;
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
			
			return annotation.value();
		}
		return null;
	}
	
	private static String getApiName(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationApiName)) {
			ApiName annotation = source.getAnnotation(annotationApiName);
			
			return annotation.value();
		}
		return null;
	}

	private static boolean getDeleteable(Class<?> source) {
		if(source.isAnnotationPresent(annotationDeleteable)) {
			Deleteable annotation = source.getAnnotation(annotationDeleteable);
			
			return annotation.value();
		}
		return false;
	}

	private static boolean getEditable(Class<?> source) {
		if(source.isAnnotationPresent(annotationEditable)) {
			Editable annotation = source.getAnnotation(annotationEditable);
			
			return annotation.value();
		}
		return false;
	}
	
	private static boolean getEditable(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationEditable)) {
			Editable annotation = source.getAnnotation(annotationEditable);
			
			return annotation.value();
		}
		return false;
	}

	private static boolean getSearchable(Class<?> source) {
		if(source.isAnnotationPresent(annotationSearchable)) {
			Searchable annotation = source.getAnnotation(annotationSearchable);
			
			return annotation.value();
		}
		return false;
	}
	
	private static boolean getSearchable(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationSearchable)) {
			Searchable annotation = source.getAnnotation(annotationSearchable);
			
			return annotation.value();
		}
		return false;
	}

	private static List<Stereotype> getStereotypes(Class<?> source) {
		List<Stereotype> stereotypes = new ArrayList<Stereotype>();
		// Is it abstract?
		if(Modifier.isAbstract(source.getModifiers())) {
			stereotypes.add(Stereotype.ABSTRACT);
		}
		// Is it final?
		if(Modifier.isFinal(source.getModifiers())) {
			stereotypes.add(Stereotype.FINAL);
		}
		
		return stereotypes;
	}

	private static org.kongaproject.metadata.definition.enumerations.Access getAccess(
			Class<?> source) {
		if(source.isAnnotationPresent(annotationAccess)) {
			Access annotation = source.getAnnotation(annotationAccess);
			
			return annotation.value();
		}
		return null;
	}
	
	private static org.kongaproject.metadata.definition.enumerations.Access getAccess(
			java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationAccess)) {
			Access annotation = source.getAnnotation(annotationAccess);
			
			return annotation.value();
		}
		return null;
	}

	private static String getLabel(Class<?> source) {
		if(source.isAnnotationPresent(annotationLabel)) {
			Label annotation = source.getAnnotation(annotationLabel);
			
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

	private static String getSuperClass(Class<?> source) {
		if(source.isAnnotationPresent(annotationExtends)) {
			Extends annotation = source.getAnnotation(annotationExtends);
			
			return annotation.value();
		}
		return null;
	}

	private static List<org.kongaproject.metadata.definition.Trigger> getTriggers(
			java.lang.reflect.Field source) {
		List<org.kongaproject.metadata.definition.Trigger> triggers = new ArrayList<org.kongaproject.metadata.definition.Trigger>();
		
		if(source.isAnnotationPresent(annotationTrigger)) {
			org.kongaproject.metadata.definition.Trigger trigger = new org.kongaproject.metadata.definition.Trigger();
			
			Trigger annotation = source.getAnnotation(annotationTrigger);
			
			trigger.setMatch(annotation.match());
			trigger.setMatchType(annotation.matchType());
			trigger.setMoment(annotation.moment());
			trigger.setName(annotation.name());
			trigger.setParameters(Arrays.asList(annotation.parameters()));
			
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
		List<org.kongaproject.metadata.definition.Validator> validators = new ArrayList<org.kongaproject.metadata.definition.Validator>();
		if(source.isAnnotationPresent(annotationValidator)) {
			Validator annotation = source.getAnnotation(annotationValidator);
			org.kongaproject.metadata.definition.Validator validator = new org.kongaproject.metadata.definition.Validator();
			
			validator.setType(annotation.type());
			validator.setValue(annotation.value());
			
			validators.add(validator);
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

	private static org.kongaproject.metadata.definition.SearchConf getSearchConf(
			java.lang.reflect.Field source) {
		org.kongaproject.metadata.definition.SearchConf configuration = new org.kongaproject.metadata.definition.SearchConf();
		
		if(source.isAnnotationPresent(annotationSearchConf)) {
			SearchConf annotation = source.getAnnotation(annotationSearchConf);
			
			// Setup policy
			configuration.setPolicy(annotation.policy());
			
			// Setup multiplicity
			configuration.setMultiplicity(annotation.multiplicity());
			
			// Setup fields
			configuration.setFields(Arrays.asList(annotation.fields()));
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

	private static org.kongaproject.metadata.definition.enumerations.FieldType getFieldType(
			java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationFieldType)) {
			FieldType annotation = source.getAnnotation(annotationFieldType);
			
			return annotation.value();
		}
		return null;
	}

	private static boolean getShowInDetails(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationShowInDetails)) {
			ShowInDetails annotation = source.getAnnotation(annotationShowInDetails);
			
			return annotation.value();
		}
		return false;
	}
	
	private static boolean getShowInResults(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationShowInResults)) {
			ShowInResults annotation = source.getAnnotation(annotationShowInResults);
			
			return annotation.value();
		}
		return false;
	}
	
	private static boolean getShowInUpdate(java.lang.reflect.Field source) {
		if(source.isAnnotationPresent(annotationShowInUpdate)) {
			ShowInUpdate annotation = source.getAnnotation(annotationShowInUpdate);
			
			return annotation.value();
		}
		return false;
	}
}
