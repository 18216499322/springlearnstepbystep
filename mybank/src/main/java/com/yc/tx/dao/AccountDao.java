package com.yc.tx.dao;

import com.yc.tx.bean.Accounts;

import java.util.List;

/**
 * @program: testSpring
 * @description:
 * @author: Dasiy
 * @create: 2021-04-14 20:54
 */
public interface AccountDao {
    //添加
    public int saveAccount(Accounts account);

    //修改
    public Accounts updateAccount(Accounts account);

    //查找
    public Accounts findAccount(int accountid);

    //查找所有
    public List<Accounts> findAll();

    //删除数据
    public void delete(int accountid);

}
