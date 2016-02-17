package io.konga.metadata.annotations;

import io.konga.metadata.definition.enumerations.AccessModes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Access {
	AccessModes value();
}
