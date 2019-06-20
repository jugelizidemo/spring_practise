package net.practise14.springxmlcrudtransactionaop;


import net.practise14.springxmlcrudtransactionaop.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("practise14springxmlcrudtransactionaop.xml");
        AccountService as = ac.getBean("accountService",AccountService.class);
        as.transfer("aaa","bbb",20000f);
    }

}
