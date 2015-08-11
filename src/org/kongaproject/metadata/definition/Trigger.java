package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.FormModes;
import org.kongaproject.metadata.definition.enumerations.TriggerMatches;
import org.kongaproject.metadata.definition.enumerations.TriggerMoments;
import org.kongaproject.metadata.definition.enumerations.TriggerTypes;
import org.kongaproject.metadata.definition.enumerations.ValidatorTypes;

public class Trigger {
	private String name;
	private TriggerMoments moment;
	private TriggerMatches match;
	private FormModes scope;
	private TriggerTypes type;
	private ValidatorTypes matchType;
	private List<String> parameters;
	private String value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TriggerMoments getMoment() {
		return moment;
	}
	public void setMoment(TriggerMoments moment) {
		this.moment = moment;
	}
	public TriggerMatches getMatch() {
		return match;
	}
	public void setMatch(TriggerMatches match) {
		this.match = match;
	}
	public FormModes getScope() {
		return scope;
	}
	public void setScope(FormModes scope) {
		this.scope = scope;
	}
	public TriggerTypes getType() {
		return type;
	}
	public void setType(TriggerTypes type) {
		this.type = type;
	}
	public ValidatorTypes getMatchType() {
		return matchType;
	}
	public void setMatchType(ValidatorTypes matchType) {
		this.matchType = matchType;
	}
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
