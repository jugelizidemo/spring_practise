package net.practise10.proxy.springxmlcrudwithtransaction.service.impl;


import net.practise10.proxy.springxmlcrudwithtransaction.dao.AccountDao;
import net.practise10.proxy.springxmlcrudwithtransaction.domain.Account;
import net.practise10.proxy.springxmlcrudwithtransaction.service.AccountService;

import java.util.List;

/**
 * Created by admin on 2019/6/13.
 */
public class AccountServiceImpl implements AccountService {

    public void setAccountDao(AccountDao accountDao) {

        this.accountDao = accountDao;
    }

    private AccountDao accountDao;

    public List<Account> findAllAccount() {
        return  accountDao.findAllAccount();
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
        System.out.println("转账开始...");
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
        System.out.println("转账结束...");

    }
}
