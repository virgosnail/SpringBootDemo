package com.skd.sharding.model.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Description:
 * @Author: virgosnail
 * @Date: 2020/4/11 22:13
 */
@Data
public class UserRequest {
    private Long userId;
    private String userName;
    private String account;
    private String password;
}
