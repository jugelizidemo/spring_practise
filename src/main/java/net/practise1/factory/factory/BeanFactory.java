package net.practise1.factory.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
* 创建Bean对象的工厂
* 创建可重用的组件
*
* 创建javaBean的步骤:
* 1.需要一个配置文件配置javaBean
*   配置文件内容:唯一标识符 = 全限定类名(key=value)
* 2.通过读取配置文件通过反射来创建对象
*
* 本例中使用properties文件作为配置文件
* */
public class BeanFactory {

    //定义静态配置文件对象
    private static Properties props ;

    //实现单例对象时,必须在工厂的内部维护好一个容器对象存放创建的bean对象

    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象复制(类加载初始化时就会执行静态代码块)
    static{
        try{
            props = new Properties();
            //获取Properties配置文件的流对象
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("practise1factory.properties");
            props.load(is);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object obj = Class.forName(beanPath).newInstance();
                //将key与value存入容器
                beans.put(key,obj);
            }

        }catch(Exception e){
            throw new ExceptionInInitializerError("初始化配置文件错误!");
        }

    }

/*
* 根据bean的key获取bean对象
*
* */
    public static Object getBean(String beanName) {
       /* Object bean = null;
        String beanPath = props.getProperty(beanName);
        try{
            bean = Class.forName(beanPath).newInstance();//调用默认构造函数创建对象
        }catch (Exception e){
           e.printStackTrace();
        }
        return bean;*/
       //单例模式下获取bean对象
       return beans.get(beanName);
    }
}
