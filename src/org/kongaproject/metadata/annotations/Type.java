package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.kongaproject.metadata.definition.enumerations.DataTypes;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Type {

	DataTypes value();
	
	String complexType() default "";
	
	String filter() default "";
	
	Raw[] query() default {};
	
	Raw[] list() default {};
	
	String from() default "";
}
