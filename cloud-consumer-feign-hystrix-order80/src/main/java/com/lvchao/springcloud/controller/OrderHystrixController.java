package com.lvchao.springcloud.controller;

import com.lvchao.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentinfo_Global_TimeoutHandler")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;

    @GetMapping("/consumer/payment/hystrix/ok/getbyid")
    public String paymentInfo_ok(@RequestParam("id") Integer id){
        String result = service.paymentInfo_ok(id);
        return  result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/getbyid")
//    @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
//    @HystrixCommand
    public String paymentInfo_TimeOut(@RequestParam("id") Integer id){
        String result = service.paymentInfo_TimeOut(id);
        return  result;
    }

    public String paymentinfo_TimeoutHandler(Integer id) {
        return "我是消费方80,线程池：" +Thread.currentThread().getName()+" paymentinfo_TimeoutHandler, id:" + id + "\t" + "(⊙﹏⊙)~~";
    }

    public String paymentinfo_Global_TimeoutHandler() {
        return "我是消费方80总异常处理(⊙﹏⊙)~~";
    }
}
