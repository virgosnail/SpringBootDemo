package com.skd.thread;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2019/10/30 11:47
 */
public class SameThread {

    private SameThread(){
        this.monitor = false;
    }
    private Boolean monitor;

    public static void main(String[] args) {
        SameThread thread = new SameThread();
        try {
            thread.monitor.wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
