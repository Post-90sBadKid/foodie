package com.wry.foodie.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.wry.foodie.common.result.Result;
import com.wry.foodie.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/12/24
 */
@RestController
public class QrCodeController {


    @GetMapping("/qr")
    public void qr(HttpServletResponse response) throws IOException {
        OutputStream outputStream = response.getOutputStream();
        QrCodeUtil.generate("https://hutool.cn/", 300, 300,"png",outputStream);
    }


}
