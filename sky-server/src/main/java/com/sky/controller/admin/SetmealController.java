package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Frailty
 * @date 2024年03月13日 15:02
 */
@Api(tags = "套餐相关接口")
@Slf4j
@RestController
@RequestMapping("/admin/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    
    /*
     * @Description: 新增套餐
     * @author Frailty
     * @date 2024/3/13 15:05
     * @param setmealDTO 
     * @return com.sky.result.Result
     */
    @ApiOperation("新增套餐")
    @PostMapping
    @CacheEvict(cacheNames = "setmealCache", key = "#setmealDTO.categoryId") //删除某个key对应的缓存数据
    public Result save(@RequestBody SetmealDTO setmealDTO){
        setmealService.saveWithDish(setmealDTO);
        return Result.success();
    }
    
    /*
     * @Description:分页查询
     * @author Frailty
     * @date 2024/3/13 15:59
     * @param setmealPageQueryDTO 
     * @return com.sky.result.Result<com.sky.result.PageResult>
     */
    @GetMapping("/page")
    @ApiOperation("分页查询") 
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO){
        PageResult pageResult = setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }
    
    /*
     * @Description: 批量删除套餐
     * @author Frailty
     * @date 2024/3/13 16:12 
     * @return com.sky.result.Result
     */
    @DeleteMapping
    @ApiOperation("批量删除套餐")
    @CacheEvict(cacheNames = "setmealCache",allEntries = true) //删除所有key
    public Result delete(@RequestParam List<Long> ids){
        setmealService.deleteBatch(ids);
        return Result.success();
    }
    
    /*
     * @Description: 根据id查询套餐，用于修改页面回显数据
     * @author Frailty
     * @date 2024/3/13 16:23
     * @param null 
     * @return null
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询套餐")
    public Result<SetmealVO> getById(@PathVariable Long id){
        SetmealVO setmealVO = setmealService.getByIdWithDish(id);
        return Result.success(setmealVO);
    }
    
    /*
     * @Description:修改套餐
     * @author Frailty
     * @date 2024/3/13 16:31
     * @param setmealDTO 
     * @return com.sky.result.Result
     */
    @PutMapping
    @ApiOperation("修改套餐")
    @CacheEvict(cacheNames = "setmealCache",allEntries = true)
    public Result update(@RequestBody SetmealDTO setmealDTO){
        setmealService.update(setmealDTO);
        return Result.success();
    }
    
    @PostMapping("/status/{status}")
    @ApiOperation("套餐起售停售")
    @CacheEvict(cacheNames = "setmealCache",allEntries = true)
    public Result startOrStop(@PathVariable Integer status, Long id){
        //- 可以对状态为起售的套餐进行停售操作，可以对状态为停售的套餐进行起售操作
        //- 起售的套餐可以展示在用户端，停售的套餐不能展示在用户端
        //- 起售套餐时，如果套餐内包含停售的菜品，则不能起售
        setmealService.startOrStop(status,id);
        return Result.success();
    }
   
}
