package com.ash.server.mapper;

import com.ash.server.pojo.Spec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-03-15
 */

@Repository
public interface SpecMapper extends BaseMapper<Spec> {



    /**
     * @Description: 根据商品id查询类别列表
     * @Param: [commodityId]
     * @Return: java.util.List<com.ash.server.pojo.Spec>
     * @Author ash
     * @Date: 11:26 2021/3/17
     */
//    List<Spec> getSpec(Integer commodityId);

    List<Spec> getSpecByCommodityId(@Param("commodityId")Integer commodityId);
}
