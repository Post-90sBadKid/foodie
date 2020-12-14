package com.wry.foodie.service.impl;

import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wry.foodie.common.enums.YesOrNoEnum;
import com.wry.foodie.common.util.IdUtil;
import com.wry.foodie.pojo.bo.AddressBO;
import com.wry.foodie.service.UserAddressService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.mapper.UserAddressMapper;
import com.wry.foodie.pojo.UserAddress;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> queryAll(String userId) {
        QueryWrapper<UserAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return userAddressMapper.selectList(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean addNewUserAddress(AddressBO addressBO) {

        QueryWrapper<UserAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", addressBO.getUserId());
        Integer integer = userAddressMapper.selectCount(wrapper);

        UserAddress address = new UserAddress();
        address.setId(IdUtil.getId());
        address.setUserId(addressBO.getUserId());
        address.setReceiver(addressBO.getReceiver());
        address.setMobile(addressBO.getMobile());
        address.setProvince(addressBO.getProvince());
        address.setCity(addressBO.getCity());
        address.setDistrict(addressBO.getDistrict());
        address.setDetail(addressBO.getDetail());
        address.setCreatedTime(new Date());
        address.setUpdatedTime(new Date());
        if (Objects.isNull(integer) || integer == 0) {
            address.setIsDefault(YesOrNoEnum.YES.type);
        } else {
            address.setIsDefault(YesOrNoEnum.NO.type);
        }
        userAddressMapper.insert(address);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean updateUserAddress(AddressBO addressBO) {
        UserAddress address = new UserAddress();
        address.setId(addressBO.getAddressId());
        address.setUserId(addressBO.getUserId());
        address.setReceiver(addressBO.getReceiver());
        address.setMobile(addressBO.getMobile());
        address.setProvince(addressBO.getProvince());
        address.setCity(addressBO.getCity());
        address.setDistrict(addressBO.getDistrict());
        address.setDetail(addressBO.getDetail());
        address.setCreatedTime(new Date());
        address.setUpdatedTime(new Date());
        userAddressMapper.updateById(address);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean setDefalut(String userId, String addressId) {
        UserAddress address = new UserAddress();
        address.setUpdatedTime(new Date());
        address.setIsDefault(YesOrNoEnum.NO.type);
        UpdateWrapper<UserAddress> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id",userId);
        userAddressMapper.update(address, updateWrapper);

        address.setId(addressId);
        address.setIsDefault(YesOrNoEnum.YES.type);
        address.setUpdatedTime(new Date());
        userAddressMapper.updateById(address);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean delete(String userId, String addressId) {
        userAddressMapper.deleteById(addressId);
        return true;
    }
}
