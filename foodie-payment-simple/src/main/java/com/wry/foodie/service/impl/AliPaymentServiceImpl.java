package com.wry.foodie.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.service.PaymentService;
import org.springframework.stereotype.Service;


/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @@since 2020/12/24
 */
@Service
public class AliPaymentServiceImpl implements PaymentService {

    @Override
    public Result<String> payment() {
        try {
            // 2. 发起API调用（以创建当面付收款二维码为例）
            AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace()
                    .preCreate("AppleiPhone11128G", System.currentTimeMillis()+"", "5799.00");
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                System.out.println("调用成功：" + response.getQrCode());
              return Result.ok(response.getQrCode(), "调用成功：" + response.getQrCode());
            } else {
                System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
                return Result.error("调用失败，原因：" + response.msg + "，" + response.subMsg);
            }
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
