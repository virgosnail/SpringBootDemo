package com.skd.swagger.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author virgosnail
 * @Date 2019/4/10 22:10
 */

@Data
@ApiModel(value = "添加对象的请求对象")
public class Person {

    @NotEmpty
    @ApiModelProperty(value = "姓名", example = "milkson")
    private String name;

    @NotNull
    @ApiModelProperty(value = "年龄", example = "23")
    private Integer age;

    @ApiModelProperty(value = "手机号", example = "18392924545")
    private String phoneNumber;
}
