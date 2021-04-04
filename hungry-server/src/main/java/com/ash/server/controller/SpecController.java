package com.ash.server.controller;


import com.ash.server.pojo.Spec;
import com.ash.server.service.ISpecService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  商品规格API
 * </p>
 *
 * @author ash
 * @since 2021-03-15
 */
@RestController
@RequestMapping("/spec")
@Api(tags = "商品规格API")
public class SpecController {

    @Autowired
    private ISpecService specService;

    @ApiOperation("获取所有商品规格")
    @GetMapping("/")
    public List<Spec> getSpec(){
        return specService.list();
    }

    @ApiOperation("根据商品id获取规格")
    @GetMapping("/{commodityId}}")
    public List<Spec> getSpecByCommodityId(@PathVariable Integer commodityId){
        return specService.getSpecByCommodityId(commodityId);
    }

}
