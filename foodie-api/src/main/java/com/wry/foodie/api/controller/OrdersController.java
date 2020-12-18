package com.wry.foodie.api.controller;

import com.wry.foodie.common.constant.Constant;
import com.wry.foodie.common.enums.PayMethodEnum;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.common.util.CookieUtils;
import com.wry.foodie.pojo.UserAddress;
import com.wry.foodie.pojo.bo.AddressBO;
import com.wry.foodie.pojo.bo.SubmitOrderBO;
import com.wry.foodie.service.OrdersService;
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
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/12/14
 */
@Api(tags = "订单相关接口")

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @PostMapping("/create")
    @ApiOperation("用户下单")
    public Result create(@RequestBody @Validated SubmitOrderBO submitOrderBO,
                         HttpServletRequest request, HttpServletResponse response) {
        if (!submitOrderBO.getPayMethod().equals(PayMethodEnum.ALIPAY.type) && !submitOrderBO.getPayMethod().equals(PayMethodEnum.WEIXIN.type)) {
            return Result.errorVerification("支付方式不支持！");
        }

        //1.创建订单
        ordersService.createOrder(submitOrderBO);
        //TODO 整合redis后，完善购物车中的已结算物品清除，并同步到前端cookie中
        //2.移除购物车中已提交的东西
        CookieUtils.setCookie(request, response, Constant.FOODIE_SHOPCART, "", true);
        //3.向支付中心发送订单，用于保存支付中心得订单

        return Result.ok();
    }

}
