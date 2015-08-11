package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.kongaproject.metadata.definition.enumerations.ValidatorTypes;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchConf {

	ValidatorTypes policy();
	
	org.kongaproject.metadata.definition.enumerations.Multiplicities multiplicity();
	
	String[] fields() default "";
}
