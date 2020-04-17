package com.skd.design.state;

/**
 * @Describe: 睡着的状态
 * @Author: chenfan
 * @Date: 2020/4/16 20:06
 */
public class Sleep implements State {

    @Override
    public void execute(Context context) {
        // 执行自己的行为
        System.out.println("困了，和睡美人去约会");
        // 执行操作后自动改变状态，且知道下一个的应该是什么状态
        context.setState(new Awake());
    }
}
