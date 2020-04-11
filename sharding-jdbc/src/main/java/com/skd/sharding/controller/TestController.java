package com.skd.sharding.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/11 16:51
 */
@Slf4j
@RestController
@RequestMapping("")
public class TestController {

    @GetMapping("")
    public String ping(String request){
        return "pong";
    }
}
