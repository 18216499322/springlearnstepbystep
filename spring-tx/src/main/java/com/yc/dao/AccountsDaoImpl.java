package com.yc.dao;

import com.yc.bean.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * program:testspring
 * description:accountdaoimpl
 * author:lsj
 * create:2021-04-17 14:46
 */
@Repository
public class AccountsDaoImpl implements AccountsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int saveAccount(Accounts account) {
        String sql = "insert into accounts(balance) values(?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"accountid"});
            ps.setDouble(1, account.getBalance());
            return ps;
        }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public Accounts updateAccount(Accounts account) {
        String sql = "update accounts set balance = ? where accountid=?";
        jdbcTemplate.update(sql, account.getBalance(), account.getAccountId());
        return account;
    }

    @Override
    public Accounts findAccount(int accountId) {
        String sql = "select * from accounts where accountid=?";
        return this.jdbcTemplate.queryForObject(sql, ((resultSet, i) -> {
            Accounts a = new Accounts();
            a.setAccountId(resultSet.getInt("accountid"));
            a.setBalance(resultSet.getDouble("balance"));
            return a;
        }));
    }

    @Override
    public List<Accounts> findAll() {
        String sql = "select * from accounts";
        System.out.println(this.jdbcTemplate);
        List<Accounts> list = this.jdbcTemplate.query(sql, ((resultSet, rowNum) -> {
            System.out.println("当前取得是第" + rowNum + "行得数据");
            Accounts a = new Accounts();
            a.setAccountId(resultSet.getInt("accountid"));
            a.setBalance(resultSet.getDouble("balance"));
            return a;
        }));
        return list;
    }

    @Override
    public void delete(int accountId) {
        String sql = "delete from accounts where accountid=?";
        this.jdbcTemplate.update(sql, accountId);
    }
}
