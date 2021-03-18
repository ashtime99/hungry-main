package com.ash.server.service.impl;

import com.ash.server.mapper.OrderMapper;
import com.ash.server.pojo.Order;
import com.ash.server.pojo.RespPageBean;
import com.ash.server.service.IOrderService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * @Description: 获取所有订单（分页）
     * @Param: [currentPage, size, order, beginDataScope]
     * @Return: com.ash.server.pojo.RespPageBean
     * @Author ash
     * @Date: 10:49 2021/3/18
     */
    @Override
    public RespPageBean getOrderByPage(Integer currentPage, Integer size, Order order, LocalDate[] beginDataScope) {
        //开启分页
        Page<Order> page=new Page<>(currentPage,size);
        IPage<Order>orderByPage=orderMapper.getOrderByPage(page,order,beginDataScope);
        RespPageBean respPageBean=new RespPageBean(orderByPage.getTotal(),orderByPage.getRecords());
        return respPageBean;
    }
}
