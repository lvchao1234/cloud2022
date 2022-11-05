package com.lvchao.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PamentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----------------PaymentFallbackService paymentInfo_ok fall back,(⊙﹏⊙)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----------------PaymentFallbackService paymentInfo_TimeOut fall back,(⊙﹏⊙)";
    }
}
