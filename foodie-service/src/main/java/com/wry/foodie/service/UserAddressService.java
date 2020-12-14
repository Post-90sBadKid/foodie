package com.wry.foodie.service;

import com.wry.foodie.pojo.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wry.foodie.pojo.bo.AddressBO;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface UserAddressService extends IService<UserAddress> {

    /**
     * 根据用户Id 查询所有的收货地址
     *
     * @param userId 用户Id
     * @return
     */
    List<UserAddress> queryAll(String userId);

    /**
     * 添加用户收货地址
     *
     * @param addressBO
     * @return
     */
    boolean addNewUserAddress(AddressBO addressBO);

    /**
     * 更新收货地址
     *
     * @param addressBO
     * @return
     */
    boolean updateUserAddress(AddressBO addressBO);

    /**
     * 设置默认收货地址
     *
     * @param userId    用户ID
     * @param addressId 收货地址ID
     * @return
     */
    boolean setDefalut(String userId, String addressId);

    /**
     * 删除收货地址
     *
     * @param userId    用户ID
     * @param addressId 收货地址ID
     * @return
     */
    boolean delete(String userId, String addressId);
}
