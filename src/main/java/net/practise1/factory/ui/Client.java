package net.practise1.factory.ui;


import net.practise1.factory.factory.BeanFactory;
import net.practise1.factory.service.AccountService;
import net.practise1.factory.service.impl.AccountServiceImpl;

/*
* 模拟客户端访问
* */
public class Client {

        public static void main(String[] args) throws Exception{

            //1.耦合代码
            //AccountService as = new AccountServiceImpl();
            //2.改造代码,从工厂中拿bean,而不是直接new,IOC思想,削减程序建的耦合
            AccountService as = (AccountService)BeanFactory.getBean("accountService");

            as.saveAccount();
        }
}
