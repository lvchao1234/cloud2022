package com.lvchao.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问，肯定ok
     * @param id
     * @return
     */
    public String paymentinfo_ok(Integer id) {
        return "线程池：" +Thread.currentThread().getName()+" paymentinfo_ok, id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 正常访问，肯定ok
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentinfo_Timeout(Integer id) {
        int timenumber =3000;
//        int page = 10/0;
        try{TimeUnit.SECONDS.sleep(timenumber);}catch (InterruptedException e) {e.printStackTrace();}
        return "线程池：" +Thread.currentThread().getName()+" paymentinfo_Timeout, id:" + id + "\t" + "O(∩_∩)O哈哈~" + "耗时：";
    }

    public String paymentinfo_TimeoutHandler(Integer id) {
        return "线程池：" +Thread.currentThread().getName()+" paymentinfo_TimeoutHandler, id:" + id + "\t" + "(⊙﹏⊙)~~";
    }

    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircutBeaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),/* 是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")// 超时处理
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("================id  不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircutBeaker_fallback(@PathVariable("id") Integer id) {
        return "+++++++++++++++++++++++++id不能负数，请稍后再试，(⊙﹏⊙) id:" + id;
    }

}
