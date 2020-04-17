package com.skd.design.strategy;

/**
 * @Describe: 客户端，策略模式
 * @Author: chenfan
 * @Date: 2020/4/16 20:11
 */
public class Client {

    public static void main(String[] args) {

        /**
         *  客户端决定什么场景下用什么策略
         *  执行者根据不同的策略执行不同的行为，完成相同的工作
         */
        Strategy strategy = new Rich();
        Context context = new Context(strategy);
        context.run();

        strategy = new Poor();
        context = new Context(strategy);
        context.run();

    }
}
