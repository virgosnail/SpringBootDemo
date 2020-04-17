package com.skd.design.state;

/**
 * @Describe: 玩耍的状态
 * @Author: chenfan
 * @Date: 2020/4/17 11:37
 */
public class Play implements State {

    @Override
    public void execute(Context context) {
        // 执行自己的行为
        System.out.println("开心的玩耍");
        // 执行操作后自动改变状态，且知道下一个的应该是什么状态
        context.setState(new Sleep());
    }
}
