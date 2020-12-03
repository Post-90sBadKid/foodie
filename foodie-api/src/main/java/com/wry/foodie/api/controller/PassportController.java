package com.wry.foodie.api.controller;

import com.wry.foodie.common.result.Result;
import com.wry.foodie.common.util.CookieUtils;
import com.wry.foodie.common.util.JsonUtils;
import com.wry.foodie.pojo.Users;
import com.wry.foodie.pojo.bo.UserBo;
import com.wry.foodie.service.UsersService;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * <p>
 * 通行证 接口层
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/28
 */
@RestController
@RequestMapping("passport")
@Api(tags = "登陆注册接口")
public class PassportController {
    @Resource
    private UsersService usersService;

    @ApiOperation(value = "判断用户名是否存在")
    @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "wry", required = true, dataTypeClass = String.class)
    @GetMapping("/usernameIsExist")
    public Result usernameIsExist(@RequestParam String username) {
        //1.用户名不能为空
        if (Objects.isNull(username) || username.isEmpty()) {
            return Result.error("用户名不能为空！");
        }
        //2.查看用户名是否存在
        boolean isExist = usersService.queryUsernameIsExist(username);
        if (isExist) {
            return Result.error("用户名已经存在！");
        }
        //3.请求成功
        return Result.ok();
    }

    @ApiOperation(value = "注册")
    @PostMapping("/regist")
    public Result register(@RequestBody @Validated UserBo userBo,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        String username = userBo.getUsername();
        String password = userBo.getPassword();
        String confirmPassword = userBo.getConfirmPassword();
        if (!confirmPassword.equals(password)) {
            return Result.errorVerification("两次密码输入不一致");
        }
        boolean isExist = usersService.queryUsernameIsExist(username);
        if (isExist) {
            return Result.errorVerification("用户名已经存在！");
        }
        Users user = usersService.createUser(userBo);
        setNullProperty(user);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);

        return Result.ok(user);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Validated UserBo userBo,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        String username = userBo.getUsername();
        String password = userBo.getPassword();
        Users user = usersService.queryUserForLogin(username, password);
        if (Objects.isNull(user)) {
            return Result.error("用户名活密码错误！");
        }
        setNullProperty(user);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);
        return Result.ok(user);
    }

    @ApiOperation(value = "用户退出登录")
    @PostMapping("/logout")
    public Result logout(@RequestParam String userId,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, "user");

        //TODO 用户退出登录,需要清空购物出
        //TODO 分布式会话,需要清除用户信息
        return Result.ok();
    }

    private void setNullProperty(Users users) {
        users.setPassword(null);
        users.setRealname(null);
        users.setBirthday(null);
        users.setEmail(null);
        users.setMobile(null);
        users.setCreatedTime(null);
        users.setUpdatedTime(null);
    }
}
