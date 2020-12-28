package com.imooc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class Users {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户在慕课网的用户id
     */
    @TableField(value= "imooc_user_id")
    private String imoocUserId;

    /**
     * 由我分配给用户的密码，这个密码存入数据库需要加密
     */
    private String password;

    /**
     * 用户访问有效期，20元/月
     */
    @TableField(value= "end_date")
    private Date endDate;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户在慕课网的用户id
     *
     * @return imooc_user_id - 用户在慕课网的用户id
     */
    public String getImoocUserId() {
        return imoocUserId;
    }

    /**
     * 设置用户在慕课网的用户id
     *
     * @param imoocUserId 用户在慕课网的用户id
     */
    public void setImoocUserId(String imoocUserId) {
        this.imoocUserId = imoocUserId;
    }

    /**
     * 获取由我分配给用户的密码，这个密码存入数据库需要加密
     *
     * @return password - 由我分配给用户的密码，这个密码存入数据库需要加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置由我分配给用户的密码，这个密码存入数据库需要加密
     *
     * @param password 由我分配给用户的密码，这个密码存入数据库需要加密
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户访问有效期，20元/月
     *
     * @return end_date - 用户访问有效期，20元/月
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置用户访问有效期，20元/月
     *
     * @param endDate 用户访问有效期，20元/月
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}