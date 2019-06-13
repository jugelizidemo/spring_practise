package net.practise1.factory.service.impl;

import net.practise1.factory.factory.BeanFactory;
import net.practise1.factory.service.AccountService;
import net.practise1.factory.dao.AccountDao;

/*账户业务层实现类*/
public class AccountServiceImpl implements AccountService {

    //1.service依赖Dao层对象的耦合代码
    //private AccountDao accountDao = new AccountDaoImpl();
    //2.改造成从简单bean工厂中获取
    private AccountDao accountDao  = (AccountDao)BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
