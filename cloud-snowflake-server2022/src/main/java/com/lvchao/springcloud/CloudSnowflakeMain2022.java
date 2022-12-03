package com.lvchao.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CloudSnowflakeMain2022 {

    public static void main(String[] args) {
        SpringApplication.run(CloudSnowflakeMain2022.class, args);
        log.info("CloudSnowflakeMain2022启动成功了！");
    }
}
