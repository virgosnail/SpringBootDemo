package com.skd.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Describe: 用于获取 application.yml 中的配置参数
 * @Author: chenfan
 * @Date: 2020/4/18 14:54
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "skd.wrap")
public class PropertiesConfig {

    private String prefix;

    private String suffix;
}
