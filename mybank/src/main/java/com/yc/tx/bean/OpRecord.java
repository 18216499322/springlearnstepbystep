package com.yc.tx.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @program: testSpring
 * @description:
 * @author: Dasiy
 * @create: 2021-04-15 20:22
 */
@Data
public class OpRecord {
    private Integer id;
    private Integer accountid;
    private Double opmoney;
    private Timestamp optime;
    private String optype;
    private String transferid;
}
