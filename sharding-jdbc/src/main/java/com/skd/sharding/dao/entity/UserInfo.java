package com.skd.sharding.dao.entity;

import lombok.Data;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/11 16:43
 */
@Data
public class UserInfo {

    private Long userId;
    private String userName;
    private String account;
    private String password;
}
