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
 * 用户地址表
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@ApiModel(value = "com-wry-pojo-UserAddress")
@TableName(value = "user_address")
public class UserAddress {
    /**
     * 地址主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "地址主键id")
    private String id;

    /**
     * 关联用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "关联用户id")
    private String userId;

    /**
     * 收件人姓名
     */
    @TableField(value = "receiver")
    @ApiModelProperty(value = "收件人姓名")
    private String receiver;

    /**
     * 收件人手机号
     */
    @TableField(value = "mobile")
    @ApiModelProperty(value = "收件人手机号")
    private String mobile;

    /**
     * 省份
     */
    @TableField(value = "province")
    @ApiModelProperty(value = "省份")
    private String province;

    /**
     * 城市
     */
    @TableField(value = "city")
    @ApiModelProperty(value = "城市")
    private String city;

    /**
     * 区县
     */
    @TableField(value = "district")
    @ApiModelProperty(value = "区县")
    private String district;

    /**
     * 详细地址
     */
    @TableField(value = "detail")
    @ApiModelProperty(value = "详细地址")
    private String detail;

    /**
     * 扩展字段
     */
    @TableField(value = "extand")
    @ApiModelProperty(value = "扩展字段")
    private String extand;

    /**
     * 是否默认地址 1:是  0:否
     */
    @TableField(value = "is_default")
    @ApiModelProperty(value = "是否默认地址 1:是  0:否")
    private Integer isDefault;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time")
    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

    /**
     * 获取地址主键id
     *
     * @return id - 地址主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置地址主键id
     *
     * @param id 地址主键id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取关联用户id
     *
     * @return user_id - 关联用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置关联用户id
     *
     * @param userId 关联用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取收件人姓名
     *
     * @return receiver - 收件人姓名
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置收件人姓名
     *
     * @param receiver 收件人姓名
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 获取收件人手机号
     *
     * @return mobile - 收件人手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置收件人手机号
     *
     * @param mobile 收件人手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区县
     *
     * @return district - 区县
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区县
     *
     * @param district 区县
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取详细地址
     *
     * @return detail - 详细地址
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置详细地址
     *
     * @param detail 详细地址
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取扩展字段
     *
     * @return extand - 扩展字段
     */
    public String getExtand() {
        return extand;
    }

    /**
     * 设置扩展字段
     *
     * @param extand 扩展字段
     */
    public void setExtand(String extand) {
        this.extand = extand;
    }

    /**
     * 获取是否默认地址 1:是  0:否
     *
     * @return is_default - 是否默认地址 1:是  0:否
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否默认地址 1:是  0:否
     *
     * @param isDefault 是否默认地址 1:是  0:否
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间
     *
     * @return updated_time - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}