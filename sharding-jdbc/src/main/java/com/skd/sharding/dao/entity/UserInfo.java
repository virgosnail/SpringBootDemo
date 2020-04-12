package com.skd.sharding.dao.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/11 16:43
 */
@Data
public class UserInfo {

    @TableId(type=IdType.INPUT)
    private Long userId;
    private String userName;
    private String account;
    private String password;
}
