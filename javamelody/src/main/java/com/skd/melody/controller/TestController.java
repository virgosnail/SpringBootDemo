package com.skd.melody.controller;

import com.skd.melody.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/melody/")
public class TestController {

    @Autowired
    private TestService service;

    @GetMapping("test")
    public Integer addOne( Integer number){

        service.test();
        return ++number;
    }
}
