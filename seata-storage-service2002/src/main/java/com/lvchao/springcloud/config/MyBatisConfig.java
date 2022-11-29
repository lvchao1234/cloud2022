package com.lvchao.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.lvchao.springcloud.dao"})
public class MyBatisConfig {
}
