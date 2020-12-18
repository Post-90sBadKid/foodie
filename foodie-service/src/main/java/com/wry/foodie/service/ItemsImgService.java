package com.wry.foodie.service;

import com.wry.foodie.pojo.ItemsImg;
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
public interface ItemsImgService extends IService<ItemsImg> {
    /**
     * 根据商品Id 查询商品图片列表
     *
     * @param itemId 商品Id
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品Id 查询商品主图
     *
     * @param itemId
     * @return
     */
    String quetyItemImgMainUrl(String itemId);

}
