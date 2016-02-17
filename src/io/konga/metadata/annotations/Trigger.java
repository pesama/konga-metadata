package io.konga.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.konga.metadata.definition.enumerations.FormModes;
import io.konga.metadata.definition.enumerations.TriggerMatches;
import io.konga.metadata.definition.enumerations.ValidatorTypes;
import io.konga.metadata.definition.enumerations.TriggerMoments;
import io.konga.metadata.definition.enumerations.TriggerTypes;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Trigger {
	
	String name();
	
	TriggerMatches match();
	
	TriggerMoments moment() default TriggerMoments.IMMEDIATE;
	
	FormModes[] scope() default FormModes.UPDATE;
	
	TriggerTypes type();
	
	String value();
	
	ValidatorTypes
		matchType() 
			default 
				ValidatorTypes.EXACT_MATCH;
	
	String[] parameters() default "";
}
