package com.wry.foodie.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wry.foodie.pojo.Items;
import com.wry.foodie.pojo.vo.SearchItemsVO;
import com.wry.foodie.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface ItemsMapper extends BaseMapper<Items> {

    IPage<SearchItemsVO> searchItems(IPage<SearchItemsVO> page, @Param(Constants.WRAPPER) Wrapper<SearchItemsVO> queryWrapper);

   List<ShopcartVO> queryItemsBySpecIds(@Param(Constants.WRAPPER) Wrapper<ShopcartVO> queryWrapper);
}