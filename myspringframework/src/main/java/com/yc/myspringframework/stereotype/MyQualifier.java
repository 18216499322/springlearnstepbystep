package com.yc.myspringframework.stereotype;

import java.lang.annotation.*;

/**
 * program:testspring
 * description:myqualifier
 * author:lsj
 * create:2021-04-05 14:29
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyQualifier {
    String value() default "";
}
