# Konga Project (*konga-metadata*)

## Overview

*Konga metadata* is a metadata definer, generator and storer. It provides enough information about entities and fields to make *Konga* aware about all the data types available for the application, and their full documentation as well. This project configures:

```
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
						type: 'enum', 				// type of the trigger (e.g. alert, confirm)
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

## Object definition

### Basic information

Some attributes configure the properties of the object (whether it's an entity or a field) that the metadata is describing. This fields help the UI collect all the information and know how to act with each and every entity and field, when some action is performed.

### Rendering options

The forms and their fields could be configured to be rendered in different ways, depending on their configuration. Every item is configurable with categories that would define tabbing or other layout options, and their rendering type (i.e. `formType` and `fieldType`) will configure how the item must be rendered.

#### Enum formType

* *cascade:* show the form fields inline, without any templating.
* *tabbed:* show the form fields in separate tabs, depending on their categories.

#### Enum fieldType

* *string:* show a plain input, for string values.
* *number:* show a plain input, for numeric values.
* *date:* show a date input.
* *select*: shows an input with a modal for selecting the items. A source list must be provided as input, whose configuration must be set in the field's `configuration` parameter

### Access control

Apart from the `createable`, `editable` and `deleteable` flags (which define the global actions an entity or field supports) there's an access configuration, for every entity and field. 
The format of the access contains two objects:

* `permissions`: Defines the permissions the different entity allows to the users related to it. It's a decimal number composed by the concatenation of the three permissions (i.e. owner, group, public). Each permission is a decimal number result of the parsing of a six-digit binary number, where each digit seems:

| Digit | Attribute | Description 							|
| ----- | --------- | ------------------------------------- |
| 0		| readable  | whether the item would be accessed.   |
| 1     | editable  | whether the item would be edited.     |
| 2     | deletable | whether the item would be deleted.    |


* `roles`: The roles define custom behaviors for user in posession of such role. Each role definition is an object with a `name` parameter (containing the name of the role) and a `permissions` string, with the same format as for the global permissions attribute.

### Data validation

For validation purposes, several field metadata attributes (i.e. `required`, `minLength` and `maxLength`) define common data formats for the fields. For more complex validations, some *validators* could be defined.

Each validator will have a `type` attribute (which could be regexp, function...), and a `string` value defining the validator format.

### Search field configuration

TODO

### Field triggers

TODO