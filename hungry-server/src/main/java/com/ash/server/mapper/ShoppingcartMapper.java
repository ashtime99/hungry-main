package com.ash.server.mapper;

import com.ash.server.pojo.Shoppingcart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
public interface ShoppingcartMapper extends BaseMapper<Shoppingcart> {

    List<Shoppingcart> getShoppingcartByUser(@Param("userId") Integer userId);
}
