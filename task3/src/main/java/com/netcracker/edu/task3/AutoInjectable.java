package com.netcracker.edu.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(value= ElementType.FIELD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@interface AutoInjectable
{
    //String injectionClass() default "com.netcracker.edu.task3.SomeImpl";
}
