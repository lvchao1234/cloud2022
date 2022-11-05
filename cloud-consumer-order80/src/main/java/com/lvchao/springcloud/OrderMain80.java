package com.lvchao.springcloud;

import com.lvchao.myrule.MyRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@Slf4j
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
@EnableEurekaClient
@SpringBootApplication
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
        log.info("OrderMain80启动了！");
    }
}
