package com.yc.tx.service;

import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpRecord;
import com.yc.tx.bean.OpTypes;
import com.yc.tx.dao.AccountDao;
import com.yc.tx.dao.OpRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @program: testSpring
 * @description:
 * @author: Dasiy
 * @create: 2021-04-17 16:24
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
        readOnly = false, timeout = 100, rollbackForClassName = {"RuntimeException"})
public class AccounServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private OpRecordDao opRecordDao;

    @Override
    public Integer openAccount(Accounts account, double money) {
        //开户时存一条accounts记录
        account.setBalance(money);
        //添加一条户头数据 返回值为账户id
        int accountid = accountDao.saveAccount(account);
        //开户时的日志
        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(accountid);
        opRecord.setOpmoney(money);
        opRecord.setOptype(OpTypes.desposite.getName());//用枚举做值的约束
        opRecord.setOptime(new Timestamp(System.currentTimeMillis()));
        opRecord.setTransferid(" ");
        opRecordDao.saveOpRecord(opRecord);
        return accountid;

    }

    @Override
    public Accounts deposite(Accounts account, double money, String optype, String transferid) {
        //获取存钱的账户
        Accounts a = this.showBanlance(account);

        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(account.getAccountId());
        opRecord.setOpmoney(money);
        opRecord.setOptype(optype);
        opRecord.setOptime(new Timestamp(System.currentTimeMillis()));
        if (transferid == null) {
            opRecord.setTransferid("  ");
        } else {
            opRecord.setTransferid(transferid);
        }
        //存钱操作日志记录
        opRecordDao.saveOpRecord(opRecord);

        //设置用户余额属性   原有的+存的
        a.setBalance(a.getBalance() + money);
        //更新账户余额
        accountDao.updateAccount(a);
        return a;
    }

    @Override
    public Accounts withdraw(Accounts account, double money, String optype, String transferid) {
        Accounts a = this.showBanlance(account);
        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(a.getAccountId());
        opRecord.setOpmoney(money);
        opRecord.setOptype(optype);
        opRecord.setOptime(new Timestamp(System.currentTimeMillis()));
        if (transferid == null) {
            opRecord.setTransferid("  ");
        } else {
            opRecord.setTransferid(transferid);
        }
        //添加一条新的日志
        opRecordDao.saveOpRecord(opRecord);
        a.setBalance(a.getBalance() - money);
        accountDao.updateAccount(a);
        return a;
    }

    @Override
    public Accounts transfer(Accounts inAccount, Accounts outAccount, double money) {
        String uid = UUID.randomUUID().toString();//转账流水
        this.deposite(inAccount, money, OpTypes.desposite.getName(), uid);
        Accounts newAccounts = this.withdraw(outAccount, money, OpTypes.withdraw.getName(), uid);
        return newAccounts;
    }

    @Override
    @Transactional(readOnly = true)
    public Accounts showBanlance(Accounts account) {

        return accountDao.findAccount(account.getAccountId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OpRecord> findById(Accounts account) {
        return opRecordDao.findByAccountId(account.getAccountId());
    }
}
