package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.kongaproject.metadata.definition.enumerations.FormStyles;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FormStyle {
	org.kongaproject.metadata.definition.enumerations.FormStyles search() default FormStyles.STANDARD;
	org.kongaproject.metadata.definition.enumerations.FormStyles results() default FormStyles.STANDARD;
	org.kongaproject.metadata.definition.enumerations.FormStyles details() default FormStyles.STANDARD;
	org.kongaproject.metadata.definition.enumerations.FormStyles update() default FormStyles.STANDARD;
}
