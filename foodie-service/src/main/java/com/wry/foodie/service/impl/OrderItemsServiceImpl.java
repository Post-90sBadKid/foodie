package com.wry.foodie.service.impl;

import com.wry.foodie.service.OrderItemsService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.mapper.OrderItemsMapper;
import com.wry.foodie.pojo.OrderItems;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItems> implements OrderItemsService {

}
