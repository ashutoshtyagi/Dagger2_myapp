package com.example.ashutosh.dagger2_myapp.Annotations;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ashutosh on 8/1/16.
 */
@Scope
@Retention(RUNTIME) public @interface PerActivity {}
