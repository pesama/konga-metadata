package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldType {

	org.kongaproject.metadata.definition.enumerations.FieldType search() default org.kongaproject.metadata.definition.enumerations.FieldType.PLAIN;
	org.kongaproject.metadata.definition.enumerations.FieldType results() default org.kongaproject.metadata.definition.enumerations.FieldType.PLAIN;
	org.kongaproject.metadata.definition.enumerations.FieldType details() default org.kongaproject.metadata.definition.enumerations.FieldType.PLAIN;
	org.kongaproject.metadata.definition.enumerations.FieldType update() default org.kongaproject.metadata.definition.enumerations.FieldType.PLAIN;
	org.kongaproject.metadata.definition.enumerations.FieldType value() default org.kongaproject.metadata.definition.enumerations.FieldType.PLAIN;
	
	Configuration[] configuration() default {};
}
