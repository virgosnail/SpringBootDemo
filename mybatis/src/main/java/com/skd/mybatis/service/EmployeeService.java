package com.skd.mybatis.service;

import com.skd.mybatis.dao.entity.Employee;

import java.util.List;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2019/4/10 12:34
 */
public interface EmployeeService {

    int insertEmployee(Employee employee);

    Employee selectEmployee(Long id);

    List<Employee> selectEmployee(List<Long> idList);

    int updateEmployee(Employee employee);

    int deleteEmployee(Long id);
}
