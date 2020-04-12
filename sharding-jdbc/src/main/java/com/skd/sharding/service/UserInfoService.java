package com.skd.sharding.service;

import com.skd.sharding.dao.entity.UserInfo;
import com.skd.sharding.dao.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/11 16:53
 */
@Slf4j
@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper mapper;

    public void add(UserInfo userInfo){
        mapper.insert(userInfo);
    }
}
