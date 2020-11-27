package com.wry.foodie.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/15
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
