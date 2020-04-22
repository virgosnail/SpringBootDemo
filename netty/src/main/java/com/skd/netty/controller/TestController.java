package com.skd.netty.controller;

import com.skd.netty.manager.MegManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/21 18:22
 */
@RestController
@RequestMapping("/netty/")
public class TestController {

    @Autowired
    private MegManager manager;

    @GetMapping
    @RequestMapping("send")
    public void send(String data){
        manager.send(data);
    }
}
