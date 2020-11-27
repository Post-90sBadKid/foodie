package com.wry.foodie.service.impl;

import com.wry.foodie.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.pojo.Category;
import com.wry.foodie.mapper.CategoryMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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



    @Transactional(propagation = Propagation.NEVER,rollbackFor = Exception.class)
    public void saveObjChild(Category record) {
        saveObjChild1(record);
        int a = 1 / 0;
        saveObjChild2(record);
    }

    public Category saveObjParent(Category record) {
        record.setSlogan("parent1");
        record.setName("parent1");
        categoryMapper.insert(record);
        return record;
    }

    public Category saveObjChild1(Category record) {
        record.setSlogan("Child1");
        record.setName("Child1");
        categoryMapper.insert(record);
        return record;
    }

    public Category saveObjChild2(Category record) {
        record.setSlogan("Child2");
        record.setName("Child2");
        categoryMapper.insert(record);
        return record;
    }
}
