package net.practise12.springaopadvicetype.utils;


public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知Logger日志开始记录...");
    }

    /**
     * 后置通知
     */
    public void afterPrintLog(){
        System.out.println("后置通知Logger日志开始记录...");
    }

    /**
     * 异常通知
     */
    public void exceptionPrintLog(){
        System.out.println("异常通知Logger日志开始记录...");
    }

    /**
     * 最终通知
     */
    public void finalPrintLog(){
        System.out.println("最终通知Logger日志开始记录...");
    }

    /**
     * 环绕通知
     * 问题:
     */
    public void aroundPrintLog(){
        System.out.println("环绕通知Logger日志开始记录...");
    }
}
