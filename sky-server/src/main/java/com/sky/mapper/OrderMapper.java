package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.GoodsSalesDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    /*
     * @Description: 插入订单数据
     * @author Frailty
     * @date 2024/3/31 22:08
     * @param order
     */
    void insert(Orders order);

    /**
     * 根据订单号和用户id查询订单
     *
     * @param orderNumber
     * @param userId
     */
    @Select("select * from orders where number = #{orderNumber} and user_id= #{userId}")
    Orders getByNumberAndUserId(String orderNumber, Long userId);

    /**
     * 修改订单信息
     *
     * @param orders
     */
    void update(Orders orders);


    /*
     * @Description: 用于替换微信支付更新数据库状态的问题
     * @author Frailty
     * @date 2024/4/1 14:52
     * @param orderStatus
     * @param orderPaidStatus
     * @param check_out_time
     * @param id
     */
    @Update("update orders " +
            "set status = #{orderStatus},pay_status = #{orderPaidStatus} ,checkout_time = #{check_out_time} " +
            "where id = #{id}")
    void updateStatus(Integer orderStatus, Integer orderPaidStatus, LocalDateTime check_out_time, Long id);

    /*
     * @Description: 分页条件查询并按下单时间排序
     * @author Frailty
     * @date 2024/4/1 17:20
     * @param ordersPageQueryDTO
     * @return com.github.pagehelper.Page<com.sky.entity.Orders>
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    /*
     * @Description: 根据id查询订单
     * @author Frailty
     * @date 2024/4/1 20:25
     * @param id
     * @return com.sky.entity.Orders
     */
    @Select("select * from orders where id = #{id}")
    Orders getById(Long id);

    /*
     * @Description: 根据状态统计订单数量
     * @author Frailty
     * @date 2024/4/1 21:16
     * @param toBeConfirmed
     * @return java.lang.Integer
     */
    @Select("select count(id) from orders where status = #{status}")
    Integer countStatus(Integer status);

    /*
     * @Description: 根据状态和下单时间查询订单
     * @author Frailty
     * @date 2024/4/5 17:14
     * @param pendingPayment
     * @param time 
     * @return java.util.List<com.sky.entity.Orders>
     */
    @Select("select * from orders where status = #{status} and order_time < #{orderTime}")
    List<Orders> getByStatusAndOrdertimeLT(Integer status, LocalDateTime orderTime);

    /*
     * @Description:根据动态条件统计营业额
     * @author Frailty
     * @date 2024/6/4 14:46
     * @param map 
     * @return java.lang.Double
     */
    Double sumByMap(Map map);

    /*
     * @Description: 根据动态条件统计订单数量
     * @author Frailty
     * @date 2024/6/4 15:56
     * @param map 
     * @return java.lang.Integer
     */
    Integer countByMap(Map map);

    /*
     * @Description: 查询商品销量排名
     * @author Frailty
     * @date 2024/6/4 16:29
     * @param beginTime
     * @param endTime 
     * @return java.util.List<com.sky.dto.GoodsSalesDTO>
     */
    List<GoodsSalesDTO> getSalesTop10(LocalDateTime begin, LocalDateTime end);
}
