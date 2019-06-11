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
*       @Bean
*           作用:用于把当前方法返回值作为bean对象存入ioc容器中
*               name:用于指定bean的id,也就是ioc容器中的key,默认值是当前的方法名
*           细节:当使用注解配置方法时,如果方法有参数,Spring框架回去ioc容器中查找有没有可用的bean对象
*               查找的方式和Autowired注解的方式一致
*
* */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
@ComponentScan("edu.hxl.jugelizidemo")
public class SpringConfiguration {

/*      <bean id = "runner" class="org.apache.commons.dbutils.QueryRunner" scope="prototype">
            <constructor-arg name = "ds" ref ="dataSource">
            </constructor-arg>
        </bean>
        以上通过xml配置到IOC容器中的的bean,在容器中是与KV的形式存在,key="runner",value = new QueryRunner();
        因此如果通过注解直接得到bean对象的话,只有构造函数还是不够的,构造函数只是解决了Value的问题,key需要用别的方式指定
*/

    /*
    * 创建QueryRunner查询对象
    * */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /*
    * 创建数据源对象
    * */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/hxl");
            ds.setUser("root");
            ds.setPassword("claacgs");
            return ds;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
