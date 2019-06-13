package net.practise4.springanno.service.impl;

import net.practise4.springanno.dao.AccountDao;
import net.practise4.springanno.dao.impl.AccountDaoImpl;

import java.util.Date;

public class AccountServiceImpl {

    //1.service依赖Dao层对象的耦合代码
    private AccountDao accountDao = new AccountDaoImpl();

    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private Date birthday;

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public AccountServiceImpl(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
