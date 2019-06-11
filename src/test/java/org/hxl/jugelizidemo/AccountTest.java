package org.hxl.jugelizidemo;

import org.hxl.jugelizidemo.domain.Account;
import org.hxl.jugelizidemo.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/*
* 使用juint单元测试
* */
public class AccountTest {
    @Test
    public void testQueryAll() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.从容器中获取业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        //3.执行方法
       List<Account> accounts = as.findAllAccount();
       for (Account account : accounts){
           System.out.println(account);
       }
    }
    @Test
    public void testQueryOne() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.从容器中获取业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testUpdate() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.从容器中获取业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        Account account = new Account();
        account.setId(1);
        account.setName("test");
        account.setMoney(12312f);
        as.updateAccount(account);

    }
    @Test
    public void testSave() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.从容器中获取业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        Account account = new Account();
        account.setId(1);
        account.setName("testtest");
        account.setMoney(555555f);
        as.saveAccount(account);
    }
    @Test
    public void testDelete() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.从容器中获取业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        Account account = new Account();
        as.deleteAccount(1);
    }
}
