package com.wry.foodie.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 订单商品关联表
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@ApiModel(value = "com-wry-pojo-OrderItems")
@TableName(value = "order_items")
public class OrderItems {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 归属订单id
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value = "归属订单id")
    private String orderId;

    /**
     * 商品id
     */
    @TableField(value = "item_id")
    @ApiModelProperty(value = "商品id")
    private String itemId;

    /**
     * 商品图片
     */
    @TableField(value = "item_img")
    @ApiModelProperty(value = "商品图片")
    private String itemImg;

    /**
     * 商品名称
     */
    @TableField(value = "item_name")
    @ApiModelProperty(value = "商品名称")
    private String itemName;

    /**
     * 规格id
     */
    @TableField(value = "item_spec_id")
    @ApiModelProperty(value = "规格id")
    private String itemSpecId;

    /**
     * 规格名称
     */
    @TableField(value = "item_spec_name")
    @ApiModelProperty(value = "规格名称")
    private String itemSpecName;

    /**
     * 成交价格
     */
    @TableField(value = "price")
    @ApiModelProperty(value = "成交价格")
    private Integer price;

    /**
     * 购买数量
     */
    @TableField(value = "buy_counts")
    @ApiModelProperty(value = "购买数量")
    private Integer buyCounts;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取归属订单id
     *
     * @return order_id - 归属订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置归属订单id
     *
     * @param orderId 归属订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取商品id
     *
     * @return item_id - 商品id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置商品id
     *
     * @param itemId 商品id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取商品图片
     *
     * @return item_img - 商品图片
     */
    public String getItemImg() {
        return itemImg;
    }

    /**
     * 设置商品图片
     *
     * @param itemImg 商品图片
     */
    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    /**
     * 获取商品名称
     *
     * @return item_name - 商品名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置商品名称
     *
     * @param itemName 商品名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取规格id
     *
     * @return item_spec_id - 规格id
     */
    public String getItemSpecId() {
        return itemSpecId;
    }

    /**
     * 设置规格id
     *
     * @param itemSpecId 规格id
     */
    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    /**
     * 获取规格名称
     *
     * @return item_spec_name - 规格名称
     */
    public String getItemSpecName() {
        return itemSpecName;
    }

    /**
     * 设置规格名称
     *
     * @param itemSpecName 规格名称
     */
    public void setItemSpecName(String itemSpecName) {
        this.itemSpecName = itemSpecName;
    }

    /**
     * 获取成交价格
     *
     * @return price - 成交价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置成交价格
     *
     * @param price 成交价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取购买数量
     *
     * @return buy_counts - 购买数量
     */
    public Integer getBuyCounts() {
        return buyCounts;
    }

    /**
     * 设置购买数量
     *
     * @param buyCounts 购买数量
     */
    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }
}