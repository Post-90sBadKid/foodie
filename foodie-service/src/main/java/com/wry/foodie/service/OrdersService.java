package com.wry.foodie.service;

import com.wry.foodie.pojo.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wry.foodie.pojo.bo.SubmitOrderBO;

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
    void createOrder(SubmitOrderBO submitOrderBO);


}
