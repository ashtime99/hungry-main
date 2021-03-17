package com.ash.server.mapper;

import com.ash.server.pojo.Shoppingcart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface ShoppingcartMapper extends BaseMapper<Shoppingcart> {

    List<Shoppingcart> getShoppingcartByUser(@Param("userId") Integer userId);
}
