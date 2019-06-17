package net.practise9.proxy.ui;

import net.practise9.proxy.cglib.impl.ProducerServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class Client4cglib {
    public static void main(String[] args) {
        final ProducerServiceImpl producerService = new ProducerServiceImpl();
        /*
         * 动态代理:
         *   特点:字节码随用随创建,随用随加载
         *   作用:不修改源码的基础上对方法功能进行增强
         *   分类:
         *       基于接口的动态代理
         *       基于子类的动态代理
         *   基于子类的动态代理:
         *       涉及的类:EnHancer
         *       提供者:第三方的cglib库
         *   如何创建代理对象:
         *       使用Enhancer类中的create方法
         *   创建代理对象的要求:
         *       被代理类不能是最终类
         *   create方法参数:
         *       Class:字节码,用于指定被代理对象的字节码
         *       Callback:用于增强的代码,自己实现如何来代理,一般都是写一个接口的实现类,一般使用匿名内部类,
         *                           此接口的实现类都是谁用谁写的,一般写的都是Callback接口子接口MethonIntercepter的实现类
         *
         * */
        ProducerServiceImpl cglibProxyProducerService = (ProducerServiceImpl)Enhancer.create(producerService.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param proxy:代理后的实例对象引用
             * @param method:当前执行的方法
             * @param args:当前执行方法所需的参数
             * @param methodProxy:当前执行方法的代理对象
             * @return:和被代理对象有相同的返回值
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
        cglibProxyProducerService.saleProduct(1200f);
    }
}
