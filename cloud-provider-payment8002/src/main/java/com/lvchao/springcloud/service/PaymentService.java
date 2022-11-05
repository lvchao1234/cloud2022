package com.lvchao.springcloud.service;

import com.lvchao.springcloud.entity.Payment;

public interface PaymentService {

    int insertData(Payment payment);

    Payment findDataById(long id);
}
