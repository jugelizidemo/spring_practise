package edu.hxl.jugelizidemo.dao;

import edu.hxl.jugelizidemo.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}