CREATE DATABASE `itzixi-pay`;
USE `itzixi-pay`;

CREATE TABLE `orders` (
    id VARCHAR ( 64 ) NOT NULL COMMENT 'ID',
    merchant_order_id VARCHAR ( 64 ) NOT NULL COMMENT '订单ID',
    merchant_user_id VARCHAR ( 64 ) NOT NULL  COMMENT '用户ID',
    amount INT ( 11 ) NOT NULL COMMENT '金额',
    pay_method INT ( 11 ) NOT NULL COMMENT '支付方式',
    pay_status INT ( 11 ) NOT NULL COMMENT '支付状态',
    come_from VARCHAR ( 128 ) NOT NULL COMMENT '提交来源',
    return_url VARCHAR ( 128 ) NOT NULL COMMENT '回调地址',
    is_delete INT ( 11 ) NOT NULL COMMENT '逻辑删除',
    created_time TIMESTAMP NOT NULL COMMENT '创建时间'
    )


CREATE TABLE `users` (
    id VARCHAR ( 64 ) NOT NULL COMMENT 'ID',
    imooc_user_id VARCHAR ( 64 ) NOT NULL COMMENT '用户ID',
    `password` VARCHAR ( 64 ) NOT NULL  COMMENT '密码',
    end_date TIMESTAMP NOT NULL COMMENT '创建时间'
    )