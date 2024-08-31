package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     *
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 插入菜品数据
     *
     * @param dish
     */
    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    /*
     * @Description:菜品分页查询
     * @author Frailty
     * @date 2024/3/1 16:48
     * @param dishPageQueryDTO
     * @return com.github.pagehelper.Page<com.sky.vo.DishVO>
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /*
     * @Description: 根据主键查询菜品
     * @author Frailty
     * @date 2024/3/1 17:21
     * @param id
     * @return com.sky.entity.Dish
     */
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    /*
     * @Description: 删除菜品表中的菜品数据
     * @author Frailty
     * @date 2024/3/1 17:27
     * @param id 
     */
    @Delete("delete from dish where id = #{id}")
    void deleteById(Long id);

    /*
     * @Description: 根据id动态修改菜品数据
     * @author Frailty
     * @date 2024/3/1 17:44
     * @param dish 
     */
    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    /*
     * @Description: 根据分类id查询菜品
     * @author Frailty
     * @date 2024/3/13 14:49
     * @param dish 
     * @return java.util.List<com.sky.entity.Dish>
     */
    List<Dish> list(Dish dish);

    /*
     * @Description: 根据套餐id查菜品
     * @author Frailty
     * @date 2024/3/13 17:10
     * @param id 
     * @return java.util.List<com.sky.entity.Dish>
     */
    @Select("select d.* from dish d left join setmeal_dish s on d.id = s.dish_id where s.setmeal_id= #{setmealId}")
    List<Dish> getBySetmealId(Long setmealId);

    /*
     * @Description: 根据条件统计套餐数量
     * @author Frailty
     * @date 2024/6/7 14:06
     * @param map 
     * @return java.lang.Integer
     */
    Integer countByMap(Map map);
}
