package com.lvchao.springcloud.Api;

import com.lvchao.springcloud.entity.CommonResult;
import com.lvchao.springcloud.entity.Payment;
import com.lvchao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/insertData")
    private CommonResult insertData(@RequestBody Payment payment) {
        log.info("post进来了"+payment);
        int num = paymentService.insertData(payment);
        if(num > 0){
            //插入成功
            return new CommonResult(200, "插入数据库成功serverPort"+serverPort, num);
        }else{
            return new CommonResult(444, "插入数据库失败");
        }
    }

    @GetMapping("/findDataById")
    private CommonResult findDataById(@RequestParam("id")long id) {
        log.info("get进来了");
        Payment payment = paymentService.findDataById(id);
        if(payment != null){
            //查询成功
            return new CommonResult(200, "查询成功serverPort"+serverPort, payment);
        }else{
            return new CommonResult(444, "没有对应记录，查询ID：" + id);
        }
    }

    @GetMapping("/findDataById/lb")
    private CommonResult findDataById1() {
        log.info("get进来了");
        return new CommonResult(200, "查询成功serverPort"+serverPort, null);
    }

}
