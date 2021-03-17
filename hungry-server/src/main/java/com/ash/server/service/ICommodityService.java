package com.ash.server.service;

import com.ash.server.pojo.Commodity;
import com.ash.server.pojo.RespPageBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface ICommodityService extends IService<Commodity> {

    /**
     * @Description: 获取所有商品
     * @Param: [keywords]
     * @Return: java.util.List<com.ash.server.pojo.Commodity>
     * @Author ash
     * @Date: 15:25 2021/3/15
     */
    List<Commodity> getAllCommodity(String keywords);

    /**
     * @Description:  获取所有菜品（分页）
     * @Param: [currentPage, size, beginDataScope]
     * @Return: com.ash.server.pojo.RespPageBean
     * @Author ash
     * @Date: 15:08 2021/3/16
     */
    RespPageBean getCommodity(Integer currentPage, Integer size,String keywords);
}
