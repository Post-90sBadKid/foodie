package com.wry.foodie.common.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/28
 */
public enum PayMethodEnum {
    WEIXIN(1, "微信"),
    ALIPAY(2, "支付报");

    public final Integer type;
    public final String value;

    PayMethodEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
