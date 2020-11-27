package com.wry.foodie.service.impl;

import com.wry.foodie.service.OrderStatusService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.mapper.OrderStatusMapper;
import com.wry.foodie.pojo.OrderStatus;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class OrderStatusServiceImpl extends ServiceImpl<OrderStatusMapper, OrderStatus> implements OrderStatusService {

}
