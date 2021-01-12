package com.xyc.hungry.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyc.hungry.model.OrderDetailed;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: hungry
 * @description:
 * @author: ash
 * @create: 2021/01/10 20:34
 */
@Mapper
public interface OrderDetailedMapper extends BaseMapper<OrderDetailed> {
}
