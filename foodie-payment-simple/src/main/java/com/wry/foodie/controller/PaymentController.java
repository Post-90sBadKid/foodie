package com.wry.foodie.controller;

import com.alipay.easysdk.factory.Factory;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.alipay.easysdk.kernel.util.JsonUtil;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.service.PaymentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/12/24
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource(name = "aliPaymentServiceImpl")
    private PaymentService paymentService;

    /**
     * 支付宝 - 当面支付
     *
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/alipay/faceToface")
    public Result<String> alipay(HttpServletResponse response) throws IOException {
        Result<String> result = paymentService.payment();
        OutputStream outputStream = response.getOutputStream();
        QrCodeUtil.generate(result.getData(), 300, 300, "png", outputStream);
        return result;
    }

    /**
     * 支付宝 - 当面支付 - 异步回调
     *
     * @param request
     */
    @PostMapping(value = "/alipay/faceToface/notify")
    public Result notify(HttpServletRequest request) {
        Map<String, String> aliPayNotifyParameterMap = getAliPayNotifyParameterMap(request);
        System.out.println("回调成功! 回调参数:" + aliPayNotifyParameterMap);
        return Result.ok("回调成功！");
    }

    @GetMapping("/hello")
    public Result hello() {
        return Result.okMsg("hello world");
    }

    /**
     * 获取支付宝POST方法回调URL过来的参数
     *
     * @param request
     */
    private Map<String, String> getAliPayNotifyParameterMap(HttpServletRequest request) {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String str : requestParams.keySet()) {
            String name = str;
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            signVerified = Factory.Payment.Common().verifyNotify(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //验证成功
        if(signVerified) {
            System.out.println("验证成功！");
        }else{
            System.out.println("验证失败！");
        }
        return params;
    }
}
