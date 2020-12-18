package com.wry.foodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wry.foodie.common.enums.YesOrNoEnum;
import com.wry.foodie.service.ItemsImgService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.mapper.ItemsImgMapper;
import com.wry.foodie.pojo.ItemsImg;

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
public class ItemsImgServiceImpl extends ServiceImpl<ItemsImgMapper, ItemsImg> implements ItemsImgService {
    @Resource
    private ItemsImgMapper itemsImgMapper;

    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        QueryWrapper<ItemsImg> wrapper = new QueryWrapper<>();
        wrapper.eq("item_id", itemId);
        return itemsImgMapper.selectList(wrapper);
    }

    @Override
    public String quetyItemImgMainUrl(String itemId) {
        QueryWrapper<ItemsImg> wrapper = new QueryWrapper<>();
        wrapper.eq("is_main", YesOrNoEnum.YES.type);
        wrapper.eq("item_id", itemId);
        ItemsImg itemsImg = itemsImgMapper.selectOne(wrapper);
        return itemsImg != null ? itemsImg.getUrl():"";
    }
}
