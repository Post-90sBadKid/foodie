package com.wry.foodie.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * <p>
 * 订单状态表 订单的每个状态更改都需要进行记录
 * 10：待付款  20：已付款，待发货  30：已发货，待收货（7天自动确认）  40：交易成功（此时可以评价）50：交易关闭（待付款时，用户取消 或 长时间未付款，系统识别后自动关闭）
 * 退货/退货，此分支流程不做，所以不加入
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */

@ApiModel(value = "com-wry-pojo-OrderStatus")
@TableName(value = "order_status")
public class OrderStatus {
    /**
     * 订单ID 对应订单表的主键id
     */
    @TableId(value = "order_id", type = IdType.INPUT)
    @ApiModelProperty(value = "订单ID 对应订单表的主键id")
    private String orderId;

    /**
     * 订单状态
     */
    @TableField(value = "order_status")
    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    /**
     * 订单创建时间 对应[10:待付款]状态
     */
    @TableField(value = "created_time")
    @ApiModelProperty(value = "订单创建时间 对应[10:待付款]状态")
    private Date createdTime;

    /**
     * 支付成功时间 对应[20:已付款，待发货]状态
     */
    @TableField(value = "pay_time")
    @ApiModelProperty(value = "支付成功时间 对应[20:已付款，待发货]状态")
    private Date payTime;

    /**
     * 发货时间 对应[30：已发货，待收货]状态
     */
    @TableField(value = "deliver_time")
    @ApiModelProperty(value = "发货时间 对应[30：已发货，待收货]状态")
    private Date deliverTime;

    /**
     * 交易成功时间 对应[40：交易成功]状态
     */
    @TableField(value = "success_time")
    @ApiModelProperty(value = "交易成功时间 对应[40：交易成功]状态")
    private Date successTime;

    /**
     * 交易关闭时间 对应[50：交易关闭]状态
     */
    @TableField(value = "close_time")
    @ApiModelProperty(value = "交易关闭时间 对应[50：交易关闭]状态")
    private Date closeTime;

    /**
     * 留言时间 用户在交易成功后的留言时间
     */
    @TableField(value = "comment_time")
    @ApiModelProperty(value = "留言时间 用户在交易成功后的留言时间")
    private Date commentTime;

    /**
     * 获取订单ID 对应订单表的主键id
     *
     * @return order_id - 订单ID 对应订单表的主键id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID 对应订单表的主键id
     *
     * @param orderId 订单ID 对应订单表的主键id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取订单状态
     *
     * @return order_status - 订单状态
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态
     *
     * @param orderStatus 订单状态
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取订单创建时间 对应[10:待付款]状态
     *
     * @return created_time - 订单创建时间 对应[10:待付款]状态
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置订单创建时间 对应[10:待付款]状态
     *
     * @param createdTime 订单创建时间 对应[10:待付款]状态
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取支付成功时间 对应[20:已付款，待发货]状态
     *
     * @return pay_time - 支付成功时间 对应[20:已付款，待发货]状态
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置支付成功时间 对应[20:已付款，待发货]状态
     *
     * @param payTime 支付成功时间 对应[20:已付款，待发货]状态
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取发货时间 对应[30：已发货，待收货]状态
     *
     * @return deliver_time - 发货时间 对应[30：已发货，待收货]状态
     */
    public Date getDeliverTime() {
        return deliverTime;
    }

    /**
     * 设置发货时间 对应[30：已发货，待收货]状态
     *
     * @param deliverTime 发货时间 对应[30：已发货，待收货]状态
     */
    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    /**
     * 获取交易成功时间 对应[40：交易成功]状态
     *
     * @return success_time - 交易成功时间 对应[40：交易成功]状态
     */
    public Date getSuccessTime() {
        return successTime;
    }

    /**
     * 设置交易成功时间 对应[40：交易成功]状态
     *
     * @param successTime 交易成功时间 对应[40：交易成功]状态
     */
    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    /**
     * 获取交易关闭时间 对应[50：交易关闭]状态
     *
     * @return close_time - 交易关闭时间 对应[50：交易关闭]状态
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * 设置交易关闭时间 对应[50：交易关闭]状态
     *
     * @param closeTime 交易关闭时间 对应[50：交易关闭]状态
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 获取留言时间 用户在交易成功后的留言时间
     *
     * @return comment_time - 留言时间 用户在交易成功后的留言时间
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 设置留言时间 用户在交易成功后的留言时间
     *
     * @param commentTime 留言时间 用户在交易成功后的留言时间
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}