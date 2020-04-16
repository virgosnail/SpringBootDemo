package com.skd.design.strategy;

/**
 * @Describe: 没钱的时候
 * @Author: chenfan
 * @Date: 2020/4/16 20:07
 */
public class Poor implements Strategy {

    @Override
    public void execute() {
        System.out.println("没钱的日子，来一碗泡面");
    }
}
