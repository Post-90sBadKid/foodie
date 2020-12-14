package com.wry.foodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wry.foodie.common.result.PagedGridResult;
import com.wry.foodie.pojo.vo.SearchItemsVO;
import com.wry.foodie.pojo.vo.ShopcartVO;
import com.wry.foodie.service.ItemsService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.pojo.Items;
import com.wry.foodie.mapper.ItemsMapper;

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
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements ItemsService {
    @Resource
    private ItemsMapper itemsMapper;

    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectById(itemId);
    }

    @Override
    public PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize) {
        QueryWrapper<SearchItemsVO> wrapper = new QueryWrapper<>();
        wrapper.like("i.item_name", keywords);
        if (sort.equals("c")) {
            wrapper.orderByDesc("sell_counts");
        } else if (sort.equals("p")) {
            wrapper.orderByAsc("price");
        } else {
            wrapper.orderByAsc("i.item_name");
        }
        Page<SearchItemsVO> pageInfo = new Page<>(page, pageSize);
        IPage<SearchItemsVO> voiPage = itemsMapper.searchItems(pageInfo, wrapper);
        PagedGridResult pagedGridResult = new PagedGridResult();
        pagedGridResult.setPage(voiPage.getCurrent());
        pagedGridResult.setTotal(voiPage.getPages());
        pagedGridResult.setRecords(voiPage.getTotal());
        pagedGridResult.setRows(voiPage.getRecords());
        return pagedGridResult;
    }

    @Override
    public PagedGridResult searchItemsByCatId(Integer catId, String sort, Integer page, Integer pageSize) {
        QueryWrapper<SearchItemsVO> wrapper = new QueryWrapper<>();
        wrapper.like("i.cat_id", catId);
        if (sort.equals("c")) {
            wrapper.orderByDesc("sell_counts");
        } else if (sort.equals("p")) {
            wrapper.orderByAsc("price");
        } else {
            wrapper.orderByAsc("i.item_name");
        }
        Page<SearchItemsVO> pageInfo = new Page<>(page, pageSize);
        IPage<SearchItemsVO> voiPage = itemsMapper.searchItems(pageInfo, wrapper);
        PagedGridResult pagedGridResult = new PagedGridResult();
        pagedGridResult.setPage(voiPage.getCurrent());
        pagedGridResult.setTotal(voiPage.getPages());
        pagedGridResult.setRecords(voiPage.getTotal());
        pagedGridResult.setRows(voiPage.getRecords());
        return pagedGridResult;
    }

    @Override
    public List<ShopcartVO> queryItemsBySpecIds(List<String> specIdList) {
        QueryWrapper<ShopcartVO> wrapper = new QueryWrapper<>();
        wrapper.in("s.id",specIdList);
        return itemsMapper.queryItemsBySpecIds(wrapper);
    }
}
