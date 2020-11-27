package com.wry.foodie.service.impl;

import com.wry.foodie.service.UserAddressService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.mapper.UserAddressMapper;
import com.wry.foodie.pojo.UserAddress;

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

}
