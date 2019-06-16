package net.practise8.springxmlcrudwithtransaction.service.impl;


import net.practise8.springxmlcrudwithtransaction.dao.AccountDao;
import net.practise8.springxmlcrudwithtransaction.domain.Account;
import net.practise8.springxmlcrudwithtransaction.service.AccountService;
import net.practise8.springxmlcrudwithtransaction.utils.TransactionManager;

import java.util.List;

/**
 * Created by admin on 2019/6/13.
 */
public class AccountServiceImpl implements AccountService {

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private AccountDao accountDao;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    private TransactionManager transactionManager;


    public List<Account> findAllAccount() {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> ret = accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commitTransaction();
            //4.返回结果
            return ret;
        }catch (Exception e){
            //5.回滚操作
            transactionManager.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.release();
        }
    }


    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }


    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName,String desName,Float money){
        try{
            //1.开启事务
            transactionManager.beginTransaction();
                //2.1.户名查找转出账户
                Account source =  accountDao.findAccountByName(sourceName);
                //2.2.户名查找转入账户
                Account des =  accountDao.findAccountByName(desName);
                //2.3.转出账户减钱
                source.setMoney(source.getMoney() - money);
                //2.4.转入账户加钱
                des.setMoney(des.getMoney() + money);
                //2.5.更新转出账户
                accountDao.updateAccount(source);
                int i =  1 / 0;
                //2.6.更新转入账户
                accountDao.updateAccount(des);
            //3.提交事务
            transactionManager.commitTransaction();
        }catch (Exception e){
            transactionManager.rollbackTransaction();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally{
            transactionManager.release();
        }

    }
}
