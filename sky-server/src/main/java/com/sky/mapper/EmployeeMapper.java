package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /*
     * @Description:插入员工数据
     * @author Frailty
     * @date 2024/2/27 22:04
     * @param employee 
     */
    @Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user,status)" +
            "values " +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    @AutoFill(OperationType.INSERT)
    void insert(Employee employee);

    /*
     * @Description:动态分页查询
     * @author Frailty
     * @date 2024/2/28 20:18
     * @param employeePageQueryDTO 
     * @return com.github.pagehelper.Page<com.sky.entity.Employee>
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /*
     * @Description:启用禁用员工账号,这里是动态查询，根据传入的参数来进行update
     * @author Frailty
     * @date 2024/2/28 20:50
     * @param employee 
     */
    @AutoFill(OperationType.UPDATE)
    void update(Employee employee);

    /*
     * @Description: 根据id查询员工信息
     * @author Frailty
     * @date 2024/2/28 21:04
     * @param id 
     * @return com.sky.entity.Employee
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
