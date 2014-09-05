# Konga Project

## Konga metadata

*Konga metadata* is a metadata definer, generator and storer. It provides enough information about entities and fields to make *Konga* aware about all the data types available for the application, and their full documentation as well. This project configures:

``
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
			formType: 'enum', 				// form type to be rendered (e.g. cascade, tabbed...)
			apiName: 'string', 				// name of the object within the api
			apiPath: 'string', 				// path of the api operations for this entity
			categories: 'string[]', 		// placeholders to the names of the form categories
											// (Object) access information for the entity type
			access: {						
				permissions: 'string', 			// definition of the permissions for the owner, group, and public.
				roles: [ 						// Array with all roles defined for the entity
					{
						name: 'string', 			// Name of the role
						permission: 'number' 		// permissions for the role
					}
				]
			},
												// array with all fields for the entity
			fields: [ 							
				{
					name: 'string', 			// computer-readable name for the field
					label: 'string', 			// placeholder for the human-readable name of the field
					type: 'enum', 				// data-type for the field (e.g. string, number, complex)
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
												// search configuration for the entity
					searchConf: { 				
						policy: 'enum', 			// format of the search for this object (e.g. exact match, range, wildcards)
						multiplicity: 'enum' 		// multiplicity of the search input (one, many)
					},
					unique: 'boolean', 			// whether the value of this field mustn't be duplicated
												// (Object) access information for the entity type
					access: {					
						permissions: 'string', 		// definition of the permissions for the owner, group, and public.
													// Array with all roles defined for the entity
						roles: [ 					
							{
								name: 'string', 		// Name of the role
								permission: 'number' 	// permissions for the role
							}
						]
					},
												// validation object definition
					validation: {				
						required: 'boolean', 		// whether the field is required for the entity
						minLength: 'number', 		// Minimum length for the input
						maxLength: 'number', 		// Maximum length for the input
													// array with all validators for the field
						validators: [ 				
							{
								type: 'enum', 			// validator type (e.g. regexp, function...)
								value: 'string' 		// value for the validator
							}
						]

					},
												// array with all triggers for the entity changes
					triggers: [ 				
						match: 'enum', 				// type of the trigger (e.g. value, length...)
						moment: 'enum', 			// when to launch the trigger (immediate, commit)
						type: 'enum', 				// type of the trigger (e.g. alert, confirm)
													// array of parameters for the trigger
						parameters: [ 				
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