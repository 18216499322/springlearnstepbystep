package com.yc.bean;

/**
 * program:testspring
 * description:optypes
 * author:lsj
 * create:2021-04-17 15:06
 */
public enum OpTypes {
    deposite("deposite", 1), withdraw("withdraw", 2), transfer("transfer", 3);

    private String name;
    private int index;

    @Override
    public String toString() {
        return "OpTypes{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

    private OpTypes(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return this.name;
    }
}
