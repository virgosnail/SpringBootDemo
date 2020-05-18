package com.skd.mybatis.config;

import com.skd.mybatis.plugin.ModifySqlPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/5/18 9:58
 */
@Configuration
public class MybatisConfig {

    @Bean
    public ModifySqlPlugin modifySqlPlugin(){
        return new ModifySqlPlugin();
    }
}
