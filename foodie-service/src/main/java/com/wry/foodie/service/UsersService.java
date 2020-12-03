package com.wry.foodie.service;

import com.wry.foodie.pojo.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wry.foodie.pojo.bo.UserBo;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
public interface UsersService extends IService<Users> {

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 存在 true, 不存在 false
     */
    boolean queryUsernameIsExist(String username);


    /**
     * 创建用户
     *
     * @param userBo 用户业务对象
     * @return 创建的用户对象
     */
    Users createUser(UserBo userBo);

    /**
     * 检索用户名和密码是否匹配，用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 当前登录对象
     */
    Users queryUserForLogin(String username, String password);


}
