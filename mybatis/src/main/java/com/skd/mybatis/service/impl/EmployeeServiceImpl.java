package com.skd.mybatis.service.impl;

import com.skd.mybatis.dao.entity.Employee;
import com.skd.mybatis.dao.mapper.EmployeeMapper;
import com.skd.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2019/4/10 12:34
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public int insertEmployee(Employee employee) {

        return mapper.insert(employee);
    }

    @Override
    public Employee selectEmployee(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Employee> selectEmployee(List<Long> idList) {
        return mapper.selectBatchIds(idList);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return mapper.updateById(employee);
    }

    @Override
    public int deleteEmployee(Long id) {
        return mapper.deleteById(id);
    }
}
