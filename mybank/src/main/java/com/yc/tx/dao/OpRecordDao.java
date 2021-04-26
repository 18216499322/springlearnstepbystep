package com.yc.tx.dao;


import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpRecord;

import java.util.List;

/**
 * @program: testSpring
 * @description:
 * @author: Dasiy
 * @create: 2021-04-15 20:18
 */
public interface OpRecordDao {
    //添加
    public void saveOpRecord(OpRecord opRecord);

    //查找
    public List<OpRecord> findByAccountId(int accountid);

    //查找所有
    public List<OpRecord> findAll();
}
