package com.lvchao.springcloud.Controller;

import com.lvchao.springcloud.entity.CommonResult;
import com.lvchao.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/insertData")
    private CommonResult insertData(@RequestBody Payment payment) {
        log.info("post进来了"+payment);
        return new CommonResult(200, "Zookeeper-----serverPort"+serverPort);
    }
}
