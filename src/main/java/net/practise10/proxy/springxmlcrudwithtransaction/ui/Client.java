package net.practise10.proxy.springxmlcrudwithtransaction.ui;


import net.practise10.proxy.springxmlcrudwithtransaction.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("practise10proxyspringxmlcrudwithtransaction.xml");
        AccountService as = (AccountService)ac.getBean("accountServiceProxy");
        as.transfer("aaa","bbb",123f);
    }
}
