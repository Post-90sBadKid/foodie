package com.wry.foodie.service;

import com.wry.foodie.pojo.ItemsParam;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface ItemsParamService extends IService<ItemsParam> {

    /**
     * 根据商品Id 查询商品参数信息
     *
     * @param itemId 商品Id
     * @return
     */
    ItemsParam queryItemsParamById(String itemId);
}
