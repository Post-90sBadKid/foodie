package com.wry.foodie.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayPayConfig {

    @Bean
    public Config getConfig(@Autowired AliPayAccountConfig properties) {
        Config config = new Config();
        // 网关协议
        config.protocol = properties.getProtocol().trim();
        // 网关地址
        config.gatewayHost = properties.getGatewayHost().trim();
        // 密钥加密方式
        config.signType = properties.getSignType().trim();

        // 应用识别码APPID
        config.appId = properties.getAppId().trim();
        // 应用私钥
        config.merchantPrivateKey = properties.getPrivateKey().trim();

//        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
//        config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
//        config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
//        config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = properties.getAliPayPublicKey().trim();

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = properties.getNotifyUrl();
        //Factory全局只需配置一次
        Factory.setOptions(config);
        return config;
    }
}
