package io.konga.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.konga.metadata.definition.enumerations.FormModes;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Configuration {
	
	Raw[] value();
	
	FormModes scope() default FormModes.ALL;
}
