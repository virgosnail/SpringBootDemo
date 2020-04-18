package com.skd.starter.service.impl;

import com.skd.starter.config.PropertiesConfig;
import com.skd.starter.service.WrapService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/18 14:49
 */
public class WrapServiceImpl implements WrapService {

    @Autowired
    private PropertiesConfig config;

    @Override
    public String wrap(String content) {
        return config.getPrefix() + content + config.getSuffix();
    }
}
