package com.yc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * program:testspring
 * description:logaspect
 * author:lsj
 * create:2021-04-10 20:21
 */
public class LogAspect implements MethodInterceptor {

    private Object o;

    public LogAspect(Object o) {
        this.o = o;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(o.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public void log() {
        System.out.println("前置增强");
        System.out.println(new Date());
        System.out.println("前置增强结束");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass());
        System.out.println(method);
        System.out.println(args);
        System.out.println(methodProxy);
        if (!method.getName().startsWith("add")) {
            return null;
        }
        log();
        Object retVal = null;
        try {
            retVal = method.invoke(this.o, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        log();
        return retVal;
    }
}
