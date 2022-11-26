package com.lvchao.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaConsumerNacosOrder83Main {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConsumerNacosOrder83Main.class, args);
        log.info("CloudAlibabaConsumerNacosOrder83Main启动成功了！");
    }
}
