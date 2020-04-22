package com.skd.netty;

import com.skd.netty.manager.MegManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NettyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NettyApplication.class, args);
        MegManager bean = context.getBean(MegManager.class);
//        bean.startServer();
        bean.startClient();

    }

}
