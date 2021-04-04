package com.ash.server.service.impl;

import com.ash.server.mapper.CommoditySpecMapper;
import com.ash.server.pojo.Commodity;
import com.ash.server.pojo.CommoditySpec;
import com.ash.server.service.ICommoditySpecService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-03-15
 */
@Service
public class CommodityCategoryServiceImpl extends ServiceImpl<CommoditySpecMapper, CommoditySpec> implements ICommoditySpecService {


    @Override
    public List<Commodity> getAllCommodity(String keywords) {
        return baseMapper.getAllCommodityInfo(keywords);
    }
}
