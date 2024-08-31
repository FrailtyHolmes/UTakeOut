package com.sky.controller.admin;

import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersConfirmDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersRejectionDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Frailty
 * @date 2024年04月01日 20:48
 */

@RestController("adminOrderController")
@RequestMapping("/admin/order")
@Slf4j
@Api(tags = "订单管理接口")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /*
     * @Description: 订单搜索
     * @author Frailty
     * @date 2024/4/1 20:50
     * @param ordersPageQueryDTO
     * @return com.sky.result.Result<com.sky.result.PageResult>
     */
    @GetMapping("/conditionSearch")
    @ApiOperation("订单搜索")
    public Result<PageResult> conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO) {
        PageResult pageResult = orderService.conditionSearch(ordersPageQueryDTO);
        return Result.success(pageResult);
    }

    /*
     * @Description: 各个状态的订单数量统计
     * @author Frailty
     * @date 2024/4/1 21:14
     * @return com.sky.result.Result<com.sky.vo.OrderStatisticsVO>
     */
    @GetMapping("/statistics")
    @ApiOperation("各个状态的订单数量统计")
    public Result<OrderStatisticsVO> statistics() {
        OrderStatisticsVO orderStatisticsVO = orderService.statistics();
        return Result.success(orderStatisticsVO);
    }

    /*
     * @Description: 查询订单详情
     * @author Frailty
     * @date 2024/4/1 21:20
     * @param id
     * @return com.sky.result.Result<com.sky.vo.OrderVO>
     */
    @GetMapping("/details/{id}")
    @ApiOperation("查询订单详情")
    public Result<OrderVO> details(@PathVariable Long id) {
        OrderVO orderVO = orderService.details(id);
        return Result.success(orderVO);
    }

    /*
     * @Description:接单
     * @author Frailty
     * @date 2024/4/1 21:26
     * @param ordersConfirmDTO
     * @return com.sky.result.Result
     */
    @PutMapping("/confirm")
    @ApiOperation("接单")
    public Result confirm(@RequestBody OrdersConfirmDTO ordersConfirmDTO) {
        orderService.confirm(ordersConfirmDTO);
        return Result.success();
    }

    /*
     * @Description: 拒单
     * @author Frailty
     * @date 2024/4/1 21:29
     * @param ordersRejectionDTO
     * @return com.sky.result.Result
     */
    @PutMapping("/rejection")
    @ApiOperation("拒单")
    public Result rejection(@RequestBody OrdersRejectionDTO ordersRejectionDTO) {
        orderService.rejection(ordersRejectionDTO);
        return Result.success();
    }

    /*
     * @Description: 取消订单
     * @author Frailty
     * @date 2024/4/1 21:36
     * @param ordersCancelDTO
     * @return com.sky.result.Result
     */
    @PutMapping("/cancel")
    @ApiOperation("取消订单")
    public Result cancel(@RequestBody OrdersCancelDTO ordersCancelDTO) {
        orderService.cancel(ordersCancelDTO);
        return Result.success();
    }

    /*
     * @Description: 派送订单
     * @author Frailty
     * @date 2024/4/1 21:41
     * @param id 
     * @return com.sky.result.Result
     */
    @PutMapping("/delivery/{id}")
    @ApiOperation("派送订单")
    public Result delivery(@PathVariable Long id){
        orderService.delivery(id);
        return Result.success();
    }

    /*
     * @Description: 完成订单
     * @author Frailty
     * @date 2024/4/1 21:45
     * @param id 
     * @return com.sky.result.Result
     */
    @PutMapping("/complete/{id}")
    @ApiOperation("完成订单")
    public Result complete(@PathVariable Long id){
        orderService.complete(id);
        return Result.success();
    }
}
