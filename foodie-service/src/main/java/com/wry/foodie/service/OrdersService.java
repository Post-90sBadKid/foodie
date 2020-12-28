package com.wry.foodie.service;

import com.wry.foodie.pojo.OrderStatus;
import com.wry.foodie.pojo.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wry.foodie.pojo.bo.SubmitOrderBO;
import com.wry.foodie.pojo.vo.OrdersVO;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface OrdersService extends IService<Orders> {

    /**
     * 创建订单信息
     *
     * @param submitOrderBO
     */
    OrdersVO createOrder(SubmitOrderBO submitOrderBO);


    /**
     * 更新订单状态
     *
     * @param orderId
     * @param status
     */
    void updateOrderStatus(String orderId, Integer status);


    /**
     * 查询订单状态
     *
     * @param orderId
     * @return
     */
    OrderStatus queryOrderStatusInfo(String orderId);
}
