package com.skd.melody.task;

import lombok.extern.slf4j.Slf4j;
import net.bull.javamelody.MonitoredWithSpring;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: virgosnail
 * @Date: 2020/4/15 21:14
 */
@Slf4j
@Component
public class PrintTask implements Runnable {

    private Integer num = 0;

    private Boolean flag = true;

    /**
     * HTTP请求调用链中的 controller 和 service 可以自动监控
     * 其他的 bean 需要配置  @MonitoredWithSpring 才可以进行监控
     */
    @MonitoredWithSpring
    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("server error",e);
            }
            log.info("num:{}",num++);
        }
    }
}
