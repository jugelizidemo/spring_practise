package net.practise14.springxmlcrudtransactionaop.utils;

/**
 * Created by admin on 2019/6/16.
 *
 * 事务管理类,包含了开启事务,提交事务,回滚事务,释放连接
 */
public class TransactionManager {

    public void setConnecitonUtils(ConnecitonUtils connecitonUtils) {
        this.connecitonUtils = connecitonUtils;
    }

    private ConnecitonUtils connecitonUtils;

    /*
    * 开启事务
    * */
    public void beginTransaction(){
        try{
            connecitonUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("开启事务...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
    * 提交事务
    * */
    public void commitTransaction(){
        try{
            connecitonUtils.getThreadConnection().commit();
            System.out.println("提交事务...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    *回滚事务
    * */
    public void rollbackTransaction(){
        try{
            connecitonUtils.getThreadConnection().rollback();
            System.out.println("回滚事务...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    *释放连接
    * */
    public void release(){
        try{
            connecitonUtils.getThreadConnection().close();//close方法时将数据库连接还到连接池中,并不是真的销毁连接
            connecitonUtils.removeConnection();
            System.out.println("释放连接...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
