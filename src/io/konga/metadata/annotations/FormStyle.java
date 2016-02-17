package io.konga.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.konga.metadata.definition.enumerations.FormStyles;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FormStyle {
	FormStyles search() default FormStyles.STANDARD;
	FormStyles results() default FormStyles.STANDARD;
	FormStyles details() default FormStyles.STANDARD;
	FormStyles update() default FormStyles.STANDARD;
}
