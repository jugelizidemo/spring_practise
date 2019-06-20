package net.practise14.springxmlcrudtransactionaop.service;

import net.practise14.springxmlcrudtransactionaop.domain.Account;

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

    void transfer(String  sourceName,String desName,Float money);
}