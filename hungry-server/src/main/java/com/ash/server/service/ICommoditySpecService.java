package com.ash.server.service;

import com.ash.server.pojo.Commodity;
import com.ash.server.pojo.CommoditySpec;
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
public interface ICommoditySpecService extends IService<CommoditySpec> {

    List<Commodity> getAllCommodity(String keywords);
}
