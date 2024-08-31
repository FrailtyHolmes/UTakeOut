package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {
    /*
     * @Description: 根据openid查询用户
     * @author Frailty
     * @date 2024/3/27 20:59
     * @param openid 
     * @return com.sky.entity.User
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);

    /*
     * @Description: 插入数据(动态)
     * @author Frailty
     * @date 2024/3/27 20:59
     * @param user 
     */
    void insert(User user);

    /*
     * @Description: 根据userId查user
     * @author Frailty
     * @date 2024/4/1 14:35
     * @param userId 
     * @return com.sky.entity.User
     */
    @Select("select * from user where id = #{id}")
    User getById(Long id);

    /*
     * @Description: 根据动态条件统计用户数量
     * @author Frailty
     * @date 2024/6/4 15:24
     * @param map 
     * @return java.lang.Integer
     */
    Integer countByMap(Map map);
}
