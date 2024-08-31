package com.sky.service;

import com.sky.dto.*;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

public interface OrderService {
    /*
     * @Description: 用户下单
     * @author Frailty
     * @date 2024/3/31 21:52
     * @param ordersSubmitDTO
     * @return com.sky.vo.OrderSubmitVO
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 订单支付
     *
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 支付成功，修改订单状态
     *
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);

    /*
     * @Description: 用户端订单分页查询
     * @author Frailty
     * @date 2024/4/1 17:07
     * @param page
     * @param pageSize
     * @param status 
     * @return com.sky.result.PageResult
     */
    PageResult pageQuery4User(int page, int pageSize, Integer status);

    /*
     * @Description: 查询订单详情
     * @author Frailty
     * @date 2024/4/1 20:22
     * @param id 
     * @return com.sky.vo.OrderVO
     */
    OrderVO details(Long id);

    /*
     * @Description: 取消订单
     * @author Frailty
     * @date 2024/4/1 20:27
     * @param id 
     */
    void userCancelById(Long id) throws Exception;

    /*
     * @Description: 再来一单
     * @author Frailty
     * @date 2024/4/1 20:37
     * @param id 
     */
    void repetition(Long id);

    /*
     * @Description:条件搜索订单
     * @author Frailty 
     * @date 2024/4/1 20:50
     * @param ordersPageQueryDTO 
     * @return com.sky.result.PageResult
     */
    PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    /*
     * @Description: 各个状态的订单数量统计
     * @author Frailty
     * @date 2024/4/1 21:14 
     * @return com.sky.vo.OrderStatisticsVO
     */
    OrderStatisticsVO statistics();

    /*
     * @Description: 接单
     * @author Frailty
     * @date 2024/4/1 21:26
     * @param ordersConfirmDTO 
     */
    void confirm(OrdersConfirmDTO ordersConfirmDTO);

    /*
     * @Description: 拒单
     * @author Frailty
     * @date 2024/4/1 21:29
     * @param ordersRejectionDTO 
     */
    void rejection(OrdersRejectionDTO ordersRejectionDTO);

    /*
     * @Description: 取消订单
     * @author Frailty
     * @date 2024/4/1 21:37
     * @param ordersCancelDTO 
     */
    void cancel(OrdersCancelDTO ordersCancelDTO);

    /*
     * @Description: 派送订单
     * @author Frailty
     * @date 2024/4/1 21:41
     * @param id 
     */
    void delivery(Long id);

    /*
     * @Description: 完成订单
     * @author Frailty
     * @date 2024/4/1 21:45
     * @param id 
     */
    void complete(Long id);

    /* 
     * @Description: 用户催单
     * @author Frailty
     * @date 2024/4/5 17:27
     * @param id 
     */
    void reminder(Long id);
}
