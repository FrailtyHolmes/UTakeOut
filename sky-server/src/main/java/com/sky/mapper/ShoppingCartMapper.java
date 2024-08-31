package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    /*
     * @Description: 更新商品数量
     * @author Frailty
     * @date 2024/3/30 20:21
     * @param shoppingCart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart shoppingCart);

    /*
     * @Description: 插入购物车数据
     * @author Frailty
     * @date 2024/3/30 20:22
     * @param shoppingCart
     */
    @Insert("insert into shopping_cart " +
            "(name, user_id, dish_id, setmeal_id, dish_flavor,number,amount,image,create_time) " +
            "VALUES " +
            "(#{name},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{number},#{amount},#{image},#{createTime})")
    void insert(ShoppingCart shoppingCart);

    /*
     * @Description: 条件查询
     * @author Frailty
     * @date 2024/3/30 20:25
     * @param shoppingCart
     * @return java.util.List<com.sky.entity.ShoppingCart>
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /*
     * @Description: 根据用户id删除购物车数据
     * @author Frailty
     * @date 2024/3/30 20:39
     * @param currentId
     */
    @Delete("delete from shopping_cart where user_id = #{userId}")
    void deleteByUserId(Long userId);

    /*
     * @Description: 根据id删除购物车数据
     * @author Frailty
     * @date 2024/3/30 21:01
     * @param id
     */
    @Delete("delete from shopping_cart where id = #{id}")
    void deleteById(Long id);

    /*
     * @Description: 批量插入购物车数据
     * @author Frailty
     * @date 2024/4/1 20:42
     * @param shoppingCartList 
     */
    void insertBatch(List<ShoppingCart> shoppingCartList);
}
