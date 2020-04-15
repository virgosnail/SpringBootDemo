package com.skd.basic.enums;

/**
 * @Describe: 运算枚举类
 * @Author: chenfan
 * @Date: 2020/4/9 11:18
 */
public enum Operation {

    /**
     * 加法运算
     */
    ADD(){

        @Override
        public double calculate(double x, double y){
            return x + y;
        }
    },
    ;
    public abstract double calculate(double x,double y);
}
