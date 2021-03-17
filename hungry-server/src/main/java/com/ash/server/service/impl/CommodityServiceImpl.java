package com.ash.server.service.impl;

import com.ash.server.mapper.CommodityCategoryMapper;
import com.ash.server.mapper.CommodityMapper;
import com.ash.server.pojo.Commodity;
import com.ash.server.pojo.RespPageBean;
import com.ash.server.service.ICommodityService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    /**
     * @Description:  获取所有菜品（分页）
     * @Param: [currentPage, size, beginDataScope]
     * @Return: com.ash.server.pojo.RespPageBean
     * @Author ash
     * @Date: 15:08 2021/3/16
     */
    @Override
    public RespPageBean getCommodity(Integer currentPage, Integer size,String keywords) {
        Page<Commodity> page=new Page<>(currentPage,size);
        IPage<Commodity>commodityByPage=commodityMapper.getCommodityByPage(page,keywords);
        RespPageBean respPageBean=new RespPageBean(commodityByPage.getTotal(),commodityByPage.getRecords());
        return respPageBean;
    }

}
