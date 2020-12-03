package com.wry.foodie.service;

import com.wry.foodie.pojo.Items;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface ItemsService extends IService<Items> {
    /**
     * 根据商品Id 查询商品信息
     *
     * @param itemId 商品Id
     * @return
     */
    Items queryItemById(String itemId);


}
