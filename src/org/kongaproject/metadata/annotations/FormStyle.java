package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FormStyle {
	org.kongaproject.metadata.definition.enumerations.FormStyle search() default org.kongaproject.metadata.definition.enumerations.FormStyle.STANDARD;
	org.kongaproject.metadata.definition.enumerations.FormStyle results() default org.kongaproject.metadata.definition.enumerations.FormStyle.STANDARD;
	org.kongaproject.metadata.definition.enumerations.FormStyle details() default org.kongaproject.metadata.definition.enumerations.FormStyle.STANDARD;
	org.kongaproject.metadata.definition.enumerations.FormStyle update() default org.kongaproject.metadata.definition.enumerations.FormStyle.STANDARD;
}
