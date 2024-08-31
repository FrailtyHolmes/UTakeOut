package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /*
     * @Description:新增员工
     * @author Frailty
     * @date 2024/2/27 21:51
     * @param employeeDTO 
     */
    void save(EmployeeDTO employeeDTO);

    /*
     * @Description: 分页查询
     * @author Frailty
     * @date 2024/2/28 20:13
     * @param employeePageQueryDTO 
     * @return com.sky.result.PageResult
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /*
     * @Description: 启用禁用员工账号
     * @author Frailty
     * @date 2024/2/28 20:49
     * @param status
     * @param id 
     */
    void startOrStop(Integer status, Long id);

    /*
     * @Description:根据id查询员工信息
     * @author Frailty
     * @date 2024/2/28 21:00
     * @param id 
     * @return com.sky.entity.Employee
     */
    Employee getById(Long id);

    /*
     * @Description: 编辑员工信息
     * @author Frailty
     * @date 2024/2/28 21:07
     * @param employeeDTO 
     */
    void update(EmployeeDTO employeeDTO);
}
