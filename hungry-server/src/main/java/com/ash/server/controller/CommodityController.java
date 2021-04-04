package com.ash.server.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.http.server.HttpServerResponse;
import com.ash.server.pojo.*;
import com.ash.server.service.ICommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 商品前端控制器
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/29 12:08
 */
@RestController
@RequestMapping("/commodity")
@Api(tags = "商品API")
public class CommodityController {

    @Autowired
    private ICommodityService commodityService;


    @ApiOperation("获取所有商品")
    @GetMapping("/")
    public List<Commodity> getCommodity(String keywords,Integer categoryId){
        return commodityService.getCommodity(keywords,categoryId);
    }

    @ApiOperation("获取所有商品（分页）")
    @GetMapping("/all")
    public RespPageBean getAllCommodity(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "10")Integer size,
                                     String keywords){
        return commodityService.getAllCommodity(currentPage,size,keywords);
    }


    @ApiOperation("添加商品")
    @PostMapping("/")
    public RespBean addCommodity(@RequestBody Commodity commodity){
        return commodityService.addCommodity(commodity);
    }

    @ApiOperation("修改商品冻结状态")
    @PutMapping("/locked/{commodityId}")
    public RespBean updateCommodity(@PathVariable Integer commodityId){
        Commodity commodity=commodityService.getById(commodityId);
        boolean flag=commodity.getCommodityLocked();
        commodity.setCommodityLocked(!flag);
        if (commodityService.updateById(commodity)){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @ApiOperation("修改商品状态")
    @PutMapping("/")
    public RespBean updateCommodityLocked(@RequestBody Commodity commodity){
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

    @ApiOperation("导出商品数据")
    @GetMapping(value = "/export")
    public void exportCommodity(HttpServletResponse response){
        List<Commodity> commodityExcel = commodityService.getCommodityExcel(null);
        ExportParams params=new ExportParams("商品表","商品表", ExcelType.HSSF);
        Workbook workbook= ExcelExportUtil.exportExcel(params,Commodity.class,commodityExcel);
        ServletOutputStream outputStream=null;
        try{
            response.setHeader("content-type","application/octet-stream");
            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(
                    "商品表.xls","UTF-8"));
            outputStream=response.getOutputStream();
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
