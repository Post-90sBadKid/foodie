package com.wry.foodie.service;

import com.wry.foodie.pojo.Carousel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface CarouselService extends IService<Carousel> {

    /**
     * 查询所有轮播图
     *
     * @param isShow 是否显示
     * @return
     */
    List<Carousel> queryAll(Integer isShow);


}
