package com.lvchao.springcloud.service;

import com.lvchao.springcloud.entity.CommonResult;
import com.lvchao.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFignService {

    @GetMapping("/findDataById")
    public CommonResult findDataById(@RequestParam("id")long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
