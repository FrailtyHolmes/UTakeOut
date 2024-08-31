package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     *
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    /*
     * @Description:更新操作
     * @author Frailty
     * @date 2024/3/1 21:07
     * @param setmeal
     */
    @AutoFill(OperationType.UPDATE)
    void update(Setmeal setmeal);

    /*
     * @Description:新增套餐
     * @author Frailty
     * @date 2024/3/13 15:16
     * @param setmeal
     */
    @AutoFill(OperationType.INSERT)
    void insert(Setmeal setmeal);

    /*
     * @Description: 分页查询
     * @author Frailty
     * @date 2024/3/13 16:03
     * @param setmealPageQueryDTO
     * @return com.github.pagehelper.Page<com.sky.vo.SetmealVO>
     */
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /*
     * @Description: 根据id查询套餐
     * @author Frailty
     * @date 2024/3/13 16:19
     * @param id
     * @return com.sky.entity.Setmeal
     */
    @Select("select * from setmeal where id = #{id}")
    Setmeal getById(Long id);

    /*
     * @Description: 根据id删除套餐
     * @author Frailty
     * @date 2024/3/13 16:19
     * @param setmealId
     */
    @Delete("delete from setmeal where id = #{id}")
    void deleteById(Long setmealId);

    /*
     * @Description: 根据分类id查询套餐(用户端) 动态
     * @author Frailty
     * @date 2024/3/27 21:26
     * @param setmeal
     * @return java.util.List<com.sky.entity.Setmeal>
     */
    List<Setmeal> list(Setmeal setmeal);

    /*
     * @Description: 根据套餐id查询包含的菜品列表
     * @author Frailty
     * @date 2024/3/27 21:27
     * @param id
     * @return java.util.List<com.sky.vo.DishItemVO>
     */
    @Select("select sd.name,sd.copies, d.image, d.description " +
            "from setmeal_dish sd left join dish d on d.id = sd.dish_id " +
            "where sd.setmeal_id = #{setmealId}")
    List<DishItemVO> getDishItemById(Long setmealId);

    /*
     * @Description: 根据条件统计套餐数量
     * @author Frailty
     * @date 2024/6/7 14:13
     * @param map 
     * @return java.lang.Integer
     */
    Integer countByMap(Map map);
}
