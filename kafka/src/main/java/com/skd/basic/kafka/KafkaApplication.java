package com.skd.basic.kafka;

import com.skd.basic.kafka.demo.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Describe:
 * @Author:chenfan
 * @Date:2019/4/9 14:10
 */
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);
        Producer producer = context.getBean(Producer.class);
        int num = 2;
        for(int i=0; i<num; i++){
            // 发送消息前需要创建 topic123
            producer.sendMessage("rng","mlxgzzz" + i);
        }

    }

}
