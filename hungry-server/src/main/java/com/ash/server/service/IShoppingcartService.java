package com.ash.server.service;

import com.ash.server.pojo.Shoppingcart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @Author ash
 * @Since 2021/3/26 18:07
 * @Version 1.0
 */
public interface IShoppingcartService extends IService<Shoppingcart> {

    List<Shoppingcart> getShoppingcartByUser(Integer userId);
}
