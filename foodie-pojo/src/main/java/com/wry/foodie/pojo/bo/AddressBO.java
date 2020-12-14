package com.wry.foodie.pojo.bo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/12/9
 */
public class AddressBO {
    private String addressId;
    @NotBlank(message = "用户名不能为空")
    @NotNull(message = "用户名不能为空")
    private String userId;
    @NotBlank(message = "收件人不能为空")
    private String receiver;
    @Length( max = 11, message = "手机号码为11位")
    @NotNull
    private String mobile;
    @NotNull(message = "省份不能为空")
    @NotBlank(message = "省份不能为空")
    private String province;
    @NotNull(message = "城市不能为空")
    @NotBlank(message = "城市不能为空")
    private String city;
    @NotNull(message = "县/市区不能为空")
    @NotBlank(message = "县/市区不能为空")
    private String district;
    @NotNull(message = "详细地址不能为空")
    @NotBlank(message = "详细地址不能为空")
    private String detail;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
