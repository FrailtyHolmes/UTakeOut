package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {
    /*
     * @Description: 新增套餐 同时需要保存套餐和菜品的关联关系
     * @author Frailty
     * @date 2024/3/13 15:06
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);

    /*
     * @Description: 分页查询
     * @author Frailty
     * @date 2024/3/13 16:00
     * @param setmealPageQueryDTO
     * @return com.sky.result.PageResult
     */
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /*
     * @Description: 批量删除套餐
     * @author Frailty
     * @date 2024/3/13 16:15
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /*
     * @Description: 根据id查询套餐，用于修改页面回显数据
     * @author Frailty
     * @date 2024/3/13 16:24
     * @param id 
     * @return com.sky.vo.SetmealVO
     */
    SetmealVO getByIdWithDish(Long id);

    /*
     * @Description: 修改套餐
     * @author Frailty
     * @date 2024/3/13 16:31
     * @param setmealDTO 
     */
    void update(SetmealDTO setmealDTO);

    /*
     * @Description: 套餐起售停售
     * @author Frailty
     * @date 2024/3/13 17:02
     * @param status
     * @param id 
     */
    void startOrStop(Integer status, Long id);

    /*
     * @Description: 根据分类id查询套餐(用户端)
     * @author Frailty
     * @date 2024/3/27 21:21
     * @param setmeal 
     * @return java.util.List<com.sky.entity.Setmeal>
     */
    List<Setmeal> list(Setmeal setmeal);

    /*
     * @Description: 根据套餐id查询包含的菜品列表(用户端)
     * @author Frailty
     * @date 2024/3/27 21:25
     * @param id 
     * @return java.util.List<com.sky.vo.DishItemVO>
     */
    List<DishItemVO> getDishItemById(Long id);
}
