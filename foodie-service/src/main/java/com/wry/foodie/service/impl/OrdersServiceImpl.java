package com.wry.foodie.service.impl;

import com.wry.foodie.common.constant.Constant;
import com.wry.foodie.common.enums.OrderStatusEnum;
import com.wry.foodie.common.enums.YesOrNoEnum;
import com.wry.foodie.common.util.IdUtil;
import com.wry.foodie.mapper.*;
import com.wry.foodie.pojo.*;
import com.wry.foodie.pojo.bo.SubmitOrderBO;
import com.wry.foodie.pojo.vo.MerchantOrdersVO;
import com.wry.foodie.pojo.vo.OrdersVO;
import com.wry.foodie.service.ItemsImgService;
import com.wry.foodie.service.ItemsService;
import com.wry.foodie.service.OrdersService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private UserAddressMapper userAddressMapper;
    @Resource
    private ItemsSpecMapper itemsSpecMapper;
    @Resource
    private ItemsService itemsService;
    @Resource
    private OrderItemsMapper orderItemsMapper;
    @Resource
    private OrderStatusMapper orderStatusMapper;
    @Resource
    private ItemsImgService itemsImgService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public OrdersVO createOrder(SubmitOrderBO submitOrderBO) {
        String userId = submitOrderBO.getUserId();
        String addressId = submitOrderBO.getAddressId();
        String itemSpecIds = submitOrderBO.getItemSpecIds();
        Integer payMethod = submitOrderBO.getPayMethod();
        String leftMsg = submitOrderBO.getLeftMsg();
        Integer postAmount = 0;
        //地址信息
        UserAddress userAddress = userAddressMapper.selectById(addressId);

        String orderId = IdUtil.getId();
        //1.新订单数据保存
        Orders orders = new Orders();
        orders.setId(orderId);
        orders.setUserId(userId);
        orders.setReceiverName(userAddress.getReceiver());
        orders.setReceiverMobile(userAddress.getMobile());
        orders.setReceiverAddress(userAddress.getProvince() + " " + userAddress.getCity() + " " + userAddress.getDetail());
        orders.setPostAmount(postAmount);
        orders.setPayMethod(payMethod);
        orders.setLeftMsg(leftMsg);
        orders.setCreatedTime(new Date());
        orders.setUpdatedTime(new Date());
        orders.setIsComment(YesOrNoEnum.NO.type);
        orders.setIsDelete(YesOrNoEnum.NO.type);
        Integer totalAmount = 0;
        Integer realPayAmount = 0;


        //2.循环规格Id ，保存订单商品表
        //2.1 根据Id 查询规格的具体信息，主要获取价格
        String[] itemSpecIdArray = itemSpecIds.split(",");
        List<ItemsSpec> itemsSpecList = itemsSpecMapper.selectBatchIds(Arrays.asList(itemSpecIdArray));

        Integer buyCounts = null;
        OrderItems orderItem = null;
        String itemId = null;
        Items items = null;
        String imgMainUrl = null;
        for (ItemsSpec itemsSpec : itemsSpecList) {
            //TODO 整合Redis 后商品购买的数量重新从redis中获取
            buyCounts = 1;

            totalAmount += itemsSpec.getPriceNormal() * buyCounts;
            realPayAmount += itemsSpec.getPriceDiscount() * buyCounts;

            //2.2 根据商品Id 查询商品信息以及商品图片
            itemId = itemsSpec.getItemId();
            items = itemsService.queryItemById(itemId);
            imgMainUrl = itemsImgService.quetyItemImgMainUrl(itemId);

            orderItem = new OrderItems();
            orderItem.setId(IdUtil.getId());
            orderItem.setOrderId(orderId);
            orderItem.setItemId(items.getId());
            orderItem.setItemImg(imgMainUrl);
            orderItem.setItemName(items.getItemName());
            orderItem.setItemSpecId(itemsSpec.getId());
            orderItem.setItemSpecName(itemsSpec.getName());
            orderItem.setPrice(itemsSpec.getPriceDiscount());
            orderItem.setBuyCounts(buyCounts);
            orderItemsMapper.insert(orderItem);

            //2.4 减库存
            itemsService.decreaseItemSpecStock(itemsSpec.getId(), buyCounts);
        }
        orders.setTotalAmount(totalAmount);
        orders.setRealPayAmount(realPayAmount);
        ordersMapper.insert(orders);
        //3.保存订单状态表
        OrderStatus waitPayOrderStatus = new OrderStatus();
        waitPayOrderStatus.setOrderId(orderId);
        waitPayOrderStatus.setOrderStatus(OrderStatusEnum.WAIT_PAY.type);
        waitPayOrderStatus.setCreatedTime(new Date());
        waitPayOrderStatus.setPayTime(new Date());
        waitPayOrderStatus.setDeliverTime(new Date());
        waitPayOrderStatus.setSuccessTime(new Date());
        waitPayOrderStatus.setCloseTime(new Date());
        waitPayOrderStatus.setCommentTime(new Date());
        orderStatusMapper.insert(waitPayOrderStatus);

        //4.构建商户订单传递支付中心
        MerchantOrdersVO merchantOrdersVO=new MerchantOrdersVO();
        merchantOrdersVO.setMerchantOrderId(orderId);
        merchantOrdersVO.setMerchantUserId(userId);
        merchantOrdersVO.setAmount(realPayAmount+postAmount);
        merchantOrdersVO.setPayMethod(payMethod);
        merchantOrdersVO.setReturnUrl(Constant.RETURN_URL);

        OrdersVO ordersVO = new OrdersVO();
        ordersVO.setMerchantOrdersVO(merchantOrdersVO);
        ordersVO.setOrderId(orderId);
        return ordersVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrderStatus(String orderId, Integer status) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderId(orderId);
        orderStatus.setOrderStatus(status);
        orderStatus.setPayTime(new Date());
        orderStatusMapper.updateById(orderStatus);
    }

    @Override
    public OrderStatus queryOrderStatusInfo(String orderId) {
        return orderStatusMapper.selectById(orderId);
    }
}
