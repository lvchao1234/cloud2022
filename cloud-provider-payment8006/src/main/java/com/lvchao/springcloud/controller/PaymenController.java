package com.lvchao.springcloud.controller;

import com.lvchao.springcloud.entity.CommonResult;
import com.lvchao.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymenController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/consul")
    private String insertData() {
        log.info("consul payment进来了");
        return "Consul-----serverPort"+serverPort;
    }
}
