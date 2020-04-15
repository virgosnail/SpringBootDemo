package com.skd.melody;

import com.skd.melody.task.PrintTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class JavamelodyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavamelodyApplication.class, args);
        PrintTask printTask = context.getBean(PrintTask.class);
        new Thread(printTask).start();

    }

}
