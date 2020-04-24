package com.skd.mybatis;

import com.skd.mybatis.controller.TestController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2019/4/10 12:33
 */
/** 扫描 mapper 所在的包 */
@MapperScan("com.skd.mybatis.dao")
@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MybatisApplication.class, args);
    }

}
