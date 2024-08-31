package com.sky.controller.user;

/**
 * @author Frailty
 * @date 2024年03月30日 20:00
 */

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 购物车
 */
@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "C端-购物车接口")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    
    /*
     * @Description:  添加购物车
     * @author Frailty
     * @date 2024/3/30 20:03
     * @param shoppingCartDTO 
     * @return Result<String>
     */
    @PostMapping("/add")
    @ApiOperation(" 添加购物车")
    public Result<String > add(@RequestBody ShoppingCartDTO shoppingCartDTO){
        log.info("添加购物车：{}", shoppingCartDTO);
        shoppingCartService.addShoppingCart(shoppingCartDTO);
        return Result.success();
    }

    /*
     * @Description: 查看购物车
     * @author Frailty
     * @date 2024/3/30 20:34 
     * @return com.sky.result.Result<java.util.List<com.sky.entity.ShoppingCart>>
     */
    @GetMapping("/list")
    @ApiOperation("查看购物车")
    public Result<List<ShoppingCart>> list(){
        return Result.success(shoppingCartService.showShoppingCart());
    }

    /*
     * @Description: 清空购物车商品
     * @author Frailty
     * @date 2024/3/30 20:36 
     * @return com.sky.result.Result<java.lang.String>
     */
    @DeleteMapping("/clean")
    @ApiOperation("清空购物车商品")
    public Result<String > clean(){
        shoppingCartService.cleanShoppingCart();
        return Result.success();
    }
    
    /*
     * @Description: 删除购物车中一个商品
     * @author Frailty
     * @date 2024/3/30 20:54
     * @param null 
     * @return null
     */
    @PostMapping("/sub")
    @ApiOperation("删除购物车中一个商品")
    public Result sub(@RequestBody ShoppingCartDTO shoppingCartDTO){
        log.info("删除购物车中一个商品，商品：{}", shoppingCartDTO);
        shoppingCartService.subShoppingCart(shoppingCartDTO);
        return Result.success();
    }
}
