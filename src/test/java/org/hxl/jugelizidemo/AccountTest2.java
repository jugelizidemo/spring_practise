package org.hxl.jugelizidemo;


import config.SpringConfiguration;
import edu.hxl.jugelizidemo.domain.Account;
import edu.hxl.jugelizidemo.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;
/**
 * Created by admin on 2019/6/12.
 */
public class AccountTest2 {

    @Test
    public void testQueryAll() {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

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
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.从容器中获取业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testUpdate() {
        //1.获取容器
 //       ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
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
 //       ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
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
 //       ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.从容器中获取业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        Account account = new Account();
        as.deleteAccount(1);
    }
}
