package com.wry.foodie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wry.foodie.pojo.ItemsSpec;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface ItemsSpecMapper extends BaseMapper<ItemsSpec> {

    int decreaseItemSpecStock(@Param("itemSpecId") String itemSpecId, @Param("buyCounts") Integer buyCounts);
}