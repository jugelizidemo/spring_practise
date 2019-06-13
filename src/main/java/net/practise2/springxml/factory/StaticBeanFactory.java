package net.practise2.springxml.factory;


import net.practise2.springxml.service.AccountService;
import net.practise2.springxml.service.impl.AccountServiceImpl;

/*
* 模拟一个工厂类,该类在实际应用中可能存在以jar包中,我们无法通过修改源码的方式来提供默认构造函数
* */
public class StaticBeanFactory {

    public static AccountService getAccountServiceStatic(){

        return new AccountServiceImpl();
    }
}
