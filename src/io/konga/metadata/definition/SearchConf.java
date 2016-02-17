package io.konga.metadata.definition;

import java.util.List;

import io.konga.metadata.definition.enumerations.ValidatorTypes;
import io.konga.metadata.definition.enumerations.Multiplicities;

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
