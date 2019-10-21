package com.skd.mybatis.controller;

import com.skd.mybatis.dao.entity.Employee;
import com.skd.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2019/4/10 12:33
 */
@Controller
public class TestController {

    @Autowired
    private EmployeeService service;

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

}
