package com.skd.sharding.controller;

import com.skd.sharding.dao.entity.UserInfo;
import com.skd.sharding.model.request.UserRequest;
import com.skd.sharding.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/shard/")
public class TestController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("add")
    public String add( UserRequest request){
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(request,userInfo);
        userInfoService.add(userInfo);
        return "ok";
    }
}
