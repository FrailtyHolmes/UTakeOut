package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author Frailty
 * @date 2024年03月25日 20:44
 */

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /*
     * @Description: 设置店铺的营业状态
     * @author Frailty
     * @date 2024/3/25 20:46
     * @param status
     * @return com.sky.result.Result
     */
    @PutMapping("/{status}")
    @ApiOperation("设置店铺的营业状态")
    public Result setStatus(@PathVariable Integer status) {
        log.info("设置店铺营业状态：{}", status == 1 ? "营业中" : "打烊了");
        redisTemplate.opsForValue().set(KEY, status);
        return Result.success();
    }
    
    /*
     * @Description: 获取店铺的营业状态
     * @author Frailty
     * @date 2024/3/25 20:48 
     * @return com.sky.result.Result<java.lang.Integer>
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("设置店铺营业状态：{}", status == 1 ? "营业中" : "打烊了");
        return Result.success(status);
    }
}
