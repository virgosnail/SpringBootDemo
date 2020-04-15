package com.skd.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 */
@MapperScan("com.skd.sharding.dao")
@EnableSwagger2
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ShardingJdbcApplication {

    public static ConfigurableApplicationContext context;
    public static void main(String[] args) {
        context = SpringApplication.run(ShardingJdbcApplication.class, args);
    }

}
