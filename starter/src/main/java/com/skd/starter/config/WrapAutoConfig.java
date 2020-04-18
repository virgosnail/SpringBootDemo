package com.skd.starter.config;

import com.skd.starter.service.WrapService;
import com.skd.starter.service.impl.WrapServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/18 14:56
 */
@Configuration
@ConditionalOnClass(WrapService.class)
@EnableConfigurationProperties(PropertiesConfig.class)
public class WrapAutoConfig {


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "skd.wrap",value = "enabled",havingValue = "true")
    public WrapService wrapService(){
        return new WrapServiceImpl();
    }
}
