package com.skd.kafka.demo;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Describe:
 * @Author:chenfan
 * @Date:2019/4/9 14:10
 */
@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topicName, String message) {
        message = message + " " +new Date().toString();
        try {
            kafkaTemplate.send(topicName, message);
            System.out.println("produce message: "+ message);
        } catch (Exception e) {
            System.out.println("produce message occur a exception:" + e);
        }

        // 消息发送的监听器，用于回调返回信息
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
            @Override
            public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
                System.out.println("send message success, RecordMetadata is :" + recordMetadata);
            }

            @Override
            public void onError(String topic, Integer partition, String key, String value, Exception exception) {
                System.err.println("send message failed :" + exception);
            }

        });
    }

}
