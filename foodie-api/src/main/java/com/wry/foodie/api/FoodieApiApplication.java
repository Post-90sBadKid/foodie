package com.wry.foodie.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wry.foodie"})
@MapperScan(basePackages = {"com.wry.foodie.**.mapper"})
@EnableTransactionManagement
public class FoodieApiApplication {
    public static void main(String[] args) {
      SpringApplication.run(FoodieApiApplication.class, args);
    }
}
