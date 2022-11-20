package com.lvchao.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class GetWayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GetWayMain9527.class,args);
        log.info("GetWayMain9527启动了！");
    }
}
