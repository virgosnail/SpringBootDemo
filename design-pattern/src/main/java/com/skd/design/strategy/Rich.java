package com.skd.design.strategy;

/**
 * @Describe: 有钱时候的策略
 * @Author: chenfan
 * @Date: 2020/4/16 20:06
 */
public class Rich implements Strategy {

    @Override
    public void execute() {
        System.out.println("有钱的日子，大口吃肉，大口喝酒");
    }
}
