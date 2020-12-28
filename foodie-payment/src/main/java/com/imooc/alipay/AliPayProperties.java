package com.imooc.alipay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AliPayProperties {
    /**
     * appId
     */
    @Value("${alipay.appId}")
    private String appId;
    /**
     * 商户私钥
     */
    @Value("${alipay.privateKey}")
    private String privateKey;
    /**
     * 支付宝公钥
     */
    @Value("${alipay.aliPayPublicKey}")
    private String aliPayPublicKey;
    /**
     * 协议
     */
    @Value("${alipay.protocol}")
    private String protocol;
    /**
     * 网关地址
     */
    @Value("${alipay.gatewayHost}")
    private String gatewayHost;
    /**
     * 签名方式
     */
    @Value("${alipay.signType}")
    private String signType;
    /**
     * 异步通知url
     */
    @Value("${alipay.notifyUrl}")
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
