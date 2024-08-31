package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    /*
     * @Description: 清空购物车商品
     * @author Frailty
     * @date 2024/3/30 20:37 
     */
    void cleanShoppingCart();

    /*
     * @Description:添加购物车
     * @author Frailty
     * @date 2024/3/30 20:04
     * @param shoppingCartDTO 
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    /*
     * @Description: 查看购物车
     * @author Frailty
     * @date 2024/3/30 20:34 
     * @return java.lang.Object
     */
    List<ShoppingCart> showShoppingCart();

    /*
     * @Description: 删除购物车中一个商品
     * @author Frailty
     * @date 2024/3/30 20:55
     * @param shoppingCartDTO 
     */
    void subShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
