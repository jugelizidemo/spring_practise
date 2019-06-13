package net.practise3.springdi.dao.impl;

import net.practise3.springdi.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    public void saveAccount(){
        System.out.println("账户保存了");
    }
}
