package com.wry.foodie.service;

import com.wry.foodie.pojo.ItemsSpec;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface ItemsSpecService extends IService<ItemsSpec> {
    /**
     * 根据商品Id  查询商品详情信息
     * @param itemId 商品Id
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

}
