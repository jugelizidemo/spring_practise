package net.practise15.springjdbctemplate.service.impl;

import net.practise15.springjdbctemplate.dao.AccountDao;
import net.practise15.springjdbctemplate.domain.Account;
import net.practise15.springjdbctemplate.service.AccountService;

public class AccountServiceImpl implements AccountService {

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private AccountDao accountDao;

    public Account findAccountById(Integer Id){
       return  accountDao.findAccountById(Id);
    }
}
