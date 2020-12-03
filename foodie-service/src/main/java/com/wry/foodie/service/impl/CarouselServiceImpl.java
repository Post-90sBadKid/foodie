package com.wry.foodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.mapper.CarouselMapper;
import com.wry.foodie.pojo.Carousel;
import com.wry.foodie.service.CarouselService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {
    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        QueryWrapper<Carousel> wrapper = new QueryWrapper<>();
        wrapper.eq("is_show", isShow);
        wrapper.orderByDesc("sort");
        return carouselMapper.selectList(wrapper);
    }
}
