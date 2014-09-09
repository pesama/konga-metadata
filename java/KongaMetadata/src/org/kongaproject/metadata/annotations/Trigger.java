package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.kongaproject.metadata.definition.enumerations.FormMode;
import org.kongaproject.metadata.definition.enumerations.TriggerMatch;
import org.kongaproject.metadata.definition.enumerations.TriggerMoment;
import org.kongaproject.metadata.definition.enumerations.TriggerType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Trigger {
	
	String name();
	
	TriggerMatch match();
	
	TriggerMoment moment() default TriggerMoment.IMMEDIATE;
	
	FormMode[] scope() default FormMode.UPDATE;
	
	TriggerType type();
	
	String value();
	
	org.kongaproject.metadata.definition.enumerations.ValidatorType
		matchType() 
			default 
				org.kongaproject.metadata.definition.enumerations.ValidatorType.EXACT_MATCH;
	
	String[] parameters() default "";
}
