package com.yc.tx.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * program:testspring
 * description:accountsvo
 * author:lsj
 * create:2021-04-24 20:41
 */
@Data
public class AccountVO implements Serializable {
    private static final long serialVersionUID = -7434767872348659321L;
    private Integer accountId;
    private Double money;
    private Integer inAccountId;
}
