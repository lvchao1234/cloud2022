package com.lvchao.springcloud.Api;

import com.lvchao.springcloud.entity.CommonResult;
import com.lvchao.springcloud.entity.Payment;
import com.lvchao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    private Object discovery(){
        List<String> list = discoveryClient.getServices();
        for(String element : list) {
            log.info("================element" + element);
        }

        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance serviceInstance : instanceList) {
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t" + serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/findDataById/lb")
    private CommonResult findDataById1() {
        log.info("get进来了");
        return new CommonResult(200, "查询成功serverPort"+serverPort, null);
    }

    @GetMapping("/payment/feign/timeout")
    private String paymentFeignTimeOut() {
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    private String paymentZipKin() {
        return "hi, Im paymentzipkin server fall back, welcome to lvchao.com, O(∩_∩)O哈哈~";
    }
}
