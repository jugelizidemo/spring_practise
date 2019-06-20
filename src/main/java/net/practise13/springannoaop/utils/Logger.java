package net.practise13.springannoaop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* net.practise13.springannoaop.service.impl.*.*(..))")
    private void pt(){};
    /**
     * 前置通知
     */
   /* @Before("pt()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger日志开始记录...");
    }

    *//**
     * 后置通知
     *//*
    @AfterReturning("pt()")
    public void afterPrintLog(){
        System.out.println("后置通知Logger日志开始记录...");
    }

    *//**
     * 异常通知
     *//*
    @AfterThrowing("pt()")
    public void exceptionPrintLog(){
        System.out.println("异常通知Logger日志开始记录...");
    }

    *//**
     * 最终通知
     *//*
    @After("pt()")
    public void finalPrintLog(){
        System.out.println("最终通知Logger日志开始记录...");
    }*/

    /**
     * 环绕通知
     * 问题:当配置了环绕通知后,切入点方法没有执行,但通知方法执行了
     * 分析:通过对比了动态代理中的环绕通知代码,在动态代理中有明确的切入点方法调用,而当前的代码中没有(疑问)
     * 解决:spring框架为我们提供了接口,ProceedingJoinPoint.该接口有一个方法proceed(),此方法相当于明确
     *      切入点方法,该接口可以作为环绕通知的方法参数,在程序执行时spring框架会提供该接口的实现类供我们使用
     *
     */
    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint pjg){
        Object rtValue = null;
        try{
            Object[] args = pjg.getArgs();
            System.out.println("环绕通知Logger日志开始记录...前置advice");
            rtValue = pjg.proceed(args);
            System.out.println("环绕通知Logger日志开始记录...后置advice");
            return rtValue;
        }catch (Throwable t){
            System.out.println("环绕通知Logger日志开始记录...异常advice");
            throw  new RuntimeException(t);
        }finally {
            System.out.println("环绕通知Logger日志开始记录...最终advice");
        }
    }
}

