package com.skd.melody.config;

import net.bull.javamelody.MonitoringFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @Description:
 * @Author: virgosnail
 * @Date: 2020/4/15 20:58
 */
@Configuration
public class MelodyConfig {

    /**
     * URL: http://127.0.0.1:8888/monitoring
     * 配置javamelody监控
     * spring boot 会按照order值的大小，从小到大的顺序来依次过滤
     */
    @Bean
    @Order(Integer.MAX_VALUE-1)
    public FilterRegistrationBean<MonitoringFilter> monitoringFilter() {
        FilterRegistrationBean<MonitoringFilter>  registration = new FilterRegistrationBean<MonitoringFilter>();
        registration.setFilter(new MonitoringFilter());
        registration.addUrlPatterns("/*");
        registration.setName("monitoring");
        return registration;
    }

    /**
     *  配置javamelody监听器sessionListener
     */
//    @Bean
//    public ServletListenerRegistrationBean<SessionListener> servletListenerRegistrationBean() {
//        ServletListenerRegistrationBean<SessionListener> slrBean = new ServletListenerRegistrationBean<>();
//        slrBean.setListener(new SessionListener());
//        return slrBean;
//    }
}
