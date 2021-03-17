package com.ash.server.service;

import com.ash.server.pojo.Commodity;
import com.ash.server.pojo.CommodityCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ash
 * @since 2021-03-15
 */
public interface ICommodityCategoryService extends IService<CommodityCategory> {

    List<Commodity> getAllCommodity(String keywords);
}
