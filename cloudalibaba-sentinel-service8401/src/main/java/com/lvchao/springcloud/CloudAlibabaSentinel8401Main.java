package com.lvchao.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class CloudAlibabaSentinel8401Main {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSentinel8401Main.class, args);
        log.info("CloudAlibabaSentinel8401Main启动成功了！");
    }
}
