package com.ash.server.service;

import com.ash.server.pojo.Spec;
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
public interface ISpecService extends IService<Spec> {

    List<Spec> getSpecByCommodityId(Integer commodityId);
}
