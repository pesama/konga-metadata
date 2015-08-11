package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldType {

	org.kongaproject.metadata.definition.enumerations.FieldTypes search() default org.kongaproject.metadata.definition.enumerations.FieldTypes.PLAIN;
	org.kongaproject.metadata.definition.enumerations.FieldTypes results() default org.kongaproject.metadata.definition.enumerations.FieldTypes.PLAIN;
	org.kongaproject.metadata.definition.enumerations.FieldTypes details() default org.kongaproject.metadata.definition.enumerations.FieldTypes.PLAIN;
	org.kongaproject.metadata.definition.enumerations.FieldTypes update() default org.kongaproject.metadata.definition.enumerations.FieldTypes.PLAIN;
	org.kongaproject.metadata.definition.enumerations.FieldTypes value() default org.kongaproject.metadata.definition.enumerations.FieldTypes.PLAIN;
	
	Configuration[] configuration() default {};
}
