package net.practise0.noioc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/* 程序的耦合
* 一段非常不ok的代码,演示了程序的耦合
*
*   耦合:类之间的依赖
*       方法间的依赖
*
*   解耦:降低程序建的依赖
*
*   工程开发中应该:编译期不依赖,运行期才依赖
*
*   解耦的思路:1.使用反射来创建对象,避免是有new关键字创建对象
*            2.通过读取配置文件来获取类的全限定类名
*
**/
public class AccountService {

    public static  void main(String[] args) throws Exception{
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //在第一步中:驱动是依赖mysql的jar包,如果工程中缺少了该jar包,name在编译期间就或报错(模块间的高度耦合)
        //第一部改进:此时如果没有jar包是,编译期不会报错,runtime时才会报错.
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hxl","root","claacgs");
        //3.获取操作数据库的预处理对象
        PreparedStatement ps = conn.prepareStatement("select * from account");
        //4.执行sql,获取结果集
        ResultSet rs = ps.executeQuery();
        //5.遍历结果接
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
