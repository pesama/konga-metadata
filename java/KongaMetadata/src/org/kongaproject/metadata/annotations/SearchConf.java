package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.kongaproject.metadata.definition.enumerations.ValidatorType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchConf {

	ValidatorType policy();
	
	org.kongaproject.metadata.definition.enumerations.Multiplicity multiplicity();
	
	String[] fields() default "";
}
