package org.kongaproject.metadata.definition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.kongaproject.metadata.annotations.ApiPath;
import org.kongaproject.metadata.annotations.Createable;
import org.kongaproject.metadata.annotations.Deleteable;
import org.kongaproject.metadata.annotations.Editable;
import org.kongaproject.metadata.annotations.Entity;
import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.annotations.EntityKey;
import org.kongaproject.metadata.annotations.Field;
import org.kongaproject.metadata.annotations.FieldType;
import org.kongaproject.metadata.annotations.FormStyle;
import org.kongaproject.metadata.annotations.Label;
import org.kongaproject.metadata.annotations.MaxLength;
import org.kongaproject.metadata.annotations.Multiplicity;
import org.kongaproject.metadata.annotations.Required;
import org.kongaproject.metadata.annotations.Searchable;
import org.kongaproject.metadata.annotations.ShowInResults;
import org.kongaproject.metadata.annotations.ShowInUpdate;
import org.kongaproject.metadata.annotations.Type;
import org.kongaproject.metadata.definition.enumerations.DataTypes;
import org.kongaproject.metadata.definition.enumerations.FieldTypes;
import org.kongaproject.metadata.definition.enumerations.FormStyles;
import org.kongaproject.metadata.definition.enumerations.Multiplicities;

@Entity("konga-application")
@Label("Konga App")
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
	@Label("Name")
	@Type(DataTypes.STRING)
	@EntityKey
	@Searchable
	@ShowInResults
	@ShowInUpdate
	@Editable
	@Required
	@MaxLength(40)
	private String name;

	@Field
	@Label("Entities")
	@ShowInUpdate
	@Editable
	@Type(value=DataTypes.COMPLEX, complexType="konga-entity")
	@FieldType(FieldTypes.PICK_LIST)
	@Multiplicity(Multiplicities.MANY)
	private List<KongaEntity> entities;
	
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
