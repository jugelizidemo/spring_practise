package net.practise12.springaopadvicetype;

import net.practise12.springaopadvicetype.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AccountTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("practise12springaopadvicetype.xml");
        AccountService as = ac.getBean("accountService",AccountService.class);
        as.saveAccount();
       // as.updateAccount(1000);
       // as.deleteAccount();
    }

}
