package com.skd.mybatis.dao.repository;

import com.skd.mybatis.dao.entity.DriverInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/23 14:14
 */
@Repository
public interface DriverInfoDao {
    /**
     * 根据司机ID获取司机信息
     * @param id id
     * @return DriverInfo
     */
    @Select("select * from driver_info where id=#{id}")
    DriverInfo getDriverInfoById(@Param("id") Integer id);
}
