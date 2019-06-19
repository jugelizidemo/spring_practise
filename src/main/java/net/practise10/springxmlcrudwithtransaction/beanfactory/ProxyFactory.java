package net.practise10.springxmlcrudwithtransaction.beanfactory;

import net.practise10.springxmlcrudwithtransaction.service.AccountService;
import net.practise10.springxmlcrudwithtransaction.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 创建accountService代理对象的工厂类
 */
public class ProxyFactory {

    private AccountService accountService ;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    private TransactionManager transactionManager;

    /**
     * 获取accountService的代理对象
     * @return
     */
    public AccountService getAccountService(){
        AccountService accountServiceProxy =  (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */

                    /*
                    * AOP中的概念:
                    * 1.Joinpoint(连接点):被拦截到的方法
                    * 2.Pointcut(切入点):被拦截到的方法且需要功能增强的方法
                    * 3.Advice(通知/增强):AOP中的通知,整个invoke方法在执行就是环绕通知,invoke方法中有明确的切入点方法调用
                    * 4.Introduction(引介)
                    * 5.Target(目标对象):代理的目标对象
                    * 6.Weaving(织入):把增强应用到目标对象来创建新的代理对象的过程
                    * 7.Proxy(代理):一个类被AOP织入增强后,就产生一个结果代理类
                    * 8.Aspect(切面):切入点和通知的结合
                    * */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object reValue = null;
                        try{
                            //1.开启事务
                            transactionManager.beginTransaction(); //AOP中的前置通知
                            //2.执行操作
                            reValue =  method.invoke(accountService,args);//切入点方法调用
                            //3.提交事务
                            transactionManager.commitTransaction();//AOP中的后置通知
                            //4.返回结果
                            return reValue;
                        }catch (Exception e){
                            //5.回滚操作
                            transactionManager.rollbackTransaction();//AOP中的异常通知
                            throw new RuntimeException(e);
                        }finally {
                            //6.释放资源
                            transactionManager.release();//AOP中的最终通知
                        }
                    }
                });
        return accountServiceProxy;
    }

}
