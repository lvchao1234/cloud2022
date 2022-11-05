package com.lvchao.springcloud.controller;

import com.lvchao.springcloud.entity.CommonResult;
import com.lvchao.springcloud.entity.Payment;
import com.lvchao.springcloud.service.PaymentFignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFignService paymentFignService;

    @GetMapping("/findDataById")
    public CommonResult<Payment> getPayment(@RequestParam("id") long id) {
        return paymentFignService.findDataById(id);
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFignService.paymentFeignTimeOut();
    }
}
