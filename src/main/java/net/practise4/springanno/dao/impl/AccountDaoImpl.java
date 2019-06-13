package net.practise4.springanno.dao.impl;

import net.practise4.springanno.dao.AccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


//@Component
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    public void saveAccount(){

        System.out.println("账户保存了");
    }
}
