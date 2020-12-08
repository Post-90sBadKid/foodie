package com.wry.foodie.api.controller;

import com.wry.foodie.common.result.PagedGridResult;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.pojo.Items;
import com.wry.foodie.pojo.ItemsImg;
import com.wry.foodie.pojo.ItemsParam;
import com.wry.foodie.pojo.ItemsSpec;
import com.wry.foodie.pojo.vo.CommentCountsLevelVO;
import com.wry.foodie.pojo.vo.ItemInfoVO;
import com.wry.foodie.service.*;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Api(value = "商品详情", tags = "商品详情的相关接口")
@RestController
@Validated
@RequestMapping("/items")
public class ItemsController {
    @Resource
    private ItemsImgService itemsImgService;
    @Resource
    private ItemsParamService itemsParamService;
    @Resource
    private ItemsSpecService itemsSpecService;
    @Resource
    private ItemsService itemsService;
    @Resource
    private ItemsCommentsService itemsCommentsService;

    @ApiOperation(value = "查询商品详情")
    @ApiParam(name = "itemId", value = "商品Id", defaultValue = "cake-1001", required = true)
    @GetMapping("/info/{itemId}")
    public Result info(@PathVariable @NotNull String itemId) {
        Items item = itemsService.queryItemById(itemId);
        List<ItemsImg> itemsImgList = itemsImgService.queryItenImgList(itemId);
        ItemsParam itemsParam = itemsParamService.queryItemsParamById(itemId);
        List<ItemsSpec> itemsSpecList = itemsSpecService.queryItemSpecList(itemId);
        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(item);
        itemInfoVO.setItemImgList(itemsImgList);
        itemInfoVO.setItemSpecList(itemsSpecList);
        itemInfoVO.setItemParams(itemsParam);
        return Result.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品评价总数")
    @ApiParam(name = "itemId", value = "商品Id", defaultValue = "cake-1001", required = true)
    @GetMapping("/commentLevel")
    public Result commentCounts(@RequestParam @NotNull String itemId) {
        CommentCountsLevelVO vo = itemsCommentsService.queryCommentCounts(itemId);
        return Result.ok(vo);
    }

    @ApiOperation(value = "查询商品评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemId", value = "商品Id", defaultValue = "cake-1001", required = true),
            @ApiImplicitParam(name = "level", value = "评价等级", defaultValue = "1", required = false),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示的数量", defaultValue = "5", required = true)
    })
    @GetMapping("/comments")
    public Result comment(@RequestParam @NotNull String itemId,
                          @RequestParam Integer level,
                          @RequestParam @NotNull Integer page,
                          @RequestParam @NotNull Integer pageSize
    ) {
        PagedGridResult pagedGridResult = itemsCommentsService.queryItemComments(itemId, level, page, pageSize);
        return Result.ok(pagedGridResult);
    }

    @ApiOperation(value = "查询商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keywords", value = "关键字", defaultValue = "cake-1001", required = true),
            @ApiImplicitParam(name = "sort", value = "排序", defaultValue = "c", required = false),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示的数量", defaultValue = "5", required = true)
    })
    @GetMapping("/search")
    public Result search(@RequestParam @NotNull String keywords,
                          @RequestParam  String sort,
                          @RequestParam @NotNull Integer page,
                          @RequestParam @NotNull Integer pageSize
    ) {
        PagedGridResult pagedGridResult = itemsService.searchItems(keywords, sort, page, pageSize);
        return Result.ok(pagedGridResult);
    }

    @ApiOperation(value = "查询商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catId", value = "商品类别Id", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "sort", value = "排序", defaultValue = "c", required = false),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示的数量", defaultValue = "5", required = true)
    })
    @GetMapping("/catItems")
    public Result searchCatId(@RequestParam @NotNull Integer catId,
                         @RequestParam  String sort,
                         @RequestParam @NotNull Integer page,
                         @RequestParam @NotNull Integer pageSize
    ) {
        PagedGridResult pagedGridResult = itemsService.searchItemsByCatId(catId, sort, page, pageSize);
        return Result.ok(pagedGridResult);
    }
}
