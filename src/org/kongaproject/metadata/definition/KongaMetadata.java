package org.kongaproject.metadata.definition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.kongaproject.metadata.annotations.Action;
import org.kongaproject.metadata.annotations.Actions;
import org.kongaproject.metadata.annotations.ApiPath;
import org.kongaproject.metadata.annotations.Createable;
import org.kongaproject.metadata.annotations.Deleteable;
import org.kongaproject.metadata.annotations.Editable;
import org.kongaproject.metadata.annotations.Entity;
import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.annotations.EntityKey;
import org.kongaproject.metadata.annotations.EntityLabel;
import org.kongaproject.metadata.annotations.Field;
import org.kongaproject.metadata.annotations.FieldType;
import org.kongaproject.metadata.annotations.FormStyle;
import org.kongaproject.metadata.annotations.Hint;
import org.kongaproject.metadata.annotations.Label;
import org.kongaproject.metadata.annotations.Linked;
import org.kongaproject.metadata.annotations.MaxLength;
import org.kongaproject.metadata.annotations.Multiplicity;
import org.kongaproject.metadata.annotations.OverrideDefaults;
import org.kongaproject.metadata.annotations.Priority;
import org.kongaproject.metadata.annotations.Required;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.annotations.ShowInResults;
import org.kongaproject.metadata.annotations.ShowInUpdate;
import org.kongaproject.metadata.annotations.Type;
import org.kongaproject.metadata.definition.enumerations.DataTypes;
import org.kongaproject.metadata.definition.enumerations.FieldTypes;
import org.kongaproject.metadata.definition.enumerations.FormModes;
import org.kongaproject.metadata.definition.enumerations.FormStyles;
import org.kongaproject.metadata.definition.enumerations.Multiplicities;

@Entity("konga-metadata")
@Label("Metadata")
@ApiPath("apps")
@Searchable
@Createable
@Deleteable
@FormStyle(update=FormStyles.HORIZONTAL)
public class KongaMetadata {
	
	@Field
	@EntityId
	@Searchable("SUPER_ADMIN")
	@ShowInResults("SUPER_ADMIN")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	private Integer id;
	
	@Field
	@EntityKey
	@Label("Your app key")
	@ShowInResults
	@ShowInUpdate
	@Linked(to="name", via="app-key-generator")
	private String appKey;
	
	@Field
	@Label("Name")
	@Type(DataTypes.STRING)
	@EntityLabel
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Editable
	@Required
	@MaxLength(40)
	@Priority(1)
	private String name;

	@Field
	@Label("Entities")
	@ShowInUpdate(fields={"id", "name", "access"})
	@Editable
	@Type(value=DataTypes.COMPLEX, complexType="konga-entity")
	@FieldType(value=FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	@OverrideDefaults(
		@Action(overrides="add", name="add-entity-to-metadata")
	)
	@Actions({
		@Action(icon="fa fa-edit", name="edit-entity", label="Edit", scope=FormModes.UPDATE),
		@Action(icon="fa fa-remove", name="remove-entity", label="Remove", scope=FormModes.UPDATE)
	})
	private List<KongaEntity> entities;
	
	@Field
	@Label("Configuration")
	@Hint("Configure your application here")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	@Type(value=DataTypes.COMPLEX, complexType="konga-configuration")
	@FieldType(FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	private List<ConfigurationParam> configuration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<KongaEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<KongaEntity> entities) {
		this.entities = entities;
	}

	public List<ConfigurationParam> getConfiguration() {
		if(this.configuration == null) {
			this.configuration = new ArrayList<ConfigurationParam>();
		}
		return configuration;
	}

	public void setConfiguration(List<ConfigurationParam> configuration) {
		this.configuration = configuration;
	}
	
	// TODO Add other stuff
	public String toJson() {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
