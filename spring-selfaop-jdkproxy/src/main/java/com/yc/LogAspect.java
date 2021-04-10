package com.yc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * program:testspring
 * description:logaspect
 * author:lsj
 * create:2021-04-10 20:21
 */
public class LogAspect implements InvocationHandler {

    private Object o;

    public LogAspect(Object o) {
        this.o = o;
    }

    public Object createProxy() {
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println(proxy.getClass());
        System.out.println(method);
        System.out.println(args);
        if (!method.getName().startsWith("add")) {
            return null;
        }
        log();
        Object retVal = null;
        try {
            retVal = method.invoke(o, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        log();
        return retVal;
    }

    public void log() {
        System.out.println("前置增强");
        System.out.println(new Date());
        System.out.println("前置增强结束");
    }
}
