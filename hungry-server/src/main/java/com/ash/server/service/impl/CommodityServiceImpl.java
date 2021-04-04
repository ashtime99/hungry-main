package com.ash.server.service.impl;

import com.ash.server.mapper.CommoditySpecMapper;
import com.ash.server.mapper.CommodityMapper;
import com.ash.server.pojo.Commodity;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.RespPageBean;
import com.ash.server.service.ICommodityService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private CommoditySpecMapper commoditySpecMapper;


    /**
     * @Description: 获取所有商品
     * @Param: [keywords]
     * @Return: java.util.List<com.ash.server.pojo.Commodity>
     * @Author ash
     * @Date: 15:25 2021/3/15
     */
    @Override
    public List<Commodity> getCommodity(String keywords,Integer categoryId) {
        return commodityMapper.getCommodity(keywords,categoryId);
    }

    /**
     * @Description:  获取所有菜品（分页）
     * @Param: [currentPage, size, beginDataScope]
     * @Return: com.ash.server.pojo.RespPageBean
     * @Author ash
     * @Date: 15:08 2021/3/16
     */
    @Override
    public RespPageBean getAllCommodity(Integer currentPage, Integer size,String keywords) {
        Page<Commodity> page=new Page<>(currentPage,size);
        IPage<Commodity>commodityByPage=commodityMapper.getCommodityByPage(page,keywords);
        RespPageBean respPageBean=new RespPageBean(commodityByPage.getTotal(),commodityByPage.getRecords());
        return respPageBean;
    }

    @Override
    public RespBean addCommodity(Commodity commodity) {
        commodity.setCommodityCreateTime(LocalDateTime.now());
        commodity.setCommodityUpdateTime(LocalDateTime.now());
        commodity.setCommodityEnable(true);
        commodity.setCommodityLocked(false);
        if (1==commodityMapper.insert(commodity)){
            return RespBean.success("添加成功！");
        }else{
            return RespBean.success("添加失败！");
        }
    }

    /** 
     * 查询员工 
     *
     * @Param: [Id] 
     * @Return: java.util.List<com.ash.server.pojo.Commodity> 
     * @Author ash
     * @Date: 14:31 2021/3/28
     */ 
    @Override
    public List<Commodity> getCommodityExcel(Integer Id) {
        return commodityMapper.getCommodityExcel(Id);
    }

}
