package com.yc.tx.dao;

import com.yc.tx.bean.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @program: testSpring
 * @description:
 * @author: Dasiy
 * @create: 2021-04-14 20:57
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int saveAccount(final Accounts account) {
        final String sql = "insert into accounts(balance) values (  ?  );";
        KeyHolder keyHolder = new GeneratedKeyHolder();//生成键的保存器
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setDouble(1, account.getBalance());
            return ps;
        }, keyHolder);
        //匿名内部类方法
//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement pstme=connection.prepareStatement(sql,new String[]{"accountid"});//设置参数  accountid为连接数据库后获取的键值对的键名
//                pstme.setDouble(1,account.getBalance());
//                return pstme;
//            }
//        },keyHolder);
        return Integer.parseInt(String.valueOf(keyHolder.getKey()));
    }

    @Override
    public Accounts updateAccount(Accounts account) {
        String sql = "update accounts set balance=? where accountid =?";
        this.jdbcTemplate.update(sql, account.getBalance(), account.getAccountId());
        return account;
    }

    @Override
    public Accounts findAccount(int accountid) {
        String sql = "select * from accounts where accountid=? ";
        return this.jdbcTemplate.queryForObject(
                sql,
                (resultSet, rowNum) -> {
                    Accounts ac = new Accounts();
                    ac.setAccountId(resultSet.getInt("accountid"));
                    ac.setBalance(resultSet.getDouble("balance"));
                    return ac;
                },
                accountid);
    }

    @Override
    public List<Accounts> findAll() {
        String sql = "select * from accounts";
        List<Accounts> list = this.jdbcTemplate.query(
                sql,
                (resultSet, rowNum) -> {
                    Accounts a = new Accounts();
                    a.setAccountId(resultSet.getInt("accountid"));
                    a.setBalance(resultSet.getDouble("balance"));
                    return a;
                });
//        List<Accounts> list =this.jdbcTemplate.query(sql, new RowMapper<Accounts>() {
//            @Override
//            public Accounts mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//                System.out.println("当前取的是"+rowNum+"的数据");
//                Accounts a=new Accounts();
//                a.setAccountId(resultSet.getInt("accountid"));
//                a.setBalance(resultSet.getDouble("balance"));
//                return a;
//            }
//        });
        return list;
    }

    @Override
    public void delete(int accountid) {
        String sql = "delete from accounts where accountid=? ";
        this.jdbcTemplate.update(sql, accountid);
    }
}
