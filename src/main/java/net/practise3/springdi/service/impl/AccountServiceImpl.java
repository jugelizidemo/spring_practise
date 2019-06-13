package net.practise3.springdi.service.impl;

import net.practise3.springdi.dao.AccountDao;
import net.practise3.springdi.dao.impl.AccountDaoImpl;
import net.practise3.springdi.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {

    //1.service依赖Dao层对象的耦合代码
    private AccountDao accountDao = new AccountDaoImpl();

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public AccountServiceImpl(){}

    public AccountServiceImpl(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
