package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Define an array of field sets that an entity has defined for its fields
 * @author psanchezmarg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface FieldSets {

	/**
	 * Array of field sets
	 * @return
	 */
	FieldSet[] value();
}
