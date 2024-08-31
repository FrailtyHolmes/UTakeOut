package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {
    /*
     * @Description: 新增菜品和对应的口味
     * @author Frailty
     * @date 2024/3/1 16:19
     * @param dishDTO 
     */
    void saveWithFlavor(DishDTO dishDTO);

    /*
     * @Description: 菜品分页查询
     * @author Frailty
     * @date 2024/3/1 16:47
     * @param dishPageQueryDTO 
     * @return com.sky.result.PageResult
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /*
     * @Description:菜品批量删除
     * @author Frailty
     * @date 2024/3/1 17:07
     * @param ids 
     */
    void deleteBatch(List<Long> ids);

    /*
     * @Description: 根据id查询菜品
     * @author Frailty
     * @date 2024/3/1 17:36
     * @param id 
     * @return com.sky.vo.DishVO
     */
    DishVO getByIdWithFlavor(Long id);

    /*
     * @Description: 根据id修改菜品基本信息和对应的口味信息
     * @author Frailty
     * @date 2024/3/1 17:42
     * @param dishDTO 
     */
    void updateWithFlavor(DishDTO dishDTO);

    /*
     * @Description:起售停售功能"
     * @author Frailty
     * @date 2024/3/1 20:53
     * @param status
     * @param id 
     */
    void startOrStop(Integer status, Long id);

    /*
     * @Description: 根据分类id查询菜品
     * @author Frailty
     * @date 2024/3/13 14:45
     * @param categoryId 
     * @return java.util.List<com.sky.entity.Dish>
     */
    List<Dish> list(Long categoryId);

    /*
     * @Description: 条件查询菜品和口味
     * @author Frailty
     * @date 2024/3/27 21:41
     * @param dish 
     * @return java.util.List<com.sky.vo.DishVO>
     */
    List<DishVO> listWithFlavor(Dish dish);
}
