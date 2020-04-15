package com.skd.basic.thread;

/**
 * @Description: 两个线程轮流执行，单个生产者，单个消费者
 * @Author: virgosnail
 * @Date: 2020/4/12 19:50
 */
public class AlternateExcute {
    public static Object object = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (true) {

                synchronized (object) {
                    object.notify();
                    System.out.println("produce:" + i++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    static class Thread2 extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                synchronized (object) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                    }
                    System.out.println("consumer:" + i++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    object.notify();
                }
            }
        }
    }

}
