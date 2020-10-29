package com.cy.db.common.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredCache {
    String name() default "";//这个名字对应这个存储数据的cache对象
    String key() default "";//这个名字对应着cache中存储的数据
//    ...
}
