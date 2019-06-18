package net.practise9.proxy.ui;


import net.practise9.proxy.Service.ProducerService;
import net.practise9.proxy.Service.impl.ProducerServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 模拟一个消费者者
* */
public class Clinet {

    public static void main(String[] args) {
       final ProducerService producerService = new ProducerServiceImpl();
        /*
        * 动态代理:
        *   特点:字节码随用随创建,随用随加载
        *   作用:不修改源码的基础上对方法功能进行增强
        *   分类:
        *       基于接口的动态代理
        *       基于子类的动态代理
        *   基于接口的动态代理:
        *       涉及的类:Proxy
        *       提供者:JDK官方
        *   如何创建代理对象:
        *       使用Proxy类中的newProxyInstance方法
        *   创建代理对象的要求:
        *       被代理类至少要实现一个接口,如果没有实现接口则不能使用
        *   newProxyInstance方法参数:
        *       ClassLoader:类加载器,用于加载代理对象的字节码,必须和被代理对象使用相同的类加载器(固定写法)
        *       Class[]:字节码数组,使代理对象与被代理对象具有相同的方法(固定写法)
        *       InvocationHandler:用于增强的代码,自己实现如何来代理,一般都是写一个接口的实现类,一般使用匿名内部类,
        *                           此接口的实现类都是谁用谁写的
        *
        * */
        ProducerService proxyProducerService  = (ProducerService) Proxy.newProxyInstance(
                producerService.getClass().getClassLoader(),
                producerService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *作用:执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy:代理后的实例对象引用
                     * @param method:当前执行的方法
                     * @param args:当前执行方法所需的参数
                     * @return:和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //1.提供增强的代码
                        Object obj = null;
                        //2.获取方法执行的参数
                        Float money = (Float)args[0];
                        //3.判断是不是需要增强的方法
                        if("saleProduct".equals(method.getName())){
                            System.out.println("代理商要抽成20%");
                            //System.out.println(proxy.toString());
                            obj =  method.invoke(producerService,money * 0.8f);
                        }
                        return obj;
                    }
                });
        proxyProducerService.saleProduct(1000f);
    }

}

