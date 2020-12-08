package com.wry.foodie.service;

import com.wry.foodie.common.result.PagedGridResult;
import com.wry.foodie.pojo.ItemsComments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wry.foodie.pojo.vo.CommentCountsLevelVO;


/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface ItemsCommentsService extends IService<ItemsComments> {

    CommentCountsLevelVO queryCommentCounts(String itemId);

    PagedGridResult queryItemComments(String itemId, Integer commentLevel, Integer page, Integer pageSize);
}
