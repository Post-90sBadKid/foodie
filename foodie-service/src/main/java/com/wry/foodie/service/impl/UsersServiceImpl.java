package com.wry.foodie.service.impl;

import com.wry.foodie.service.UsersService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.pojo.Users;
import com.wry.foodie.mapper.UsersMapper;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
