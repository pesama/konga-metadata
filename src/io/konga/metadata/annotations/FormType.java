package io.konga.metadata.annotations;

import io.konga.metadata.definition.enumerations.FormTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FormType {

	FormTypes search() default FormTypes.CASCADE;
	FormTypes results() default FormTypes.CASCADE;
	FormTypes details() default FormTypes.CASCADE;
	FormTypes update() default FormTypes.CASCADE;
	String template() default "";
}
