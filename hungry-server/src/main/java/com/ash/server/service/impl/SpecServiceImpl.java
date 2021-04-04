package com.ash.server.service.impl;

import com.ash.server.mapper.SpecMapper;
import com.ash.server.pojo.Spec;
import com.ash.server.service.ISpecService;
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
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements ISpecService {

    @Override
    public List<Spec> getSpecByCommodityId(Integer commodityId) {
        return baseMapper.getSpecByCommodityId(commodityId);
    }
}
