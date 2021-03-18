package com.ash.server.service;

import com.ash.server.pojo.OrderDetailed;
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
public interface IOrderDetailedService extends IService<OrderDetailed> {

    RespPageBean getOrderDetailedByPage(Integer currentPage, Integer size, OrderDetailed orderDetailed);
}
