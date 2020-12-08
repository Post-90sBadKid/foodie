package com.wry.foodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wry.foodie.common.enums.CommentLevelEnum;
import com.wry.foodie.common.result.PagedGridResult;
import com.wry.foodie.common.util.DesensitizationUtil;
import com.wry.foodie.pojo.vo.CommentCountsLevelVO;
import com.wry.foodie.pojo.vo.ItemCommentsVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.pojo.ItemsComments;
import com.wry.foodie.mapper.ItemsCommentsMapper;
import com.wry.foodie.service.ItemsCommentsService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;


/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class ItemsCommentsServiceImpl extends ServiceImpl<ItemsCommentsMapper, ItemsComments> implements ItemsCommentsService {
    @Resource
    private ItemsCommentsMapper itemsCommentsMapper;

    @Override
    public PagedGridResult queryItemComments(String itemId, Integer commentLevel, Integer page, Integer pageSize) {
        QueryWrapper<ItemCommentsVO> wrapper = new QueryWrapper<>();
        wrapper.eq("item_id", itemId);
        if (!Objects.isNull(commentLevel)) {
            wrapper.eq("comment_level", commentLevel);
        }
        Page<ItemCommentsVO> pageInfo = new Page<>(page, pageSize);
        IPage<ItemCommentsVO> voiPage = itemsCommentsMapper.queryItemComments(pageInfo, wrapper);
        List<ItemCommentsVO> records = voiPage.getRecords();
        for (ItemCommentsVO record : records) {
            record.setNickname(DesensitizationUtil.commonDisplay(record.getNickname()));
        }
        PagedGridResult pagedGridResult = new PagedGridResult();
        pagedGridResult.setPage(page);
        pagedGridResult.setTotal(voiPage.getPages());
        pagedGridResult.setRecords(voiPage.getTotal());
        pagedGridResult.setRows(voiPage.getRecords());
        return pagedGridResult;
    }

    @Override
    public CommentCountsLevelVO queryCommentCounts(String itemId) {
        Integer totalCounts = queryCount(itemId, null);
        Integer goodCounts = queryCount(itemId, CommentLevelEnum.GOOD.type);
        Integer normalCounts = queryCount(itemId, CommentLevelEnum.NORMAL.type);
        Integer badCounts = queryCount(itemId, CommentLevelEnum.BAD.type);

        CommentCountsLevelVO vo = new CommentCountsLevelVO();
        vo.setTotalCounts(totalCounts);
        vo.setGoodCounts(goodCounts);
        vo.setNormalCounts(normalCounts);
        vo.setBadCounts(badCounts);
        return vo;
    }

    private Integer queryCount(String itemId, Integer level) {
        QueryWrapper<ItemsComments> wrapper = new QueryWrapper<>();
        wrapper.eq("item_id", itemId);
        if (!Objects.isNull(level)) {
            wrapper.eq("comment_level", level);
        }
        return itemsCommentsMapper.selectCount(wrapper);
    }
}
