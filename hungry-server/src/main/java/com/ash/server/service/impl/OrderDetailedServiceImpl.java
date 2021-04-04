package com.ash.server.service.impl;

import com.ash.server.mapper.OrderDetailedMapper;
import com.ash.server.pojo.Order;
import com.ash.server.pojo.OrderDetailed;
import com.ash.server.pojo.RespPageBean;
import com.ash.server.service.IOrderDetailedService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Service
public class OrderDetailedServiceImpl extends ServiceImpl<OrderDetailedMapper, OrderDetailed> implements IOrderDetailedService {

    @Autowired
    private OrderDetailedMapper orderDetailedMapper;

    /**
     * @Description: 显示订单详情（分页）
     * @Param: [currentPage, size, orderDetailed]
     * @Return: com.ash.server.pojo.RespPageBean
     * @Author ash
     * @Date: 15:23 2021/3/23
     */
    @Override
    public RespPageBean getOrderDetailedByPage(Integer currentPage, Integer size, OrderDetailed orderDetailed) {
        //开启分页
        Page<Order> page=new Page<>(currentPage,size);
        IPage<Order> orderByPage=orderDetailedMapper.getOrderDetailedByPage(page,orderDetailed);
        RespPageBean respPageBean=new RespPageBean(orderByPage.getTotal(),orderByPage.getRecords());
        return respPageBean;
    }

    /**
     * @Description: 根据订单号显示详情
     * @Param: [orderId]
     * @Return: java.util.List<com.ash.server.pojo.OrderDetailed>
     * @Author ash
     * @Date: 15:23 2021/3/23
     */
    @Override
    public List<OrderDetailed> getOrderDetailedByOrderId(Integer orderId) {
        return orderDetailedMapper.getOrderDetailedByOrderId(orderId);
    }
}
