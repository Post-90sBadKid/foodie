package com.wry.foodie.service;

import com.wry.foodie.common.result.PagedGridResult;
import com.wry.foodie.pojo.Items;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wry.foodie.pojo.vo.SearchItemsVO;

import java.util.List;

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

    /**
     * 查询商品根据关键字
     * @return
     */
    PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);


    /**
     * 查询商品根据类别Id
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searchItemsByCatId(Integer catId, String sort, Integer page, Integer pageSize);
}
