package com.skd.design.strategy;

/**
 * @Describe: 没钱的时候
 * @Author: chenfan
 * @Date: 2020/4/16 20:07
 */
public class Poor implements Strategy {

    @Override
    public void execute() {
        System.out.println("一碗泡面");
    }
}
