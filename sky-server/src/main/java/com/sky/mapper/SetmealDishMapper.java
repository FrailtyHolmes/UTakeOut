package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应的套餐id
     *
     * @param dishIds
     * @return
     */
    //select setmeal_id from setmeal_dish where dish_id in (1,2,3,4)
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /*
     * @Description: 批量保存套餐和菜品的关联关系
     * @author Frailty
     * @date 2024/3/13 15:29
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /*
     * @Description: 根据套餐id删除套餐和菜品的关联关系
     * @author Frailty
     * @date 2024/3/13 16:20
     * @param setmealId
     */
    @Delete("delete from setmeal_dish  where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);

    /*
     * @Description:根据套餐id获取套餐中的菜品
     * @author Frailty
     * @date 2024/3/13 16:28
     * @param id 
     * @return java.util.List<com.sky.entity.SetmealDish>
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getBySetmealId(Long id);
}
