package com.lvchao.springcloud.Api;

import com.lvchao.springcloud.entity.CommonResult;
import com.lvchao.springcloud.entity.Payment;
import com.lvchao.springcloud.lb.LoadBalance;
import com.netflix.appinfo.InstanceInfo;
import com.sun.jndi.toolkit.url.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class OrderController {

    public static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalance loadBalance;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    private CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info("插入的数据"+payment);
        return restTemplate.postForObject(PAYMENT_URL +"/insertData",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get")
    private CommonResult<Payment> getPayment(@RequestParam("id")long id) {
        log.info("查询的id为"+id);
        return restTemplate.getForObject(PAYMENT_URL +"/findDataById?id="+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getforentity")
    private CommonResult<Payment> getPayment2(@RequestParam("id")long id) {
        log.info("查询的id为"+id);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL +"/findDataById?id="+id,CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+"");
            return entity.getBody();
        } else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        log.info("order进来了");
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/findDataById/lb",String.class);
    }
}
