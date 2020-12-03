package com.wry.foodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wry.foodie.service.ItemsSpecService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.mapper.ItemsSpecMapper;
import com.wry.foodie.pojo.ItemsSpec;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class ItemsSpecServiceImpl extends ServiceImpl<ItemsSpecMapper, ItemsSpec> implements ItemsSpecService {
    @Resource
    private ItemsSpecMapper itemsSpecMapper;

    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        QueryWrapper<ItemsSpec> wrapper = new QueryWrapper<>();
        wrapper.eq("item_id", itemId);
        return itemsSpecMapper.selectList(wrapper);
    }
}
