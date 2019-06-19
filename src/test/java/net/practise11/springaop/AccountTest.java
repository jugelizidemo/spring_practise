package net.practise11.springaop;

import net.practise11.springaop.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AccountTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("practise11springaop.xml");
        AccountService as = ac.getBean("accountService",AccountService.class);
        as.saveAccount();
    }

}
