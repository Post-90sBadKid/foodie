package com.wry.foodie.service.impl;

import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.config.WechatAccountConfig;
import com.wry.foodie.service.PaymentService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PrivateKey;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @@since 2020/12/24
 */
@Service
public class WxPaymentServiceImpl implements PaymentService {

    @Override
    public Result payment() {

        return null;
    }
}
