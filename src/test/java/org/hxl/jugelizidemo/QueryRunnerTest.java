package org.hxl.jugelizidemo;


import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by admin on 2019/6/12.
 */
public class QueryRunnerTest {

    //获取容器
    @Test
    public void testQueryRunner (){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //获取queryrunner对象
        QueryRunner qr = ac.getBean("runner",QueryRunner.class);
        QueryRunner qr1 = ac.getBean("runner",QueryRunner.class);
        System.out.println(qr == qr1);
    }

}
