package com.xyc.hungry.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyc.hungry.model.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: hungry
 * @description:
 * @author: ash
 * @create: 2021/01/10 20:37
 */
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
