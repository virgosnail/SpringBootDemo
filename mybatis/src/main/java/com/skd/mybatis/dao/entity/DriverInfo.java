package com.skd.mybatis.dao.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Describe: 司机信息
 * @Author: chenfan
 * @Date: 2020/4/23 10:12
 */
@Data
public class DriverInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String driverName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
