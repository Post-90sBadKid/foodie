package com.wry.foodie.api.controller;

import cn.hutool.core.util.StrUtil;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.pojo.bo.ShopcartBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/12/8
 */
@Api(tags = "购物车相关接口")
@RestController
@RequestMapping("/shopcart")
public class ShopcartController {

    @PostMapping("/add")
    @ApiOperation("添加商品到购物车")
    public Result add(@RequestParam String userId,
                      @RequestBody ShopcartBO shopcartBO,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        System.out.println("====>"+shopcartBO);
        if (StrUtil.isEmpty(userId)) {
            return Result.error("");
        }
        //TODO 前端用户在登录的情况下，添加商品到购物出，会同时在后端同步购物车到redis缓存中

        return Result.ok();
    }

    @PostMapping("/del")
    @ApiOperation("从购物车删除商品")
    public Result add(@RequestParam @NotNull String userId,
                      @RequestParam @NotNull String itemSpecId) {
        if (StrUtil.isEmpty(userId)||StrUtil.isEmpty(itemSpecId)) {
            return Result.error("");
        }
        //TODO 用户在页面从购物车删除商品，会同时在后端购物车中同步删除

        return Result.ok();
    }
}
