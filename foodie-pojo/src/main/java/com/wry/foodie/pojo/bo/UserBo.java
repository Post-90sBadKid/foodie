package com.wry.foodie.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/28
 */
@ApiModel(value = "用户对象BO", description = "从前端传入的数据封装的对象")
public class UserBo {

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(name = "用户名1", value = "用户名", example = "wry",required = true)
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 12, message = "密码长度为6-12位")
    @ApiModelProperty(name = "密码1", value = "密码", example = "123456",required = true)
    private String password;

    @ApiModelProperty(name = "确认密码1", value = "确认密码", example = "123456",required = true)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
