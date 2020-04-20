/**
 * create by lx
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.skd.swagger.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Locale;

/**
 *
 */
@Configuration
@Slf4j
public class PdfConfig {

    @Bean
    @Primary
    public freemarker.template.Configuration getConfiguration(){

        freemarker.template.Configuration cfg = new freemarker.template.Configuration();
        try {
            cfg.setLocale(Locale.CHINA);
            cfg.setEncoding(Locale.CHINA, "UTF-8");
            //设置编码
            cfg.setDefaultEncoding("UTF-8");
            cfg.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
            cfg.setDateFormat("yyyy-MM-dd HH:mm:ss");
            cfg.setTimeFormat("yyyy-MM-dd HH:mm:ss");
            //设置模板路径
            cfg.setClassLoaderForTemplateLoading(Thread.currentThread().getContextClassLoader(), "/");
        }catch (Exception e){
            log.error("初始化pdf配置类失败：{}",e);
        }
        return cfg;
    }
}
