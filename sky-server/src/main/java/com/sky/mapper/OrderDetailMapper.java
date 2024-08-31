package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    /*
     * @Description: 批量插入订单明细数据
     * @author Frailty
     * @date 2024/3/31 22:10
     * @param orderDetailList 
     */
    void insertBatch(List<OrderDetail> orderDetailList);

    /*
     * @Description: 通过订单号查orderDetail
     * @author Frailty 
     * @date 2024/4/1 17:20
     * @param orderId 
     * @return java.util.List<com.sky.entity.OrderDetail>
     */
    @Select("select * from order_detail where order_id = #{orderId}")
    List<OrderDetail> getByOrderId(Long orderId);
}
