package net.practise13.springannoaop.service.impl;

import net.practise13.springannoaop.service.AccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    public void saveAccount() {

        System.out.println("保存账户...");
        //int i = 1/0;
    }

    public void updateAccount(Integer money) {
        System.out.println("更新账户..." + money);
    }

    public void deleteAccount() {
        System.out.println("删除账户...");
    }
}
