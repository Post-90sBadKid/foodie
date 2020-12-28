package com.wry.foodie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wechat")
@PropertySource("classpath:payment.yml")
public class WechatAccountConfig {
    /**
     * app应用appid
     * 获取地址 https://open.weixin.qq.com
     */
    @Value("${appId}")
    private String appId;

    /**
     * 商户号
     * 获取地址 https://pay.weixin.qq.com
     */
    @Value("${mchId}")
    private String mchId;

    /**
     * 商户密钥
     */
    @Value("${mchKey}")
    private String mchKey;

    /**
     * 商户证书路径
     */
    @Value("${keyPath}")
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    @Value("${notifyUrl}")
    private String notifyUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
