package com.wry.foodie.service.impl;

import com.wry.foodie.service.ItemsService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.pojo.Items;
import com.wry.foodie.mapper.ItemsMapper;

import javax.annotation.Resource;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements ItemsService {
    @Resource
    private ItemsMapper itemsMapper;

    @Override
    public Items queryItemById(String itemId) {
        return  itemsMapper.selectById(itemId);
    }
}
