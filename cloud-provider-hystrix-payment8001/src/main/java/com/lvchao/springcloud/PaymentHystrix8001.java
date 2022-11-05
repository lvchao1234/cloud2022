package com.lvchao.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@Slf4j
@EnableCircuitBreaker
@EnableEurekaClient
public class PaymentHystrix8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrix8001.class,args);
        log.info("PaymentHystrix8001启动了！");
    }
}
