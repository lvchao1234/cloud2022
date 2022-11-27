package com.lvchao.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CloudAlibabaConsumerOrderMain84 {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConsumerOrderMain84.class, args);
        log.info("CloudAlibabaConsumerOrderMain84启动成功了！");
    }
}
