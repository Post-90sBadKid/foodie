package com.imooc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.imooc.mapper.OrdersMapper;
import com.imooc.pojo.Orders;
import com.imooc.pojo.bo.MerchantOrdersBO;
import com.imooc.service.PaymentOrderService;
import com.wry.foodie.common.enums.PaymentStatusEnum;
import com.wry.foodie.common.enums.YesOrNoEnum;
import com.wry.foodie.common.util.IdUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

	@Autowired
	private OrdersMapper ordersMapper;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean createPaymentOrder(MerchantOrdersBO merchantOrdersBO) {

		String id = IdUtil.getId();

		Orders paymentOrder = new Orders();
		BeanUtils.copyProperties(merchantOrdersBO, paymentOrder);

		paymentOrder.setId(id);
		paymentOrder.setPayStatus(PaymentStatusEnum.WAIT_PAY.type);
		paymentOrder.setComeFrom("天天吃货");
		paymentOrder.setIsDelete(YesOrNoEnum.NO.type);
		paymentOrder.setCreatedTime(new Date());

		int result = ordersMapper.insert(paymentOrder);
		return result == 1 ? true : false;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public Orders queryOrderByStatus(String merchantUserId, String merchantOrderId, Integer orderStatus) {

		QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("merchant_order_id",merchantOrderId);
		queryWrapper.eq("merchant_user_id",merchantUserId);
		queryWrapper.eq("pay_status",orderStatus);
		Orders waitPayOrder = ordersMapper.selectOne(queryWrapper);

		return waitPayOrder;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public String updateOrderPaid(String merchantOrderId, Integer paidAmount) {

//		Example example = new Example(Orders.class);
//		Example.Criteria criteria = example.createCriteria();
//		criteria.andEqualTo("merchantOrderId", merchantOrderId);
//
//		Orders paidOrder = new Orders();
//		paidOrder.setPayStatus(PaymentStatus.PAID.type);
//		paidOrder.setAmount(paidAmount);
//
//		int result = ordersMapper.updateByExampleSelective(paidOrder, example);

		Orders entity = new Orders();
		entity.setMerchantOrderId(merchantOrderId);

		UpdateWrapper<Orders> wrapper = new UpdateWrapper<>();
		wrapper.set("amount",paidAmount);
		wrapper.set("pay_status",PaymentStatusEnum.PAID.type);

		ordersMapper.update(entity,wrapper);
		return queryMerchantReturnUrl(merchantOrderId);
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	String queryMerchantReturnUrl(String merchantOrderId) {

		QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("merchant_order_id",merchantOrderId);
		Orders order = ordersMapper.selectOne(queryWrapper);

		return order.getReturnUrl();
	}

	@Override
	public Orders queryOrderInfo(String merchantUserId, String merchantOrderId) {
		QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("merchant_order_id",merchantOrderId);
		queryWrapper.eq("merchant_user_id",merchantUserId);
		return ordersMapper.selectOne(queryWrapper);
	}
}
