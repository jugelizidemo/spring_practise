package net.practise15.springjdbctemplate.ui;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class Client {

    public static void main(String[] args) {
        //spring内置的数据源
        /*DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/hxl");
        ds.setUser("root");
        ds.setPassword("claacgs");

        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money)values('hhh',2000000)");*/

        ApplicationContext ac = new ClassPathXmlApplicationContext("practise15springjdbctemplate.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        jt.execute("insert into account(name,money)values('hhh',2000000)");
    }
}
