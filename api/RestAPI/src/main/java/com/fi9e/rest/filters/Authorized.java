package com.fi9e.rest.filters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;
/**
 * Authorization Annotation | is used in AuthorizationFilter Class.
 * 
 * Can be used to bind Filters and interceptors to it.
 * 
 * @author Christopher
 *
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
@NameBinding
public @interface Authorized { }
