package com.skd.mybatis.dao.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.skd.mybatis.dao.entity.DeviceFileInfo;

import java.util.List;

public interface DeviceFileInfoMapper extends BaseMapper<DeviceFileInfo> {

    Integer batchInsert(List<DeviceFileInfo> list);
}