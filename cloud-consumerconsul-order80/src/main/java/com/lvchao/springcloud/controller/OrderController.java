package com.lvchao.springcloud.controller;

import com.lvchao.springcloud.entity.CommonResult;
import com.lvchao.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String INVOKE_URL ="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consul/payment/create")
    private String create() {
        log.info("consul order进来了");
        String result = restTemplate.getForObject(INVOKE_URL +"/payment/consul",String.class);
        log.info("consul order返回了");
        return result;
    }

}
