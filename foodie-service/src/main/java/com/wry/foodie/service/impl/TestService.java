package com.wry.foodie.service.impl;

import com.wry.foodie.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/17
 */
@Service
public class TestService {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Category saveObj(Category record) {

        categoryService.saveObjParent(record);
        categoryService.saveObjChild(record);
//        int a = 1 / 0;

        return record;
    }
}
