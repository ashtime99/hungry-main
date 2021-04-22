package com.ash.server.mapper;

import com.ash.server.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */

@Repository
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * @Description: 获取所有员工（分页）
     * @Param: [page, order, beginDataScope]
     * @Return: com.baomidou.mybatisplus.core.metadata.IPage<com.ash.server.pojo.Order>
     * @Author ash
     * @Date: 10:51 2021/3/18
     */
    IPage<Order> getOrderByPage(Page<Order> page, @Param("order") Order order, @Param("beginDataScope")LocalDate[] beginDataScope);

    List<Order> getOrderByState(@Param("userId") Long userId, @Param("state") Integer state);
}
