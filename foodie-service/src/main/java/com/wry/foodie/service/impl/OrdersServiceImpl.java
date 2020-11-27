package com.wry.foodie.service.impl;

import com.wry.foodie.service.OrdersService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.mapper.OrdersMapper;
import com.wry.foodie.pojo.Orders;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
