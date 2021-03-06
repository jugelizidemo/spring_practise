package net.practise5.springxmlcrud.service.impl;

import net.practise5.springxmlcrud.dao.AccountDao;
import net.practise5.springxmlcrud.domain.Account;
import net.practise5.springxmlcrud.service.AccountService;


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
        return accountDao.findAllAccount();
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
}
