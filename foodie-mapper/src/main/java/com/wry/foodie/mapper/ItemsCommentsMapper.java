package com.wry.foodie.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wry.foodie.pojo.ItemsComments;
import com.wry.foodie.pojo.vo.ItemCommentsVO;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface ItemsCommentsMapper extends BaseMapper<ItemsComments> {

    IPage<ItemCommentsVO> queryItemComments(IPage<ItemCommentsVO> page, @Param(Constants.WRAPPER) Wrapper<ItemCommentsVO> queryWrapper);

    IPage<ItemsComments> queryCommentsPage( IPage<ItemsComments> page, @Param(Constants.WRAPPER) Wrapper<ItemsComments> queryWrapper);
}