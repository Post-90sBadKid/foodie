package com.wry.foodie.api.controller;

import com.wry.foodie.common.constant.Constant;
import com.wry.foodie.common.enums.OrderStatusEnum;
import com.wry.foodie.common.enums.PayMethodEnum;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.pojo.OrderStatus;
import com.wry.foodie.pojo.bo.SubmitOrderBO;
import com.wry.foodie.pojo.vo.MerchantOrdersVO;
import com.wry.foodie.pojo.vo.OrdersVO;
import com.wry.foodie.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @Resource
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @PostMapping("/create")
    @ApiOperation("用户下单")
    public Result<String> create(@RequestBody @Validated SubmitOrderBO submitOrderBO,
                                 HttpServletRequest request, HttpServletResponse response) {
        if (!submitOrderBO.getPayMethod().equals(PayMethodEnum.ALIPAY.type) && !submitOrderBO.getPayMethod().equals(PayMethodEnum.WEIXIN.type)) {
            return Result.errorVerification("支付方式不支持！");
        }

        //1.创建订单
        OrdersVO ordersVO = ordersService.createOrder(submitOrderBO);
        //TODO 整合redis后，完善购物车中的已结算物品清除，并同步到前端cookie中
        //2.移除购物车中已提交的东西
//        CookieUtils.setCookie(request, response, Constant.FOODIE_SHOPCART, "", true);
        //3.向支付中心发送订单，用于保存支付中心得订单
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("imoocUserId", "imooc");
        httpHeaders.add("password", "imooc");

        MerchantOrdersVO merchantOrdersVO = ordersVO.getMerchantOrdersVO();
        HttpEntity<MerchantOrdersVO> httpEntity = new HttpEntity<>(merchantOrdersVO, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(Constant.PAYMENT_URL, httpEntity, String.class);
        System.out.println("=======>"+responseEntity.getBody());
        return Result.ok(ordersVO.getOrderId());
    }


    @GetMapping("/notifyMerchantOrderPaid")
    public Integer notifyMerchantOrderPaid(String merchantOrderId) {
        ordersService.updateOrderStatus(merchantOrderId, OrderStatusEnum.WAIT_DELIVER.type);
        return HttpStatus.OK.value();
    }

    @PostMapping("/getPaidOrderInfo")
    public Result getPaidOrderInfo(String orderId){
        OrderStatus orderStatus = ordersService.queryOrderStatusInfo(orderId);
        return Result.ok(orderStatus);
    }

}
