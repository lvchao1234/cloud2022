package com.lvchao.springcloud.controller;

import com.lvchao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hystrix/ok/getbyid")
    public String paymentInfo_ok(@RequestParam("id") Integer id) {
        String result = service.paymentinfo_ok(id);
        log.info("******result:" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/getbyid")
    public String paymentInfo_TimeOut(@RequestParam("id") Integer id) {
        String result = service.paymentinfo_Timeout(id);
        log.info("******result:" + result);
        return result;
    }

}
