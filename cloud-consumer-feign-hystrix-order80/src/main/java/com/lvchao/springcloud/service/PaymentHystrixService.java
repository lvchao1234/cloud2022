package com.lvchao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "cloud-payment-hystrix-service", fallback = PamentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/getbyid")
    public String paymentInfo_ok(@RequestParam("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/getbyid")
    public String paymentInfo_TimeOut(@RequestParam("id") Integer id);

}
