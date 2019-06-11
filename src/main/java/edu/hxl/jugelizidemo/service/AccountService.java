package edu.hxl.jugelizidemo.service;

import edu.hxl.jugelizidemo.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
