package com.yc.tx.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * program:testspring
 * description:resultvo
 * author:lsj
 * create:2021-04-24 20:43
 */
@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = -4105391755304647796L;
    private Integer code;
    private T data;
    private String message;
}
