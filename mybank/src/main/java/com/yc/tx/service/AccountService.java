package com.yc.tx.service;

import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpRecord;

import java.util.List;

/**
 * @program: testSpring
 * @description:
 * @author: Dasiy
 * @create: 2021-04-17 16:24
 */
public interface AccountService {
    //开户
    public Integer openAccount(Accounts account, double money);

    //存款
    public Accounts deposite(Accounts account, double money, String optype, String transferid);

    //取款
    public Accounts withdraw(Accounts account, double money, String optype, String transferid);

    //转账
    public Accounts transfer(Accounts inAccount, Accounts outAccount, double money);

    //查询余额
    public Accounts showBanlance(Accounts account);

    //查看日志
    public List<OpRecord> findById(Accounts account);
}
