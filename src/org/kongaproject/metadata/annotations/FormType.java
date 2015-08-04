package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FormType {

	org.kongaproject.metadata.definition.enumerations.FormType search() default org.kongaproject.metadata.definition.enumerations.FormType.CASCADE;
	org.kongaproject.metadata.definition.enumerations.FormType results() default org.kongaproject.metadata.definition.enumerations.FormType.CASCADE;
	org.kongaproject.metadata.definition.enumerations.FormType details() default org.kongaproject.metadata.definition.enumerations.FormType.CASCADE;
	org.kongaproject.metadata.definition.enumerations.FormType update() default org.kongaproject.metadata.definition.enumerations.FormType.CASCADE;
	String template() default "";
}
