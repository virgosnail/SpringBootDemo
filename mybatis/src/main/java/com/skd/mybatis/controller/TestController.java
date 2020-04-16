package com.skd.mybatis.controller;

import com.skd.mybatis.dao.entity.DeviceFileInfo;
import com.skd.mybatis.dao.entity.Employee;
import com.skd.mybatis.dao.mapper.DeviceFileInfoMapper;
import com.skd.mybatis.model.response.InsertResult;
import com.skd.mybatis.service.EmployeeService;
import com.skd.mybatis.util.DateFormatUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2019/4/10 12:33
 */
@Slf4j
@RequestMapping("/mybatis/")
@RestController
public class TestController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private DeviceFileInfoMapper deviceInfoService;

    @PostMapping("test")
    public void test() {
        Employee employee = new Employee();
        long millis = System.currentTimeMillis();
        employee.setName("milkson" + millis);
        employee.setAge(21);
        employee.setSalary(7500);
        employee.setCreateAt(new Date());
        employee.setExist(true);
        service.insertEmployee(employee);
        System.out.println("insert a employee :" + employee);

        Employee employee1 = service.selectEmployee(employee.getId());
        System.out.println("select a employee:" + employee1);

        employee1.setComment("update" + millis);
        employee1.setUpdateAt(new Date());
        service.updateEmployee(employee1);
        System.out.println("update a employee:" + employee1);

        service.deleteEmployee(employee1.getId());
    }

    @PostMapping
    public InsertResult insertBatch(Integer num){
        long millis = System.currentTimeMillis();
        List<DeviceFileInfo> list = new ArrayList<>(num);
        DeviceFileInfo info;
        for (int i=0;i<num;i++){
            info = new DeviceFileInfo();
            info.setFileName("a.txt");
            info.setFilePath("/home/a.txt");
            info.setFileSize(10000L);
            info.setFileExt("txt");
            info.setFileType(1);
            info.setExInfo("test " + i);
            info.setFinished(1);
            info.setDevId("123456");
            info.setChl(1L);
            info.setSourceType(1);
            info.setStreamType(1);
            Date date = new Date();
            Date formatDate = DateFormatUtils.toFormatDate(date);
            info.setStartTime(formatDate);
            info.setEndTime(formatDate);
            info.setCreateAt(formatDate);
            info.setUpdateAt(formatDate);
            info.setTakeAt(formatDate);
            info.setValid(1);
            list.add(info);
        }
        Integer insert = 0;
        try {
            insert = deviceInfoService.batchInsert(list);
        } catch (Exception e) {
            log.error("",e);
        }
        long endMillis = System.currentTimeMillis();
        InsertResult result = InsertResult.builder().insert(insert).costTime(endMillis - millis).build();
        return result;
    }
}
