package com.skd.design.state;

import lombok.Data;

/**
 * @Describe: 执行者，组合了一个状态对象
 * @Author: chenfan
 * @Date: 2020/4/16 20:08
 */
@Data
public class Context {

    private State state;

    public Context(){
        state = new Awake();
    }

    public void run(){
        state.execute(this);
    }
}
