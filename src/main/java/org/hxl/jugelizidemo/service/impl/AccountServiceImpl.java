package org.hxl.jugelizidemo.service.impl;

import org.hxl.jugelizidemo.dao.AccountDao;
import org.hxl.jugelizidemo.domain.Account;
import org.hxl.jugelizidemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* 业务层实现类
* */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier(value = "accountDao")
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
