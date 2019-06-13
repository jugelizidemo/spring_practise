package net.practise2.springxml.ui;

import net.practise2.springxml.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * 模拟客户端访问
 * */
/*ApplicationContext 的三个实现类:
 *		1.ClassPathXmlApplicationContext :加载类路径下的配置文件
 *		2.FileSystemXmlApplicationContext:加载磁盘任意路径下可访问的文件
 *		3.AnnotationConfigApplicationContext:用于读取注解创建的容器
 * 核心容器的两个接口:
 * 	1.ApplicationContext:构建核心容器时,采用立即加载策略,读取配置文件后立即创建对象(推荐使用)
 * 	2.BeanFactory:构建核心容器时,采用延迟加载策略,什么时候根据id获取对象什么时候才真正创建对象
 * */

public class Client {

    /*获取spring的IOC容器,并根据id获取对象*/
    public static void main(String[] args) throws Exception{
        //1.获取核心容器对象
       // ApplicationContext ac = new ClassPathXmlApplicationContext("practise2springxml.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("practise2springxml.xml");
        AccountService as = ac.getBean("accountService",AccountService.class);
        as.saveAccount();
        ac.close();
    }
}