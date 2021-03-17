package com.ash.server.controller;


import com.ash.server.pojo.*;
import com.ash.server.service.ICategoryService;
import com.ash.server.service.ICommodityCategoryService;
import com.ash.server.service.ICommodityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @Description: 商品
 * @Author ash
 * @Date 2021/3/15 15:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private ICommodityService commodityService;
    @Autowired
    private ICategoryService categoryService;

//    @ApiOperation("获取所有商品")
//    @GetMapping("/")
//    public List<Commodity> getAllCommodity(String keywords){
//        return commodityService.getAllCommodity(keywords);
//    }
    @ApiOperation("获取所有菜品类别")
    @GetMapping("/category")
    public List<Category> getCategory(){
        return categoryService.list();
    }

    @ApiOperation("获取所有菜品（分页）")
    @GetMapping("/")
    public RespPageBean getCommodity(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "10")Integer size,
                                     String keywords){
        return commodityService.getCommodity(currentPage,size,keywords);
    }


    @ApiOperation("添加商品")
    @PostMapping("/")
    public RespBean addCommodity(@RequestBody Commodity commodity){
        if (commodityService.save(commodity)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation("修改商品")
    @PutMapping("/")
    public RespBean updateCommodity(@RequestBody Commodity commodity){
        if (commodityService.updateById(commodity)){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/{commodityId}")
    public RespBean deleteCommodity(@PathVariable Integer commodityId){
        if (commodityService.removeById(commodityId)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }


}
