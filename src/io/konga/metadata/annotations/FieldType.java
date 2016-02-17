package io.konga.metadata.annotations;

import io.konga.metadata.definition.enumerations.FieldTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldType {

	FieldTypes search() default FieldTypes.UNDEFINED;
	FieldTypes results() default FieldTypes.UNDEFINED;
	FieldTypes details() default FieldTypes.UNDEFINED;
	FieldTypes update() default FieldTypes.UNDEFINED;
	FieldTypes value() default FieldTypes.UNDEFINED;
	
	Configuration[] configuration() default {};
}
