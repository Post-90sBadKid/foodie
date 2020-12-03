package com.wry.foodie.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wry.foodie.common.enums.SexEnum;
import com.wry.foodie.common.util.IdUtil;
import com.wry.foodie.pojo.bo.UserBo;
import com.wry.foodie.service.UsersService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.foodie.pojo.Users;
import com.wry.foodie.mapper.UsersMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    private final static String DEFAULT_FACE = "https://img2.woyaogexing.com/2020/11/28/58ed88ade84e40e69a8c801d3c41591b!400x400.jpeg";

    @Override
    public boolean queryUsernameIsExist(String username) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Users users = usersMapper.selectOne(wrapper);
        return Objects.isNull(users) ? false : true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Users createUser(UserBo userBo) {
        Users users = new Users();
        users.setId(IdUtil.getId());
        users.setUsername(userBo.getUsername());
        users.setPassword(SecureUtil.md5(userBo.getPassword()));
        //默认用户名称和昵称同名
        users.setNickname(userBo.getUsername());
        //默认头像
        users.setFace(DEFAULT_FACE);
        //默认性别
        users.setSex(SexEnum.SECRET.type);
        //默认生日
        users.setBirthday(DateUtil.parse("1900-01-01"));
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());
        usersMapper.insert(users);
        return users;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", SecureUtil.md5(password));
        return usersMapper.selectOne(wrapper);
    }
}
