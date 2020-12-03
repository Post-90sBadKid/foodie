package com.wry.foodie.api.controller;

import com.wry.foodie.common.enums.YesOrNoEnum;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.pojo.Carousel;
import com.wry.foodie.pojo.Category;
import com.wry.foodie.pojo.vo.CategoryVo;
import com.wry.foodie.service.CarouselService;
import com.wry.foodie.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/29
 */
@Api(value = "首页", tags = "首页展示的相关接口")
@RestController
@RequestMapping("/index")
public class IndexController {
    @Resource
    private CarouselService carouselService;
    @Resource
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public Result<Carousel> carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNoEnum.YES.type);
        return Result.ok(list);
    }

    /**
     * 首页分类展示需求
     * 1.先查询一级大分类
     * 2.当鼠标悬浮大分类,再查询其子分类数据(懒加载)
     */
    @ApiOperation(value = "首页一级分类")
    @GetMapping("/cats")
    public Result<Category> cats() {
        List<Category> categories = categoryService.queryAllRootLevelCat();
        return Result.ok(categories);
    }

    @ApiOperation(value = "首页子集分类")
    @ApiParam(name = "rootCatId", value = "一级分类Id", defaultValue = "1", required = true, type = "Integer")
    @GetMapping("/subCat/{rootCatId}")
    public Result<Category> subCats(@PathVariable Integer rootCatId) {
        if (Objects.isNull(rootCatId)) {
            return Result.error("分类不存在! ");
        }
        List<CategoryVo> list = categoryService.queryCatList(rootCatId);
        return Result.ok(list);
    }

    @ApiOperation(value = "查询每个一级分类下的最新的6个商品数据")
    @ApiParam(name = "rootCatId", value = "一级分类Id", defaultValue = "1", required = true, type = "Integer")
    @GetMapping("/sixNewItems/{rootCatId}")
    public Result querySixNewItemsLazy(@PathVariable Integer rootCatId) {
        if (Objects.isNull(rootCatId)) {
            return Result.error("分类不存在! ");
        }
        List list = categoryService.querySixNewItemsLazy(rootCatId);
        return Result.ok(list);
    }

}
