package com.ash.server.service;

import com.ash.server.pojo.Order;
import com.ash.server.pojo.RespPageBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface IOrderService extends IService<Order> {

    /**
     * @Description: 获取所有订单（分页）
     * @Param: [currentPage, size, order, beginDataScope]
     * @Return: com.ash.server.pojo.RespPageBean
     * @Author ash
     * @Date: 10:49 2021/3/18
     */
    RespPageBean getOrderByPage(Integer currentPage, Integer size, Order order, LocalDate[] beginDataScope);
}
