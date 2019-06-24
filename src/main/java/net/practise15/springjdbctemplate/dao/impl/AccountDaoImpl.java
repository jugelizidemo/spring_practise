package net.practise15.springjdbctemplate.dao.impl;

import net.practise15.springjdbctemplate.dao.AccountDao;
import net.practise15.springjdbctemplate.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by admin on 2019/6/24.
 */
public class AccountDaoImpl  implements AccountDao {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    public Account findAccountById(Integer Id){

        List<Account> ret  = jdbcTemplate.query("select * from account where id = ?" ,new BeanPropertyRowMapper<Account>(Account.class),Id);

        return ret.isEmpty() ? null : ret.get(0);
    }
}
