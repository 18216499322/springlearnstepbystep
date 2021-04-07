package com.yc.myspringframework.stereotype;

import java.lang.annotation.*;

/**
 * program:testspring
 * description:MyComponentScan
 * author:lsj
 * create:2021-04-05 14:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface MyComponentScan {
    String[] basePackages() default {};
}
