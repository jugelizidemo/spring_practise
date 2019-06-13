package net.practise4.springanno.service.impl;

import net.practise4.springanno.dao.AccountDao;
import net.practise4.springanno.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;


/*
*	基于XML配置的实现
*  <bean id="accountService" class="net.practise3.springdi.service.impl.AccountServiceImpl"
*  scope = "" init-methon="" destory-methon="">
*  <property name= "" value ="" /ref=""></property>
*  </bean>
*
*	注解:
*	1.用于创建对象的:
*		与xml中<bean>标签功能一致
*		@Component:
*			作用:用于把当前类对象存入spring容器中
*			属性:value属性用于指定bean的id,默认值:当前类名首字母小写
*		@Controller:用在表现层
*		@Service:用在业务层
*		@Repository:用在持久层
*		这三个注解的作用和属性与Component注解的作用完全一致,是Spring框架提供的三层使用注解,使三层对象更加清晰
*
*	2.用于注入数据的:
*		与xml中<bean>标签的<property>标签一致(ioc容器本质就是一个map)
*		@Autowired:
*			作用:自动按照类型注入,只要IOC容器中有唯一的一个bean对象类型和要注入的变量类型匹配,就可以成功注入,可以在变量上,或者方法上,
*				如果ioc容器中没有任何bean的类型和要注入的变量匹配时,报错
*				如果ioc容器中有多个类型匹配时,(当有多个bean都符合注入类型要求时,容器会再根据bean的id与要注入变量的id匹配),这需要@Qualifier
*			细节:在使用注解注入时,set方法就不是必须的
*		@Qualifier:
*			作用:在按照类中注入的基础上再按照名称注入,在给类成员注入时不能单独使用,但是在给方法参数注入时可以
*			属性:value指定注入bean的id
*		@Resource:
*			作用:直接按照bean的id注入,可以独立使用
*			属性:name指定bean的id
*		以上三个注解都只能注入其他bean类型的数据,而基本类型和String类型无法使用上述注解实现
*		另外,集合类型的注入只能通过XML实现
*
*		@Value
*			作用:用于注入基本类型和String类型的数据
*			属性:value:用于指定数据的值,它可以使用Spring的spel(spring的el表达式)spel写法:#{表达式},${表达式}
*
*	3.用于改变作用范围的:
*		与xml中<bean>标签的scope属性一致
*		@Scope
*			作用:用于指定bean的作用范围
*			属性:value指定范围的取值,常用取值:singleton,prototype
*	4.和生命周期相关的
*		与xml中<bean>标签中使用init-methon与init-destory方法一致
*		@PreDestroy:用于指定销毁方法
*		@PostConstruct:用于指定初始化方法
* */

//@Component("accountService")
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier(value = "accountSaveDao")
    /*@Resource(name = "accountSaveDao")*/
    private AccountDao accountDao;

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
