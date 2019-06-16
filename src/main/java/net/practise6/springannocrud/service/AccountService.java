package net.practise6.springannocrud.service;

import net.practise6.springannocrud.domain.Account;

import java.util.List;

/**
 * Created by admin on 2019/6/13.
 */
public interface AccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
