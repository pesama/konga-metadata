package org.kongaproject.metadata.definition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class KongaMetadata {
	
	private String name;

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
