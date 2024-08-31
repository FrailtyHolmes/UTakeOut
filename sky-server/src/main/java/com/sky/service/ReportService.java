package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public interface ReportService {
    /*
     * @Description: 根据时间区间统计营业额
     * @author Frailty
     * @date 2024/6/4 14:36
     * @param begin
     * @param end 
     * @return com.sky.vo.TurnoverReportVO
     */
    TurnoverReportVO getTurnover(LocalDate begin, LocalDate end);

    /*
     * @Description: 用户数据统计
     * @author Frailty
     * @date 2024/6/4 15:13
     * @param begin
     * @param end 
     * @return com.sky.vo.UserReportVO
     */
    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

    /*
     * @Description: 订单数据统计
     * @author Frailty
     * @date 2024/6/4 15:37
     * @param begin
     * @param end 
     * @return com.sky.vo.OrderReportVO
     */
    OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

    /*
     * @Description: 销量排名统计
     * @author Frailty
     * @date 2024/6/4 16:22
     * @param begin
     * @param end 
     * @return com.sky.vo.SalesTop10ReportVO
     */
    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);

    /*
     * @Description: 导出运营数据报表
     * @author Frailty
     * @date 2024/6/15 15:33
     * @param response 
     */
    void exportBusinessData(HttpServletResponse response);
}
