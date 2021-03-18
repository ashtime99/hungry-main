package com.ash.server.mapper;

import com.ash.server.pojo.Order;
import com.ash.server.pojo.OrderDetailed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface OrderDetailedMapper extends BaseMapper<OrderDetailed> {

    IPage<Order> getOrderDetailedByPage(Page<Order> page, @Param("orderDetailed")OrderDetailed orderDetailed);
}
