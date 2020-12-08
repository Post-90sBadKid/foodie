package com.wry.foodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wry.foodie.pojo.vo.CategoryVo;
import com.wry.foodie.pojo.vo.NewItemsVO;
import com.wry.foodie.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.pojo.Category;
import com.wry.foodie.mapper.CategoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootLevelCat() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("type", 1);
        wrapper.orderByAsc("id");
        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<CategoryVo> queryCatList(Integer rootCatId) {
        return categoryMapper.getSubCatList(rootCatId);
    }

    @Override
    public List<NewItemsVO> querySixNewItemsLazy(Integer rootCatId) {
        Map<String, Object> map = new HashMap<>();
        map.put("rootCatId",rootCatId);
        return categoryMapper.getSixNewItemsLazy(map);
    }
}
