package com.skd.mybatis.model.response;

import lombok.Builder;
import lombok.Data;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/16 14:43
 */
@Data
@Builder
public class InsertResult {

    Integer insert;

    Long costTime;
}
