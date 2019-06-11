package config;

/*
* 该类是一个配置类,作用与bean.xml一样
*
* Spring中的新注解
*
*       @Configuration
*           作用:指定当前类是一个配置类
*       @ComponentScan
*           作用:用于通过注解指定Spirng在创建IOC容器时应该扫描的包路径
*               使用了该注解就等同于在bean.xml中配置了
*               <context:component-scan base-package="org.hxl.jugelizidemo"></context:component-scan>
* */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.hxl.jugelizidemo")
public class SpringConfiguration {
}
