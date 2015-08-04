package org.kongaproject.metadata.definition;

import java.util.List;

import org.kongaproject.metadata.definition.enumerations.FormMode;
import org.kongaproject.metadata.definition.enumerations.TriggerMatch;
import org.kongaproject.metadata.definition.enumerations.TriggerMoment;
import org.kongaproject.metadata.definition.enumerations.TriggerType;
import org.kongaproject.metadata.definition.enumerations.ValidatorType;

public class Trigger {
	private String name;
	private TriggerMoment moment;
	private TriggerMatch match;
	private FormMode scope;
	private TriggerType type;
	private ValidatorType matchType;
	private List<String> parameters;
	private String value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TriggerMoment getMoment() {
		return moment;
	}
	public void setMoment(TriggerMoment moment) {
		this.moment = moment;
	}
	public TriggerMatch getMatch() {
		return match;
	}
	public void setMatch(TriggerMatch match) {
		this.match = match;
	}
	public FormMode getScope() {
		return scope;
	}
	public void setScope(FormMode scope) {
		this.scope = scope;
	}
	public TriggerType getType() {
		return type;
	}
	public void setType(TriggerType type) {
		this.type = type;
	}
	public ValidatorType getMatchType() {
		return matchType;
	}
	public void setMatchType(ValidatorType matchType) {
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
