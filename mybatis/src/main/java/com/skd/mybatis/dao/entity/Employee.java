package com.skd.mybatis.dao.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2019/4/10 12:33
 */
@Data
@TableName(value = "djms.employee")
public class Employee {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer sex;
    private Integer age;
    private Integer salary;
    private String comment;
    private Date createAt;
    private Date updateAt;
    @TableLogic(value = "1",delval = "0")
    private Boolean exist;


}
