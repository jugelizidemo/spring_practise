package net.practise15.springjdbctemplate.service;

import net.practise15.springjdbctemplate.domain.Account;

public interface AccountService {

    Account findAccountById(Integer Id);
}
