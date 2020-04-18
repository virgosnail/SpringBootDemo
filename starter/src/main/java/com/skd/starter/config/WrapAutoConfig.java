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
 * 需要在META-INF/spring.factories中配置该类的完全限定名
 * @Describe: 自动配置类
 * @Author: chenfan
 * @Date: 2020/4/18 14:56
 */
@Configuration
/**
 * 当classpath下发现WrapService类时进行自动配置
 */
@ConditionalOnClass(WrapService.class)
@EnableConfigurationProperties(PropertiesConfig.class)
public class WrapAutoConfig {


    @Bean
    /**
     * 当Spring Context中不存在该bean时创建bean
     */
    @ConditionalOnMissingBean
    /**
     * 当配置文件中 skd.wrap.enabled = true 时创建Bean
     * */
    @ConditionalOnProperty(prefix = "skd.wrap",value = "enabled",havingValue = "true")
    public WrapService wrapService(){
        return new WrapServiceImpl();
    }
}
