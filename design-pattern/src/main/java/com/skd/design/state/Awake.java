package com.skd.design.state;

/**
 * @Describe: 醒来的状态
 * @Author: chenfan
 * @Date: 2020/4/16 20:07
 */
public class Awake implements State {

    @Override
    public void execute(Context context) {
        // 执行自己的行为
        System.out.println("清醒了，元气满满");
        // 执行操作后自动改变状态，且知道下一个的应该是什么状态
        context.setState(new Play());
    }
}
