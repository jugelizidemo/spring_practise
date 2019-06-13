package net.practise3.springdi.ui;

import net.practise3.springdi.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /*获取spring的IOC容器,并根据id获取对象*/
    public static void main(String[] args) throws Exception{
        //1.获取核心容器对象
         ApplicationContext ac = new ClassPathXmlApplicationContext("practise3springdi.xml");
        AccountService as = ac.getBean("accountService",AccountService.class);
        as.saveAccount();
        System.out.println(as);
    }
}
