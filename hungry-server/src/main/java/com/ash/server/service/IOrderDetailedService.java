package com.ash.server.service;

import com.ash.server.pojo.OrderDetailed;
import com.ash.server.pojo.RespPageBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface IOrderDetailedService extends IService<OrderDetailed> {
    /**
     * @Description: 显示订单详情（分页）
     * @Param: [currentPage, size, orderDetailed]
     * @Return: com.ash.server.pojo.RespPageBean
     * @Author ash
     * @Date: 15:23 2021/3/23
     */
    RespPageBean getOrderDetailedByPage(Integer currentPage, Integer size, OrderDetailed orderDetailed);

    /**
     * @Description: 根据订单号显示详情
     * @Param: [orderId]
     * @Return: java.util.List<com.ash.server.pojo.OrderDetailed>
     * @Author ash
     * @Date: 15:23 2021/3/23
     */
    List<OrderDetailed> getOrderDetailedByOrderId(Integer orderId);
}
