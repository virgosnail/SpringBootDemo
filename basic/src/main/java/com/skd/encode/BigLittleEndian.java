package com.skd.encode;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2019/10/30 18:15
 */
public class BigLittleEndian {

    public static void main(String[] args) {
//        short ssrc = 123;
//        System.out.println(Integer.toBinaryString(ssrc));
//        System.out.println(Integer.toBinaryString((ssrc & 0xFF) << 8));
//        System.out.println(Integer.toBinaryString((ssrc & 0xFF00) >> 8));
//        System.out.println(Integer.toBinaryString( ((ssrc & 0xFF) << 8) | ((ssrc & 0xFF00) >> 8)));
//        System.out.println(0xFF);
        System.out.println((3072 >> 8) & 0xFF );
        System.out.println();
    }
}
