package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Raw annotation serves the purpose of configurating the extra parameters of any type, or field. 
 * @author psanchezmarg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Raw {

	/**
	 * Define the key of the parameter
	 * @return
	 */
	String key();
	
	/**
	 * Define the value of the parameter
	 * @return
	 */
	String value();
}
