package net.practise8.springxmlcrudwithtransaction;

import net.practise8.springxmlcrudwithtransaction.domain.Account;
import net.practise8.springxmlcrudwithtransaction.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by admin on 2019/6/16.
 */
public class AccountTest {

    private ApplicationContext ac;
    private AccountService as;

    @Before
    public void init(){
        //1.获取容器
       ac = new ClassPathXmlApplicationContext("practise8springxmlcrudwithtransaction.xml");
        //2.从容器中获取业务层对象
       as = ac.getBean("accountService",AccountService.class);
    }


    @Test
    public void testTransfer() {
        as.transfer("aaa","bbb",100f);
    }


    @Test
    public void testQueryAll() {

        //3.执行方法
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
