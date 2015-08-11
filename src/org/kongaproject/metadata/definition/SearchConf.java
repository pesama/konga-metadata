package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.Multiplicities;
import org.kongaproject.metadata.definition.enumerations.ValidatorTypes;

public class SearchConf {
	private ValidatorTypes policy;
	private Multiplicities multiplicity;
	private List<String> fields;
	public ValidatorTypes getPolicy() {
		return policy;
	}
	public void setPolicy(ValidatorTypes policy) {
		this.policy = policy;
	}
	public Multiplicities getMultiplicity() {
		return multiplicity;
	}
	public void setMultiplicity(Multiplicities multiplicity) {
		this.multiplicity = multiplicity;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	
	
}
