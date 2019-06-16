package net.practise7.springannocrudwithoutxml.dao;


import net.practise7.springannocrudwithoutxml.domain.Account;

import java.util.List;

/**
 * Created by admin on 2019/6/13.
 */
public interface AccountDao {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
