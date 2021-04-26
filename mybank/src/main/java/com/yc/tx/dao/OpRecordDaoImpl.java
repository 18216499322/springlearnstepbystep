package com.yc.tx.dao;

import com.yc.tx.bean.OpRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @program: testSpring
 * @description:
 * @author: Dasiy
 * @create: 2021-04-17 13:49
 */
@Repository
public class OpRecordDaoImpl implements OpRecordDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOpRecord(OpRecord opRecord) {
        String sql = "insert into oprecord(accountid,opmoney,optime,optype,transferid) values(?,?,?,?,?)";
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, opRecord.getAccountid());
            ps.setDouble(2, opRecord.getOpmoney());
            ps.setTimestamp(3, opRecord.getOptime());
            ps.setString(4, opRecord.getOptype());
            ps.setString(5, opRecord.getTransferid());
            return ps;
        });
    }

    @Override
    public List<OpRecord> findByAccountId(int accountid) {
        String sql = "select * from oprecord where accountid=? ";
        List<OpRecord> list = this.jdbcTemplate.query(
                sql,
                (resultSet, rowNum) -> {
                    OpRecord op = new OpRecord();
                    op.setId(resultSet.getInt("id"));
                    op.setAccountid(resultSet.getInt("accountid"));
                    op.setOpmoney(resultSet.getDouble("opmoney"));
                    op.setOptime(resultSet.getTimestamp("optime"));
                    op.setOptype(resultSet.getString("optype"));
                    op.setTransferid(resultSet.getString("transferid"));
                    return op;
                }, accountid);
        return list;
    }

    @Override
    public List<OpRecord> findAll() {
        String sql = "select * from oprecord";
        List<OpRecord> list = this.jdbcTemplate.query(
                sql,
                (resultSet, rowNum) -> {
                    OpRecord op = new OpRecord();
                    op.setId(resultSet.getInt("id"));
                    op.setAccountid(resultSet.getInt("accountid"));
                    op.setOpmoney(resultSet.getDouble("opmoney"));
                    op.setOptime(resultSet.getTimestamp("optime"));
                    op.setOptype(resultSet.getString("optype"));
                    op.setTransferid(resultSet.getString("transferid"));
                    return op;
                });
        return list;
    }
}
