package com.lvchao.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class Payment8006 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8006.class,args);
        log.info("consul启动成功");
    }
}
