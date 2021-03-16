package com.ash.server.service.impl;

import com.ash.server.mapper.CommodityCategoryMapper;
import com.ash.server.mapper.CommodityMapper;
import com.ash.server.pojo.Commodity;
import com.ash.server.pojo.CommodityCategory;
import com.ash.server.pojo.RespBean;
import com.ash.server.service.ICommodityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityCategoryMapper commodityCategoryMapper;

    /**
     * @Description: 获取所有商品
     * @Param: [keywords]
     * @Return: java.util.List<com.ash.server.pojo.Commodity>
     * @Author ash
     * @Date: 15:25 2021/3/15
     */
    @Override
    public List<Commodity> getAllCommodity(String keywords) {
        return commodityMapper.getAllCommodity(keywords);
    }

}
