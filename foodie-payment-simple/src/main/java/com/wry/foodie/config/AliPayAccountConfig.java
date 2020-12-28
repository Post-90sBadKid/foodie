package com.wry.foodie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alipay")
@PropertySource("classpath:payment.yml")
public class AliPayAccountConfig {
    /**
     * appId
     */
    @Value("${appId}")
    private String appId;
    /**
     * 商户私钥
     */
    @Value("${privateKey}")
    private String privateKey;
    /**
     * 支付宝公钥
     */
    @Value("${aliPayPublicKey}")
    private String aliPayPublicKey;
    /**
     * 协议
     */
    @Value("${protocol}")
    private String protocol;
    /**
     * 网关地址
     */
    @Value("${gatewayHost}")
    private String gatewayHost;
    /**
     * 签名方式
     */
    @Value("${signType}")
    private String signType;
    /**
     * 异步通知url
     */
    @Value("${notifyUrl}")
    private String notifyUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAliPayPublicKey() {
        return aliPayPublicKey;
    }

    public void setAliPayPublicKey(String aliPayPublicKey) {
        this.aliPayPublicKey = aliPayPublicKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getGatewayHost() {
        return gatewayHost;
    }

    public void setGatewayHost(String gatewayHost) {
        this.gatewayHost = gatewayHost;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
