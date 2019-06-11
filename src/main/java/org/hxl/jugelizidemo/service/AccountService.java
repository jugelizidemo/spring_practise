package org.hxl.jugelizidemo.service;


import org.hxl.jugelizidemo.domain.Account;

import java.util.List;

/*
* 账户的业务层接口
* */
public interface AccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
