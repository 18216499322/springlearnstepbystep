package com.yc;

import com.yc.bean.Helloworld;
import com.yc.myspringframework.stereotype.MyBean;
import com.yc.myspringframework.stereotype.MyComponentScan;
import com.yc.myspringframework.stereotype.MyConfiguration;

/**
 * program:testspring
 * description:appconfig
 * author:lsj
 * create:2021-04-05 14:56
 */
@MyConfiguration
@MyComponentScan(basePackages = {"com.yc.bean"})
public class AppConfig {
    @MyBean
    public Helloworld h1() {
        return new Helloworld();
    }

    @MyBean
    public Helloworld h2() {
        return new Helloworld();
    }
}
