package com.yc.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * program:testspring
 * description:record
 * author:lsj
 * create:2021-04-17 15:05
 */
@Data
public class OpRecord {
    private Integer id;
    private Integer accountId;
    private Double opmoney;
    private Timestamp optime;
    private String optype;
    private String transferid;
}
