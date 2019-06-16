package net.practise7.springannocrudwhithoutxml;

import net.practise7.springannocrudwithoutxml.config.SpringConfiguration;
import net.practise7.springannocrudwithoutxml.domain.Account;
import net.practise7.springannocrudwithoutxml.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

/*
 * Created by admin on 2019/6/16.
 */
public class AccountTest {

    ApplicationContext ac = null;
    AccountService as = null;

    @Before
    public void init(){
        //1.获取容器
         ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.从容器中获取业务层对象
         as = ac.getBean("accountService",AccountService.class);
    }


    @Test
    public void testQueryAll() {

        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testQueryOne() {

        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testUpdate() {

        Account account = new Account();
        account.setId(1);
        account.setName("test");
        account.setMoney(12312f);
        as.updateAccount(account);

    }
    @Test
    public void testSave() {

        Account account = new Account();
        account.setId(1);
        account.setName("testtest");
        account.setMoney(555555f);
        as.saveAccount(account);
    }
    @Test
    public void testDelete() {

        Account account = new Account();
        as.deleteAccount(1);
    }
}
