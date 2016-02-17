package io.konga.metadata.definition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.konga.metadata.annotations.Linked;
import io.konga.metadata.definition.enumerations.FieldTypes;
import io.konga.metadata.definition.enumerations.FormModes;
import io.konga.metadata.definition.enumerations.FormStyles;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import io.konga.metadata.annotations.Action;
import io.konga.metadata.annotations.Actions;
import io.konga.metadata.annotations.ApiPath;
import io.konga.metadata.annotations.Categories;
import io.konga.metadata.annotations.Createable;
import io.konga.metadata.annotations.Deleteable;
import io.konga.metadata.annotations.Editable;
import io.konga.metadata.annotations.Entity;
import io.konga.metadata.annotations.EntityId;
import io.konga.metadata.annotations.EntityKey;
import io.konga.metadata.annotations.EntityLabel;
import io.konga.metadata.annotations.Field;
import io.konga.metadata.annotations.FieldType;
import io.konga.metadata.annotations.FormStyle;
import io.konga.metadata.annotations.Hint;
import io.konga.metadata.annotations.Label;
import io.konga.metadata.annotations.MaxLength;
import io.konga.metadata.annotations.Multiplicity;
import io.konga.metadata.annotations.OverrideDefaults;
import io.konga.metadata.annotations.Raw;
import io.konga.metadata.annotations.Required;
import io.konga.metadata.annotations.Searchable;
import io.konga.metadata.annotations.ShowInResults;
import io.konga.metadata.annotations.ShowInUpdate;
import io.konga.metadata.annotations.Type;
import io.konga.metadata.definition.enumerations.DataTypes;
import io.konga.metadata.definition.enumerations.Multiplicities;

@Entity("konga-metadata")
@Label("Metadata")
@ApiPath("apps")
@Searchable
@Createable
@Deleteable
@FormStyle(update= FormStyles.HORIZONTAL)
public class KongaMetadata {
	
	@Field
	@EntityId
	@Searchable("SUPER_ADMIN")
	@ShowInResults("SUPER_ADMIN")
	@ShowInUpdate("SUPER_ADMIN")
	@Editable("SUPER_ADMIN")
	private Integer id;
	
	@Field
	@Label("Name of your app")
	@Type(DataTypes.STRING)
	@EntityLabel
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Editable
	@Required
	@MaxLength(40)
	@Categories("config")
	private String name;
	
	@Field
	@EntityKey
	@Label("Konga's App key")
	@ShowInResults
	@ShowInUpdate
	@Linked(to="name", via="app-key-generator")
	private String appKey;
	
//	@Field
//	@Label("Icon")
//	@ShowInUpdate
//	@Editable
//	@FieldType(FieldTypes.CSS)
	private String icon;

	@Field
	@Label("Entities")
	@ShowInUpdate(
		fields={"id", "name", "access"},
		configuration={
			@Raw(key="hide-when-creating", value="true")
		}
	)
	@Editable
	@Type(value=DataTypes.COMPLEX, complexType="konga-entity")
	@FieldType(value= FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	@OverrideDefaults(
		@Action(overrides="add", name="add-entity-to-metadata")
	)
	@Actions({
		@Action(icon="fa fa-edit", name="edit-entity", label="Edit", scope= FormModes.UPDATE),
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
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
