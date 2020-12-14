package com.wry.foodie.api.controller;

import cn.hutool.core.util.StrUtil;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.pojo.UserAddress;
import com.wry.foodie.pojo.bo.AddressBO;
import com.wry.foodie.pojo.bo.ShopcartBO;
import com.wry.foodie.service.UserAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 用户在确认订单页面，可以对收货地址进行如下操作
 * 1.查询用户的的所有收获地址
 * 2.新增收获地址
 * 3.删除收货地址
 * 4.修改收货地址
 * 5.设置默认收获地址
 * </p>
 *
 * @author wangruiyu
 * @since 2020/12/9
 */
@Api(tags = "收获地址相关接口")
@Validated
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private UserAddressService userAddressService;

    @PostMapping("/list")
    @ApiOperation("当前登录者的所有收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", defaultValue = "1", required = true),
    })
    public Result queryAll(@RequestParam @NotNull String userId) {
        List<UserAddress> list = userAddressService.queryAll(userId);
        return Result.ok(list);
    }

    @PostMapping("/add")
    @ApiOperation("新增收货地址")
    public Result add(@RequestBody AddressBO addressBO) {
        boolean flag = userAddressService.addNewUserAddress(addressBO);
        return Result.ok(flag);
    }

    @PostMapping("/update")
    @ApiOperation("修改收货地址")
    public Result update(@RequestBody AddressBO addressBO) {
        boolean flag = userAddressService.updateUserAddress(addressBO);
        return Result.ok(flag);
    }

    @PostMapping("/setDefalut")
    @ApiOperation("设置默认地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "addressId", value = "收货地址Id", defaultValue = "1", required = true),
    })
    public Result setDefalut(@RequestParam @NotNull String userId,
                             @RequestParam @NotNull String addressId) {
        boolean flag = userAddressService.setDefalut(userId,addressId);
        return Result.ok(flag);
    }

    @PostMapping("/delete")
    @ApiOperation("设置默认地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "addressId", value = "收货地址Id", defaultValue = "1", required = true),
    })
    public Result delete(@RequestParam @NotNull String userId,
                         @RequestParam @NotNull String addressId) {
        boolean flag = userAddressService.delete(userId,addressId);
        return Result.ok(flag);
    }
}
