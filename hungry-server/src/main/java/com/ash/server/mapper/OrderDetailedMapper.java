package com.ash.server.mapper;

import com.ash.server.pojo.Order;
import com.ash.server.pojo.OrderDetailed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */

@Repository
public interface OrderDetailedMapper extends BaseMapper<OrderDetailed> {

    /**
     * @Description: 显示订单详情（分页）
     * @Param: [page, orderDetailed]
     * @Return: com.baomidou.mybatisplus.core.metadata.IPage<com.ash.server.pojo.Order>
     * @Author ash
     * @Date: 15:24 2021/3/23
     */
    IPage<Order> getOrderDetailedByPage(Page<Order> page, @Param("orderDetailed") OrderDetailed orderDetailed);

    /**
     * @Description: 根据订单号显示详情
     * @Param: [orderId]
     * @Return: java.util.List<com.ash.server.pojo.OrderDetailed>
     * @Author ash
     * @Date: 15:24 2021/3/23
     */
    List<OrderDetailed> getOrderDetailedByOrderId(@Param("orderId")Integer orderId);
}
