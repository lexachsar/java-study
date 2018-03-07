package com.lexach.NetCracker.Reflection.ReflectionHomework;

import com.sun.xml.internal.bind.v2.runtime.output.NamespaceContextImpl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyFirstAnnotation {
    String message();
    int value();
}
