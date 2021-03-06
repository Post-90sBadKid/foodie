package com.wry.foodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wry.foodie.service.ItemsParamService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.mapper.ItemsParamMapper;
import com.wry.foodie.pojo.ItemsParam;

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
public class ItemsParamServiceImpl extends ServiceImpl<ItemsParamMapper, ItemsParam> implements ItemsParamService {
    @Resource
    private ItemsParamMapper  itemsParamMapper;

    @Override
    public ItemsParam queryItemsParamById(String itemId) {
        QueryWrapper<ItemsParam> wrapper = new QueryWrapper<>();
        wrapper.eq("item_id",itemId);
        return itemsParamMapper.selectOne(wrapper);
    }
}
