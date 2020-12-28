package com.imooc.controller;

import cn.hutool.core.util.StrUtil;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.imooc.pojo.Orders;
import com.imooc.pojo.bo.MerchantOrdersBO;
import com.imooc.service.PaymentOrderService;
import com.wry.foodie.common.enums.PayMethodEnum;
import com.wry.foodie.common.enums.PaymentStatusEnum;
import com.wry.foodie.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    private final static Logger log = LoggerFactory.getLogger(PaymentController.class);

//	@Autowired
//	public RedisOperator redis;

    @Autowired
    private PaymentOrderService paymentOrderService;

    /**
     * 接受商户订单信息，保存到自己的数据库
     */
    @PostMapping("/createMerchantOrder")
    public Result createMerchantOrder(@RequestBody MerchantOrdersBO merchantOrdersBO, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String merchantOrderId = merchantOrdersBO.getMerchantOrderId();                // 订单id
        String merchantUserId = merchantOrdersBO.getMerchantUserId();            // 用户id
        Integer amount = merchantOrdersBO.getAmount();    // 实际支付订单金额
        Integer payMethod = merchantOrdersBO.getPayMethod();            // 支付方式
        String returnUrl = merchantOrdersBO.getReturnUrl();            // 支付成功后的回调地址（学生自定义）

        if (StrUtil.isBlank(merchantOrderId)) {
            return Result.error("参数[orderId]不能为空");
        }
        if (StrUtil.isBlank(merchantUserId)) {
            return Result.error("参数[userId]不能为空");
        }
        if (amount == null || amount < 1) {
            return Result.error("参数[realPayAmount]不能为空并且不能小于1");
        }
        if (payMethod == null) {
            return Result.error("参数[payMethod]不能为空并且不能小于1");
        }
        if (!payMethod.equals(PayMethodEnum.WEIXIN.type) && !payMethod.equals(PayMethodEnum.ALIPAY.type)) {
            return Result.error("参数[payMethod]目前只支持微信支付或支付宝支付");
        }
        if (StrUtil.isBlank(returnUrl)) {
            return Result.error("参数[returnUrl]不能为空");
        }

        // 保存传来的商户订单信息
        boolean isSuccess = false;
        try {
            isSuccess = paymentOrderService.createPaymentOrder(merchantOrdersBO);
        } catch (Exception e) {
            e.printStackTrace();
            Result.errorException(e.getMessage());
        }

        if (isSuccess) {
            return Result.okMsg("商户订单创建成功！");
        } else {
            return Result.error("商户订单创建失败，请重试...");
        }
    }

    /**
     * 提供给大家查询的方法，用于查询订单信息
     *
     * @param merchantOrderId
     * @param merchantUserId
     * @return
     */
    @PostMapping("getPaymentCenterOrderInfo")
    public Result getPaymentCenterOrderInfo(String merchantOrderId, String merchantUserId) {

        if (StrUtil.isBlank(merchantOrderId) || StrUtil.isBlank(merchantUserId)) {
            return Result.error("查询参数不能为空！");
        }

        Orders orderInfo = paymentOrderService.queryOrderInfo(merchantUserId, merchantOrderId);

        return Result.ok(orderInfo);
    }


//	/******************************************  以下所有方法开始支付流程   ******************************************/
//
//	/**
//	 * @Description: 微信扫码支付页面
//	 */
//	@PostMapping(value="/getWXPayQRCode")
//	public Result getWXPayQRCode(String merchantOrderId, String merchantUserId) throws Exception{
//
//		System.out.println(wxPayResource.toString());
//
//		// 根据订单ID和用户ID查询订单详情
//    	Orders waitPayOrder = paymentOrderService.queryOrderByStatus(merchantUserId, merchantOrderId, PaymentStatusEnum.WAIT_PAY.type);
//
//    	// 商品描述
//		String body = "天天吃货-付款用户[" + merchantUserId + "]";
//		// 商户订单号
//		String out_trade_no = merchantOrderId;
//		// 从redis中去获得这笔订单的微信支付二维码，如果订单状态没有支付没有就放入，这样的做法防止用户频繁刷新而调用微信接口
//		if (waitPayOrder != null) {
////			String qrCodeUrl = redis.get(wxPayResource.getQrcodeKey() + ":" + merchantOrderId);
//			String qrCodeUrl="";
//			if (StrUtil.isEmpty(qrCodeUrl)) {
//				// 订单总金额，单位为分
////				String total_fee = String.valueOf(waitPayOrder.getAmount());
//				String total_fee = "1";	// 测试用 1分钱
//
//				// 统一下单
//				PreOrderResult preOrderResult = wxOrderService.placeOrder(body, out_trade_no, total_fee);
//				qrCodeUrl = preOrderResult.getCode_url();
//			}
//
//			PaymentInfoVO paymentInfoVO = new PaymentInfoVO();
//			paymentInfoVO.setAmount(waitPayOrder.getAmount());
//			paymentInfoVO.setMerchantOrderId(merchantOrderId);
//			paymentInfoVO.setMerchantUserId(merchantUserId);
//			paymentInfoVO.setQrCodeUrl(qrCodeUrl);
//
////			redis.set(wxPayResource.getQrcodeKey() + ":" + merchantOrderId, qrCodeUrl, wxPayResource.getQrcodeExpire());
//
//			return Result.ok(paymentInfoVO);
//		} else {
//			return Result.error("该订单不存在，或已经支付");
//		}
//	}


    /**
     * @return
     * @throws Exception
     * @Description: 前往支付宝进行支付
     */
    @ResponseBody
    @RequestMapping(value = "/goAlipay")
    public Result goAlipay(String merchantOrderId, String merchantUserId) {

        // 查询订单详情
        Orders waitPayOrder = paymentOrderService.queryOrderByStatus(merchantUserId, merchantOrderId, PaymentStatusEnum.WAIT_PAY.type);
        try {
            // 调用optional扩展方法，完成可选业务参数（biz_content下的可选字段）的设置
            AlipayTradePagePayResponse response = Factory.Payment.Page()
                    .pay(waitPayOrder.getComeFrom(), waitPayOrder.getMerchantOrderId(), waitPayOrder.getAmount().toString(), waitPayOrder.getReturnUrl());
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                log.info("支付宝支付,调用成功 - 前往支付页面, alipayForm: \n{}", response.getBody());
                return Result.ok(response.getBody());
            }
            log.info("支付宝失败,调用成功 - 原因:{}", response.getBody());
            return Result.error("支付宝失败,调用成功 - 原因:{}", response.getBody());

        } catch (Exception e) {
            log.error("支付宝失败,发生异常 - 原因:{}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
