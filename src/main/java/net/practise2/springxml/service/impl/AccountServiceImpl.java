package net.practise2.springxml.service.impl;

import net.practise2.springxml.dao.AccountDao;
import net.practise2.springxml.dao.impl.AccountDaoImpl;
import net.practise2.springxml.service.AccountService;


public class AccountServiceImpl implements AccountService {

    //1.service依赖Dao层对象的耦合代码
    private AccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了!");
    }

    public void saveAccount() { accountDao.saveAccount();
    }

    public void init() {

        System.out.println("对象初始化了!");
    }

    public void destroy() {

        System.out.println("对象销毁了!");
    }
}
