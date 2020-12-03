package com.wry.foodie.common.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/28
 */
public enum YesOrNoEnum {
    NO(0, "否"),
    YES(1, "是");

    public final Integer type;
    public final String value;

    YesOrNoEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
