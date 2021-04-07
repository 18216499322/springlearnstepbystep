package com.yc.myspringframework.stereotype;

import java.lang.annotation.*;

/**
 * program:testspring
 * description:myconfigration
 * author:lsj
 * create:2021-04-05 14:24
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponent
public @interface MyConfiguration {
    String value() default "";
}
