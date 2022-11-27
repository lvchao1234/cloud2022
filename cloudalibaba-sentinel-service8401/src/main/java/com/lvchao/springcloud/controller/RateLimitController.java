package com.lvchao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lvchao.springcloud.entity.CommonResult;
import com.lvchao.springcloud.entity.Payment;
import com.lvchao.springcloud.myhandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RateLimitController {

    @GetMapping("/byresource")
    @SentinelResource(value = "byresource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试ok", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }


    @GetMapping("/ratelimit/byurl")
    @SentinelResource(value = "byurl")
    public CommonResult byurl() {
        return new CommonResult(200, "按url限流测试ok", new Payment(2020L, "serial001"));
    }

    @GetMapping("/ratelimit/customeBlockHandler")
    @SentinelResource(value = "customeBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleExcception2")
    public CommonResult customeBlockHandler() {
        return new CommonResult(200, "按客户自定义", new Payment(2020L, "serial003"));
    }

}
