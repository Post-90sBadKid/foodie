package com.wry.foodie.common.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/28
 */
public enum SexEnum {
    WOMAN(0, "女"),
    MAN(1, "男"),
    SECRET(2, "保密");

    public final Integer type;
    public final String value;

    SexEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
