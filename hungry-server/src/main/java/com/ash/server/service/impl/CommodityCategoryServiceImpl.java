package com.ash.server.service.impl;

import com.ash.server.mapper.CommodityCategoryMapper;
import com.ash.server.pojo.Commodity;
import com.ash.server.pojo.CommodityCategory;
import com.ash.server.service.ICommodityCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CommodityCategoryServiceImpl extends ServiceImpl<CommodityCategoryMapper, CommodityCategory> implements ICommodityCategoryService {


    @Override
    public List<Commodity> getAllCommodity(String keywords) {
        return baseMapper.getAllCommodityInfo(keywords);
    }
}
