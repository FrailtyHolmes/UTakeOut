package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.WorkSpaceService;
import com.sky.vo.BusinessDataVO;
import com.sky.vo.DishOverViewVO;
import com.sky.vo.OrderOverViewVO;
import com.sky.vo.SetmealOverViewVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Frailty
 * @date 2024年06月07日 11:49
 */
@RestController
@RequestMapping("/admin/workspace")
@Slf4j
@Api(tags = "工作台相关接口")
public class WorkSpaceController {
    @Autowired
    private WorkSpaceService workSpaceService;

    /*
     * @Description: 工作台今日数据查询
     * @author Frailty
     * @date 2024/6/7 13:54
     * @return com.sky.result.Result<com.sky.vo.BusinessDataVO>
     */
    @GetMapping("/businessData")
    @ApiOperation("工作台今日数据查询")
    public Result<BusinessDataVO> businessData() {
        //获取当前时间
        LocalDateTime begin = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime end = LocalDateTime.now().with(LocalTime.MAX);

        BusinessDataVO businessDataVO = workSpaceService.getBusinessData(begin, end);
        return Result.success(businessDataVO);
    }

    /*
     * @Description:查询订单管理数据
     * @author Frailty
     * @date 2024/6/7 13:55
     * @return com.sky.result.Result<com.sky.vo.OrderOverViewVO>
     */
    @GetMapping("/overviewOrders")
    @ApiOperation("查询订单管理数据")
    public Result<OrderOverViewVO> orderOverView() {
        return Result.success(workSpaceService.getOrderOverView());
    }
    
    /*
     * @Description: 查询菜品总览
     * @author Frailty
     * @date 2024/6/7 14:11 
     * @return com.sky.result.Result<com.sky.vo.DishOverViewVO>
     */
    @GetMapping("/overviewDishes")
    @ApiOperation("查询菜品总览")
    public Result<DishOverViewVO> dishOverViewVO(){
        return Result.success(workSpaceService.getDishOverView());
    }
    
    /*
     * @Description: 查询套餐总览
     * @author Frailty
     * @date 2024/6/7 14:12 
     * @return com.sky.result.Result<com.sky.vo.SetmealOverViewVO>
     */
    @GetMapping("/overviewSetmeals")
    @ApiOperation("查询套餐总览")
    public Result<SetmealOverViewVO> setmealOverViewVO(){
        return Result.success(workSpaceService.getSetmealOverView());
    }
}
