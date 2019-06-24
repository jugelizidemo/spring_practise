package net.practise15.springjdbctemplate.ui;

import net.practise15.springjdbctemplate.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class Client4Dao {

    public static void main(String[] args) {


        ApplicationContext ac = new ClassPathXmlApplicationContext("practise15springjdbctemplate.xml");
        AccountService as = ac.getBean("AccountService",AccountService.class);
        System.out.println(as.findAccountById(2));

    }
}
