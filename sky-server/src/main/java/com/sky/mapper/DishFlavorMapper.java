package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /*
     * @Description: 批量插入口味数据
     * @author Frailty
     * @date 2024/3/1 16:35
     * @param flavors 
     */
    void insertBatch(List<DishFlavor> flavors);

    /*
     * @Description: 根据菜品id删除对应的口味数据
     * @author Frailty
     * @date 2024/3/1 17:28
     * @param id 
     */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    /*
     * @Description: 根据菜品id查询对应的口味数据
     * @author Frailty
     * @date 2024/3/1 17:39
     * @param dishId 
     * @return java.util.List<com.sky.entity.DishFlavor>
     */
    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);
}
