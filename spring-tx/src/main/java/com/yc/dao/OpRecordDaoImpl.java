package com.yc.dao;

import com.yc.bean.OpRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * program:testspring
 * description:OpRecordDaoImpl
 * author:lsj
 * create:2021-04-17 16:40
 */
@Repository
public class OpRecordDaoImpl implements OpRecordDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveOpRecord(OpRecord opRecord) {
        String sql = "insert into oprecord(accountid,opmoney,optime,optype,transferid) values(?,?,?,?,?）";
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, opRecord.getAccountId());
            ps.setDouble(2, opRecord.getOpmoney());
            ps.setTimestamp(3, opRecord.getOptime());
            ps.setString(4, opRecord.getOptype());
            ps.setString(5, opRecord.getTransferid());
            return ps;
        });
    }

    @Override
    public List<OpRecord> findAll() {
        String sql = "select * from oprecord";
        List<OpRecord> list = this.jdbcTemplate.query(sql, ((resultSet, i) -> {
            OpRecord o = new OpRecord();
            o.setId(resultSet.getInt("id"));
            o.setAccountId(resultSet.getInt("accountid"));
            o.setOpmoney(resultSet.getDouble("opmoney"));
            o.setOptime(resultSet.getTimestamp("optime"));
            o.setOptype(resultSet.getString("optype"));
            o.setTransferid(resultSet.getString("transferid"));
            return o;
        }));
        return list;
    }

    @Override
    public List<OpRecord> findByAccountId(int accountId) {
        String sql = "select * from oprecord where accountid=?";
        List<OpRecord> list = this.jdbcTemplate.query(sql, (resultSet, i) -> {
            OpRecord o = new OpRecord();
            o.setId(resultSet.getInt("id"));
            o.setAccountId(resultSet.getInt("accountid"));
            o.setOpmoney(resultSet.getDouble("opmoney"));
            o.setOptime(resultSet.getTimestamp("optime"));
            o.setOptype(resultSet.getString("optype"));
            o.setTransferid(resultSet.getString("transferid"));
            return o;
        }, accountId);
        return list;
    }
}
