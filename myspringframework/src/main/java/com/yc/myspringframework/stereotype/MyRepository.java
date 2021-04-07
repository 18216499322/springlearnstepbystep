package com.yc.myspringframework.stereotype;

import java.lang.annotation.*;

/**
 * program:testspring
 * description:component
 * author:lsj
 * create:2021-04-05 14:18
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRepository {
    String value() default "";
}
