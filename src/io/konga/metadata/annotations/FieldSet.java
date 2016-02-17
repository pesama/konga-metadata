package io.konga.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Define a field set for grouping several fields
 * @author psanchezmarg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface FieldSet {

	/**
	 * Name of the field set
	 * @return
	 */
	String value();
	
	/**
	 * Configuration parameters for the field set
	 * @return
	 */
	Raw[] configuration() default {};
	
	// TODO Add other stuff
}
