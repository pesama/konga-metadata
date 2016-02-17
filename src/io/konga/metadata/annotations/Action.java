package io.konga.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.konga.metadata.definition.enumerations.FormModes;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface Action {
	String name();
	FormModes scope() default FormModes.ALL;
	String label() default "";
	String icon() default "";
	String overrides() default "";
}
