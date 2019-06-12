package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * Created by admin on 2019/6/12.
 */
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    /*
    * 创建QueryRunner查询对象
    * */
    @Bean(name = "runner")
    @Scope("prototype") //这里使用注解配置spring的IOC容器时,bean是多例的,外部使用一次就创建一次
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
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
