package com.wry.foodie.common.result;


/**
 * <p>
 * 自定义响应数据结构
 * 200：成功
 * 500：标识出现错误，错误信息在message字段
 * 501：bean验证错误
 * 502：拦截器拦截到token 错误
 * 555：移除抛出信息
 * 556： 用户QQ校验异常
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/28
 */
public class Result<T> {
    /**
     * 响应状态码
     */
    private Integer status;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    public Result(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result ok() {
        return new Result(200, "", null);
    }

    public static <T> Result ok(T data) {
        return new Result<>(200, "", data);
    }

    public static Result ok(String message) {
        return new Result(200, message, null);
    }

    public static <T> Result error(T data) {
        return new Result<>(500, "error", data);
    }

    public static <T> Result error(String message, T data) {
        return new Result<>(500, message, data);
    }

    public static Result error(String message) {
        return new Result(500, message, null);
    }

    public static Result errorVerification(String message) {
        return new Result(501, message, null);
    }

    public static Result errorToken(String message) {
        return new Result(502, message, null);
    }

    public static Result errorException(String message) {
        return new Result(555, message, null);
    }

    public static <T> Result errorException(String message, T data) {
        return new Result<>(555, message, data);
    }
}
