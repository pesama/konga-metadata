package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.kongaproject.metadata.definition.enumerations.FormModes;
import org.kongaproject.metadata.definition.enumerations.TriggerMatches;
import org.kongaproject.metadata.definition.enumerations.TriggerMoments;
import org.kongaproject.metadata.definition.enumerations.TriggerTypes;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Trigger {
	
	String name();
	
	TriggerMatches match();
	
	TriggerMoments moment() default TriggerMoments.IMMEDIATE;
	
	FormModes[] scope() default FormModes.UPDATE;
	
	TriggerTypes type();
	
	String value();
	
	org.kongaproject.metadata.definition.enumerations.ValidatorTypes
		matchType() 
			default 
				org.kongaproject.metadata.definition.enumerations.ValidatorTypes.EXACT_MATCH;
	
	String[] parameters() default "";
}
