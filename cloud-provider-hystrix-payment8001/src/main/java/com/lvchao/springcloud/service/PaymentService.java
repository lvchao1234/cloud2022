package com.lvchao.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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


}
