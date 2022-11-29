package com.lvchao.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消数据源的自动创建
@EnableDiscoveryClient
public class CloudAlibabaOrderServiceMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaOrderServiceMain2001.class, args);
        log.info("CloudAlibabaOrderServiceMain2001启动成功了！");
    }
}
