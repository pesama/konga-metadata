# Konga Metadata `konga-project`

## Overview

`konga-metadata` is a metadata definer, generator and storer. It provides enough information about entities and fields to make *Konga* aware about all the data types available for the application, and their full documentation as well. This project configures:

```javascript
metadata: {
	entities: [
		{
			name: 'string', 				// computer-readable name for the entity
			extends: 'string', 				// computer-readable name for the super entity
			label: 'string', 				// placeholder for the human-readable name for the entity
			access: 'enum', 				//  access restriction to the entity (public, restricted, hidden)
			stereotype: 'enum[]', 			// stereotypes for the entity (e.g. abstract, final...)
			searchable: 'boolean', 			// whether the entity could be searchable
			createable: 'boolean', 			// whether new objects of this type could be created
			editable: 'boolean', 			// whether existing entities could be modified
			deleteable: 'boolean', 			// whether existing entities could be deleted
			searchType: 'enum',				// search form to be rendered (e.g. cascade, tabbed...)
			resultsType: 'enum', 			// results form to be rendered (e.g. table, grid...)
			updateType: 'enum', 			// update form to be rendered (e.g. cascade, tabbed...)
			detailsType: 'enum', 			// details form to be rendered (e.g. cascade, tabbed...)
			apiName: 'string', 				// name of the object within the api
			apiPath: 'string', 				// path of the api operations for this entity
			categories: 'string[]', 		// placeholders to the names of the form categories
			access: {						// (Object) access information for the entity type
				permissions: 'string', 			// definition of the permissions for the owner, group, and public.
				roles: [ 						// Array with all roles defined for the entity
					{
						name: 'string', 			// Name of the role
						permission: 'number' 		// permissions for the role
					}
				]
			},
			fields: [ 							// array with all fields for the entity
				{
					name: 'string', 			// computer-readable name for the field
					label: 'string', 			// placeholder for the human-readable name of the field
					type: 'enum', 				// data-type for the field (e.g. string, number, complex...)
					isId: 'boolean', 			// whether the field is the unique db id for the entity
					isKey: 'boolean', 			// whether the field is the human-readable key for the entity
					isLabel: 'boolean', 		// whether the field is the human-readable name for the entity.
					multiplicity: 'enum', 		// multiplicity of the field within the entity (one, many)
					searchable: 'boolean', 		// whether entities of this type would be searched by this field
					editable: 'boolean', 		// whether this field could be modified
					showInResults: 'boolean', 	// whether the field would be shown in the results pane
					showInDetails: 'boolean', 	// whether the field would be shown in the details pane
					showInUpdate: 'boolean', 	// whether the field would be shown in the update pane
					categories: 'string[]', 	// placeholders to the names of the field categories
					apiName: 'string', 			// name of the field within the api (for querying)
					fieldType: 'enum', 			// how the field should be rendered as
					defaults: 'string', 		// default value for the field (inline string)
					searchConf: { 				// search configuration for the entity
						policy: 'enum', 			// format of the search for this object (e.g. exact match, range, wildcards)
						multiplicity: 'enum', 		// multiplicity of the search input (one, many)
					},
					unique: 'boolean', 			// whether the value of this field mustn't be duplicated
					access: {					// (Object) access information for the entity type
						permissions: 'string', 		// definition of the permissions for the owner, group, and public.
						roles: [ 					// Array with all roles defined for the entity
							{
								name: 'string', 		// Name of the role
								permission: 'number' 	// permissions for the role
							}
						]
					},
					validation: {				// validation object definition
						required: 'boolean', 		// whether the field is required for the entity
						minLength: 'number', 		// Minimum length for the input
						maxLength: 'number', 		// Maximum length for the input
						validators: [ 				// array with all validators for the field
							{
								type: 'enum', 			// validator type (e.g. regexp, function...)
								value: 'string' 		// value for the validator
							}
						]
					},
					triggers: [ 				// array with all triggers for the entity changes
						match: 'enum', 				// type of the trigger (e.g. value, length...)
						moment: 'enum', 			// when to launch the trigger (immediate, commit)
						scope: 'enum', 				// the mode of the field (search, update, all)
						type: 'enum', 				// type of the trigger (e.g. alert, confirm)
						matchType: 'enum', 			// Type of the match (e.g. exact-match, regexp...)
						parameters: [ 				// array of parameters for the trigger
							{
								source: 'enum', 		// type of the parameter (e.g. label, $scope, value...)
								type: 'enum', 			// data-type of the parameter
								value: 'string' 		// value of the parameter
							}
						]
					]
				}
			]
		}
	],
	...
}
```

## Metadata definition

### Basic information

Some attributes configure the properties of the object (whether it's an entity or a field) that the metadata is describing. This fields help the UI collect all the information and know how to act with each and every entity and field, when some action is performed.

### Rendering options

The forms and their fields could be configured to be rendered in different ways, depending on their configuration. Every item is configurable with categories that would define tabbing or other layout options, and their rendering type (i.e. `formType` and `fieldType`) will configure how the item must be rendered.

#### Enum formType

| Value    | Description                                                             |
| -------- | ----------------------------------------------------------------------- |
| cascade  | show the form fields inline, without any templating.                    |
| tabbed   | show the form fields in separate tabs, depending on their categories.   |

#### Enum fieldType

| Value    | Field Type    | Accepts      | Input 		                                 |
| -------- | ------------- | ---------    | -------------------------------------------- |
| string   | plain         | string       |  											 |
| number   | plain         | number       | 											 |
| boolean  | radio buttons | boolean      |                                              |
| checkbox | checkboxes    | boolean[]    |                                              |
| date     | date          | date         | 											 |
| select   | plain + modal | complex 1+   | List of possible values                      |
| list     | table + modal | complex many | List of possible values                      |

### Access control

Apart from the `createable`, `editable` and `deleteable` flags (which define the global actions an entity or field supports) there's an access configuration, for every entity and field. 
The format of the access contains two objects:

* `permissions`: Defines the permissions the different entity allows to the users related to it. It's a decimal number composed by the concatenation of the three permissions (i.e. owner, group, public). Each permission is a decimal number result of the parsing of a six-digit binary number, where each digit seems:

| Digit | Attribute | Description 									    |
| ----- | --------- | ------------------------------------------------- |
| 0		| read      | whether the item would be accessed    	        |
| 3     | create    | whether the item would be created     		    |
| 1     | edit      | whether the item would be edited      		    |
| 2     | delete    | whether the item would be deleted     		    |
| 4     | read-all  | whether the item and all subitems could be read   |
| 5     | edit-all  | whether the item and all subitems could be edited |


* `roles`: The roles define custom behaviors for user in posession of such role. Each role definition is an object with a `name` parameter (containing the name of the role) and a `permissions` string, with the same format as for the global permissions attribute.

### Data validation

For validation purposes, several field metadata attributes (i.e. `required`, `minLength` and `maxLength`) define common data formats for the fields. For more complex validations, some *validators* could be defined.

Each validator will have a `type` attribute (which could be regexp, function...), and a `string` value defining the validator format.

### Field configuration

In update mode, fields are rendered as-is. However, fields in search panes could be configured differently so they allow different search policies:

| Policy      | Render Configuration   | Description                                              |
| ----------- | ---------------------- | -------------------------------------------------------- |
| exact-match | One field              | search the exact value                                   |
| range       | Two fields + combo-box | search a range of values (e.g. minor/major, between...)  |
| wildcards   | One field              | search for wildcards (e.g. '*')                          |
| regexp      | One field              | search for regular expressions                           |
| select      | One field + modal      | select from a set of possible values (given in input)    |

### Field triggers

Triggers are event configurations that define actions to be dispatched when the field complies with the given attributes of the trigger.

#### Match

This parameter defines what type of match the trigger uses.

| Code       | Description                                    | Required parameters               |
| ---------- | ---------------------------------------------- | --------------------------------- |
| value      | controls the value of the field                | value to match                    |
| length     | controls the length of the input               | length to match                   |

#### Moment

Triggers could also configure when the event must be dispatched. Possible values are `immediate` (for dispatching in the same moment the trigger match), or `commit` (for dispatching on commit).

#### Scope

Triggers are only executed if the field mode matches the scope of the trigger:

| Scope      | Description                                    | 
| ---------- | ---------------------------------------------- | 
| search     | trigger is dispatched on search forms          | 
| update     | trigger is dispatched on update forms          | 

#### Type

Defines the type of action the trigger must dispatch

| Code       | Description                                    | Required parameters               |
| ---------- | ---------------------------------------------- | --------------------------------- |
| confirm    | displays a confirmation and commits            | title, message, callbacks         |

#### Parameters

Triggers receive arguments that configure further the trigger. Each parameter is defined with a `type` object that define the data type, and a `value` string, which define the value of the parameter. 
**The first parameter that must be provided is the value that dispatches the trigger.**

Furthermore, each parameter define a `source` attribute that defines where's the value coming from

| Source     | Type     | Value definition                                  |
| ---------- | -------- | ------------------------------------------------- |
| label      | string   | the placeholder for a label                       |
| $scope     | string   | the name of a scope property                      |
| inline     | any      | a JavaScript evaluable string                     |
| custom     | string   | the name of a custom function defined on the ui   |

## Object definition

All entities that are part of a *Konga powered* application must provide the information about their entities and fields, that will be asked for by the user interface on application initialization.

`konga-metadata` provides several tools for defining entities and fields, depending on the programming language of the backend, or the preferences of the developer.

### Java Annotations

With Java is really easy to define entities and fields inline, so the same POJOs that contain the data model configure also the metadata, and thus all information will be at the same place.

`konga-java-annotations` provides several annotations available for configuring entities and fields:

| Annotation       | Level  | Parameters       | Description                                         |
| ---------------- | ------ | ---------------- | --------------------------------------------------- |
| *@*Entity        | entity | value            | Define an entity and provide its name               |
| *@*Label         | all    | value            | Define the placeholder for the human-readable name  |
| *@*Searchable    | all    | _none_           | The entity or field would be used for searches      |
| *@*Createable    | entity | _none_           | New entities of this type would be created          |
| *@*Editable      | all    | _none_           | The entity or field would be modified               |
| *@*Deleteable    | entity | _none_           | The entities of this type would be deleted          |
| *@*Access        | all    | value            | Define the visibility (public, restricted, hidden)  |
| *@*FormType      | entity | value            | Define the form type                                |
| *@*Categories    | all    | value[]          | Define the categories of the entity or field        |
| *@*Permissions   | all    | value            | Define the permissions of the entity or field       |
| *@*Role          | all    | name, permission | Define a role name and its permissions              |
| *@*ApiName       | all    | value            | Define the name of the entity or field in the api   |
| *@*ApiPath       | entity | value            | Define the path of the entity in the api            |
| *@*Field         | field  | value            | Define a field and provide its name    			 |
| *@*Multiplicity  | field  | value            | Define the multiplicity of the field (one, many)    |
| *@*ShowInResults | field  | _none_           | The field will be shown in the results pane         |
| *@*ShowInUpdate  | field  | _none_           | The field will be shown in the update pane          |
| *@*ShowInDetails | field  | _none_           | The field will be shown in the details pane         |
| *@*Required      | field  | _none_           | The field is required for the entity                |
| *@*MinLength     | field  | value            | The field's minimum length                          |
| *@*MaxLength     | field  | value            | The field's maximum length                          |
| *@*Validator     | field  | type, value      | Define a new validator for the field                |
| *@*Trigger     | field  | name, match, moment, scope, type, value, matchType | Define a new trigger|
| *@*TriggerParam  | field  | trigger, source, type, value | Define a new trigger param for a trigger|
| *@*Unique        | field  | _none_           | Define the field as unique                          |
| *@*EntityId      | field  | _none_           | The field will be the unique id of the entity       |
| *@*EntityKey     | field  | _none_           | The field will be the human-readable key            |
| *@*EntityLabel   | field  | _none_           | The field will be the entity human-readable name    |
| *@*FieldType     | field  | value            | Define the name of the field type to use            |
| *@*Defaults 	   | field  | value            | Define the default value for the field              |
| *@*SearchConf    | field  | policy, multiplicity | Configures the search for the field 			 |

#### Generator
The annotation framework contains a `KongaGenerator` class that converts the annotated elements in metadata definitions to be sent to the ui.

Example:

```java
KongaMetadata appMetadata = KongaGenerator.readPackage("com.example.project");
```

The returning `KongaMetadata` object will contain information about all the application, and it's ready to be sent to any REST request, in _json_ format.

#### Examples

Below examples offer an overview on the usage of all annotations to define a fully defined metadata description.

##### Parent class:

```java
@Entity("demo-parent")
@Label("message.entities.demo-parent")
@Createable
@Editable
@Access(Access.HIDDEN)
@FormType(FormType.CASCADE)
@Categories({"message.categories.common", "message.categories.example"})
@Permissions("3f3f10")
@Role(name="admin-demo-parent-data", permission="32")
abstract class DemoParent {
	
		@Field("id")
		@EntityId
		@Access(Access.HIDDEN)
		@Permissions("101010")
		private Integer id;

		@Field("key")
		@Label("message.fields.demo-parent.key")
		@EntityKey
		@Editable
		@Searchable
		@ShowInResults
		@ShowInDetails
		@ShowInUpdate
		@Permissions("3f3f3f")
		@Required
		@MinLength(2)
		@MaxLength(5)
		@Unique
		@Validator(type=Validator.REGEXP, value=".")
		@Categories("message.categories.common")
		private String key;

		@Field("name")
		@Label("message.fields.demo-parent.name")
		@EntityLabel
		@Editable
		@Searchable
		@ShowInResults
		@ShowInDetails
		@ShowInUpdate
		@Permissions("3f3f3f")
		@Required
		@MinLength(5)
		@MaxLength(50)
		@Validator(type=Validator.REGEXP, value="([a-z,A-Z]*[0-9]*)*")
		private String name;

		// Getters and setters
		...
}
```

##### Child class

```java
@Entity("demo-child")
@Label("message.entities.demo-child")
@Createable
@Editable
@Deleteable
@Access(Access.PUBLIC)
@FormType(FormType.CASCADE)
@Categories({"message.categories.common", "message.categories.example"})
@Permissions("3f3f10")
@Role(name="view-demo-child", permission="10")
final class DemoChild extends DemoParent {

	@Field("active")
	@Label("message.fields.demo-child.active")
	@Editable
	@Searchable
	@ShowInResults
	@ShowInDetails
	@ShowInUpdate
	@Trigger(name="disable-entity", match="value", matchType=Validator.EXACT_MATCH, moment=Moment.IMMEDIATE, scope=Scope.UPDATE, type=Trigger.value="false")
	@TriggerParam(trigger="disable-entity", source=Trigger.SOURCE_MESSAGE, type=Type.STRING, value="message.triggers.demo-child.disable-entity.title")
	@TriggerParam(trigger="disable-entity", source=Trigger.SOURCE_MESSAGE, type=Type.STRING, value="message.triggers.demo-child.disable-entity.message")
	private boolean active;
	
	// Fields and methods
	...
}
```

##### Another class

```java
@Entity("demo-relationships")
@Label("message.entities.demo-relationships")
@Createable
@Editable
@Deleteable
@Access(Access.PUBLIC)
@FormType(FormType.CASCADE)
@Categories({"message.categories.common", "message.categories.example"})
@Permissions("3f3f10")
@Role(name="view-demo-child", permission="10")
class DemoRelationships {
	
	@Field("demoChild")
	@Label("message.fields.demo-relationships.demo-child")
	@Editable
	@Searchable
	@ShowInResults
	@ShowInDetails
	@ShowInUpdate
	@SearchConf(policy=Validator.EXACT_MATCH, multiplicity=Multiplicity.MANY, fields={"key"})
	@ApiName("codeDemoChild")
	private DemoChild demoChild;

	// Fields and methods
	...
}
```