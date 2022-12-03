package com.lvchao.springcloud.controller;

import com.lvchao.springcloud.domain.CommonResult;
import com.lvchao.springcloud.service.SnowflakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class SnowflakeController {

    @Resource
    private SnowflakeService snowflakeService;

    @RequestMapping("/getSnowflake")
    public CommonResult getSnowflake() {
        String result = snowflakeService.getIDBySnowflake();
        return new CommonResult(200, result);
    }
}
