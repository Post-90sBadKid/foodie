package com.wry.foodie.common.util;

import cn.hutool.core.lang.Snowflake;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/28
 */
public class IdUtil {
    private static final Snowflake snowflake = cn.hutool.core.util.IdUtil.getSnowflake(1, 1);

    public static String getId() {
        return String.valueOf(snowflake.nextId());

    }
}
