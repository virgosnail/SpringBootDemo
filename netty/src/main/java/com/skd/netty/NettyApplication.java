package com.skd.netty;

import com.skd.netty.manager.MsgManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NettyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NettyApplication.class, args);
        MsgManager bean = context.getBean(MsgManager.class);
//        bean.startServer();
        bean.startClient();

    }

}
