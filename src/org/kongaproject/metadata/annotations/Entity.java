package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Define the class as an entity of the common model
 * @author psanchezmarg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {
	
	/**
	 * Name of the entity. If none set, the class name will be used instead
	 * @return
	 */
	String value() default "";
}
