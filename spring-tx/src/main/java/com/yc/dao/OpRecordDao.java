package com.yc.dao;

import com.yc.bean.OpRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * program:testspring
 * description:oprecorddao
 * author:lsj
 * create:2021-04-17 16:38
 */
@Repository
public interface OpRecordDao {
    public void saveOpRecord(OpRecord opRecord);

    public List<OpRecord> findAll();

    public List<OpRecord> findByAccountId(int accountId);
}
