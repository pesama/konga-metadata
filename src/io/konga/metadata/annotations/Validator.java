package io.konga.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.konga.metadata.definition.enumerations.ValidatorTypes;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validator {
	
	ValidatorTypes type() default ValidatorTypes.EXACT_MATCH;
	String value();
}
