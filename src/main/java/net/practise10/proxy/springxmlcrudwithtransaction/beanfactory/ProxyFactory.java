package net.practise10.proxy.springxmlcrudwithtransaction.beanfactory;

import net.practise10.proxy.springxmlcrudwithtransaction.service.AccountService;
import net.practise10.proxy.springxmlcrudwithtransaction.utils.TransactionManager;

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
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object reValue = null;
                        try{
                            //1.开启事务
                            transactionManager.beginTransaction();
                            //2.执行操作
                            reValue =  method.invoke(accountService,args);
                            //3.提交事务
                            transactionManager.commitTransaction();
                            //4.返回结果
                            return reValue;
                        }catch (Exception e){
                            //5.回滚操作
                            transactionManager.rollbackTransaction();
                            throw new RuntimeException(e);
                        }finally {
                            //6.释放资源
                            transactionManager.release();
                        }
                    }
                });
        return accountServiceProxy;
    }

}
