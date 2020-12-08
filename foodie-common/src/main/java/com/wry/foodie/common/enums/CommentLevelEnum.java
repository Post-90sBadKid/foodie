package com.wry.foodie.common.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/28
 */
public enum CommentLevelEnum {
    GOOD(1, "好评"),
    NORMAL(2, "中评"),
    BAD(3, "差评");

    public final Integer type;
    public final String value;

    CommentLevelEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
