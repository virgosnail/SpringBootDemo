package com.skd.design.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Describe: 执行者，组合了一个策略对象
 * @Author: chenfan
 * @Date: 2020/4/16 20:08
 */
@Data
@AllArgsConstructor
public class Context {

    private Strategy strategy;

    public void run(){
        strategy.execute();
    }
}
