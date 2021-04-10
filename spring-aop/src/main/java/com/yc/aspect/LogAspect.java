package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * program:testspring
 * description:logaspect
 * author:lsj
 * create:2021-04-09 20:11
 */
@Aspect
@Component
@Order(1)
public class LogAspect {
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))") // the pointcut expression
    private void add() {
    } // the pointcut signature

    @Pointcut("execution(* com.yc.biz.StudentBizImpl.update*(..))") // the pointcut expression
    private void update() {
    } // the pointcut signature

    @Pointcut("com.yc.aspect.LogAspect.add()||com.yc.aspect.LogAspect.update()")
    private void addAndUpdate() {
    }

    @Before("com.yc.aspect.LogAspect.addAndUpdate()")
    public void log() {
        System.out.println("-----前置增强-------");
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String dateStr = format.format(d);
        System.out.println("当前时间：" + dateStr);
        System.out.println("-----前置增强结束-------");
    }

    @After("com.yc.aspect.LogAspect.addAndUpdate()")
    public void bye() {
        System.out.println("bye");
    }

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public void around(ProceedingJoinPoint point) {
        System.out.println("环饶增强");
        double t1 = System.currentTimeMillis();
        try {
            Object ret = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        double t2 = System.currentTimeMillis();
        System.out.println("时间：" + (t2 - t1));
        System.out.println("环饶增强结束");
    }
}
