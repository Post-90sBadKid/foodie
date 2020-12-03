package com.wry.foodie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wry.foodie.pojo.Category;
import com.wry.foodie.pojo.vo.CategoryVo;
import com.wry.foodie.pojo.vo.NewItemsVo;
import org.apache.ibatis.annotations.Param;

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
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryVo> getSubCatList(Integer rootCatId);

    List<NewItemsVo> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> paramsMap);
}