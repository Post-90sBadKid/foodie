package com.wry.foodie.service;

import com.wry.foodie.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wry.foodie.pojo.vo.CategoryVo;
import com.wry.foodie.pojo.vo.NewItemsVo;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface CategoryService extends IService<Category> {

    /**
     * 查询所有一级分类
     *
     * @return 类别集合
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据父Id 查询子类
     *
     * @param rootCatId 父Id
     * @return
     */
    List<CategoryVo> queryCatList(Integer rootCatId);


    /**
     * 根据父Id 查询 最新6个的商品
     *
     * @param rootCatId 父Id
     * @return
     */
    List<NewItemsVo> querySixNewItemsLazy(Integer rootCatId);

}
