package org.kongaproject.metadata.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FormType {

	org.kongaproject.metadata.definition.enumerations.FormTypes search() default org.kongaproject.metadata.definition.enumerations.FormTypes.CASCADE;
	org.kongaproject.metadata.definition.enumerations.FormTypes results() default org.kongaproject.metadata.definition.enumerations.FormTypes.CASCADE;
	org.kongaproject.metadata.definition.enumerations.FormTypes details() default org.kongaproject.metadata.definition.enumerations.FormTypes.CASCADE;
	org.kongaproject.metadata.definition.enumerations.FormTypes update() default org.kongaproject.metadata.definition.enumerations.FormTypes.CASCADE;
	String template() default "";
}
