package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.Multiplicity;
import org.kongaproject.metadata.definition.enumerations.ValidatorType;

public class SearchConf {
	private ValidatorType policy;
	private Multiplicity multiplicity;
	private List<String> fields;
	public ValidatorType getPolicy() {
		return policy;
	}
	public void setPolicy(ValidatorType policy) {
		this.policy = policy;
	}
	public Multiplicity getMultiplicity() {
		return multiplicity;
	}
	public void setMultiplicity(Multiplicity multiplicity) {
		this.multiplicity = multiplicity;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	
	
}
