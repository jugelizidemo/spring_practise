package net.practise14.springxmlcrudtransactionaop.service.impl;

import net.practise14.springxmlcrudtransactionaop.dao.AccountDao;
import net.practise14.springxmlcrudtransactionaop.domain.Account;
import net.practise14.springxmlcrudtransactionaop.service.AccountService;
import net.practise14.springxmlcrudtransactionaop.utils.TransactionManager;


import java.util.List;

public class AccountServiceImpl implements AccountService {
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private AccountDao accountDao;

    public List<Account> findAllAccount() {
        try{
            //2.执行操作
            List<Account> ret = accountDao.findAllAccount();

            return ret;
        }catch (Exception e){

            throw new RuntimeException(e);
        }finally {

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

            System.out.println("转账完成...");

        }catch (Exception e){
            System.out.println("转账失败...");
            throw new RuntimeException(e);
        }
        finally{

        }

    }
}
