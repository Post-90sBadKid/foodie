package com.wry.foodie.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/29
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 1.添加Cors配置信息
        config.setAllowedOrigins(Arrays.asList("*"));
        // 设置是否发送cookie 信息
        config.setAllowCredentials(true);
        // 设置请求允许的方法类型
        config.setAllowedMethods(Arrays.asList("*"));
        // 设置请求允许的header
        config.setAllowedHeaders(Arrays.asList("*"));
        // 2.为URL添加映射信息
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(corsSource);
    }
}
