package com.skd.basic.kafka.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Describe:
 * @Author:chenfan
 * @Date:2019/4/9 14:10
 */
@Component
public class Consumer {

    @KafkaListener(topics = {"sss","rng"})
    public void processMessage(String message) {
        System.out.println("consume message:" + message);
    }

}
