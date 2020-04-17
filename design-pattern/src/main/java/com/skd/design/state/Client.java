package com.skd.design.state;

/**
 * @Describe: 客户端，状态模式
 * @Author: chenfan
 * @Date: 2020/4/16 20:11
 */
public class Client {

    public static void main(String[] args) {

        /**
         *  定义客户端感兴趣的对象和方法: Context.run()
         *  客户端只执行感兴趣的方法 run()
         *  Context 自动改变状态，状态不对客户端暴露
         *  Context 根据不同状态执行不同的行为
         */
        Context context = new Context();
        for (int i=0;i<10;i++){
            context.run();
        }
    }
}
