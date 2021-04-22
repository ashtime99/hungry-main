package com.ash.server.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.http.server.HttpServerResponse;
import com.ash.server.pojo.*;
import com.ash.server.service.ICategoryService;
import com.ash.server.service.ICommodityService;
import com.ash.server.util.OfficeExportUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 商品管理API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/29 12:08
 */
@RestController
@RequestMapping("/commodity")
@ApiSupport(order = 7)
@Api(tags = "商品管理API")
public class CommodityController {

    @Autowired
    private ICommodityService commodityService;
    @Autowired
    private ICategoryService categoryService;


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
            return RespBean.success("商品冻结状态更新成功!");
        }
        return RespBean.error("商品冻结状态更新失败!");
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

    @ApiOperation("批量删除商品")
    @DeleteMapping("/")
    public RespBean deleteCommodity(@RequestParam Integer[] commodityIds){
        if (commodityService.removeByIds(Arrays.asList(commodityIds))){
            return RespBean.success("批量删除成功！");
        }
        return RespBean.error("批量删除失败！");
    }

    @ApiOperation("导出商品数据")
    @GetMapping(value = "/export",produces ="application/octet-stream")
    public void exportCommodity(HttpServletResponse response){
        List<Commodity> commodityExcel = commodityService.getCommodityExcel(null);
        OfficeExportUtil.exportExcel(OfficeExportUtil.getWorkbook("商品列表", "商品列表", Commodity.class, commodityExcel), "商品列表", response);
//        ExportParams params=new ExportParams("商品表","商品表", ExcelType.HSSF);
//        Workbook workbook= ExcelExportUtil.exportExcel(params,Commodity.class,commodityExcel);
//        ServletOutputStream outputStream=null;
//        try{
//            response.setHeader("content-type","application/octet-stream");
//            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(
//                    "商品表.xls","UTF-8"));
//            outputStream=response.getOutputStream();
//            workbook.write(outputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (null!=outputStream){
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    @ApiOperation("导入商品数据")
    @GetMapping(value = "/import")
    public void importCommodity(MultipartFile file){
        ImportParams params=new ImportParams();
        //去掉标题行
        params.setTitleRows(1);
        List<Category>categoryList=categoryService.list();
        try {
            List<Commodity>list=ExcelImportUtil.importExcel(file.getInputStream(),Commodity.class,params);
            list.forEach(commodity -> {
                commodity.setCategoryId(
                        categoryList.get(categoryList.indexOf(new Category(commodity.getCategory().getCategoryName())))
                                .getCategoryId());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
