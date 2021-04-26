package com.yc.tx.bean;

/**
 * @program: testSpring
 * @description:
 * @author: Dasiy
 * @create: 2021-04-17 14:13
 */
//枚举类型
public enum OpTypes {

    desposite("deposite", 1), withdraw("withdraw", 2), transfer("transfer", 3);


    //枚举对象中的成员变量
    private String name;
    private int index;

    //构造方法
    OpTypes(String name, int i) {
        this.name = name;
        this.index = index;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.index + "_" + this.name;
    }

    public String getName() {
        return name;
    }
}
