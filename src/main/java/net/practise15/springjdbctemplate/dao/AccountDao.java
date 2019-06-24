package net.practise15.springjdbctemplate.dao;

import net.practise15.springjdbctemplate.domain.Account;

/**
 * Created by admin on 2019/6/24.
 */
public interface AccountDao {

    Account findAccountById(Integer Id);
}
