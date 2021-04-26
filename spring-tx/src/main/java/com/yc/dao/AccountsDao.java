package com.yc.dao;

import com.yc.bean.Accounts;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * program:testspring
 * description:accountsdao
 * author:lsj
 * create:2021-04-17 14:44
 */
@Repository
public interface AccountsDao {
    public int saveAccount(Accounts account);

    public Accounts updateAccount(Accounts account);

    public Accounts findAccount(int accountId);

    public List<Accounts> findAll();

    public void delete(int accountId);
}
