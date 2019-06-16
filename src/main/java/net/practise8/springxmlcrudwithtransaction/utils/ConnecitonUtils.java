package net.practise8.springxmlcrudwithtransaction.utils;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接工具类,用于从数据源中获取连接,并且实现和线程的绑定
 * Created by admin on 2019/6/16.
 */
public class ConnecitonUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private DataSource dataSource;

    /*
    获取当前线程上的连接
    * */
    public Connection getThreadConnection(){
        //先从线程上获取
        try{
            Connection conn = tl.get();
            if (conn == null) {
                //从数据源中获取一个连接,并且存入tl
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /*
    * 将线程与连接解绑
    * 将连接从threadlocal容器中移除,这样当前线程下次如果在获取连接时就会重新从连接池中获取新的连接
    * 原因在于threadlocal容器中的连接在处理完事务后,会调用close()方法,该方法会将连接重新放回连接池中
    * 后续新的事务如果再获取threadlocal中的连接时,连接是存在的,但是已经处于close()状态
    * */
    public void removeConnection(){
        tl.remove();
    }
}


