package com.skd.design.strategy;

/**
 * @Describe: 客户端
 * @Author: chenfan
 * @Date: 2020/4/16 20:11
 */
public class Client {

    public static void main(String[] args) {

        /**
         *  客户端决定什么场景下用什么策略
         *  不同的策略
         *  执行者根据不同的策略产生不同的行为
         */
        Strategy strategy = new Rich();
        Context context = new Context(strategy);
        context.execute();

        strategy = new Poor();
        context = new Context(strategy);
        context.execute();

    }
}
