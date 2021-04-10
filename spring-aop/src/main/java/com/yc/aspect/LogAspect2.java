package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * program:testspring
 * description:logaspect
 * author:lsj
 * create:2021-04-09 20:11
 */
@Aspect
@Component
@Order(10)
public class LogAspect2 {
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))") // the pointcut expression
    private void add() {
    } // the pointcut signature

    @Pointcut("execution(* com.yc.biz.StudentBizImpl.update*(..))") // the pointcut expression
    private void update() {
    } // the pointcut signature

    @Pointcut("com.yc.aspect.LogAspect2.add()||com.yc.aspect.LogAspect2.update()")
    private void addAndUpdate() {
    }

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public void around(ProceedingJoinPoint point) {
        System.out.println("环饶增强2");
        double t1 = System.currentTimeMillis();
        try {
            Object ret = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        double t2 = System.currentTimeMillis();
        System.out.println("时间：" + (t2 - t1));
        System.out.println("环饶增强结束2");
    }
}
