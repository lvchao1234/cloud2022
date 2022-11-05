package com.lvchao.springcloud.service.impl;

import com.lvchao.springcloud.dao.PaymentDao;
import com.lvchao.springcloud.entity.Payment;
import com.lvchao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int insertData(Payment payment) {
        return paymentDao.insertData(payment);
    }

    @Override
    public Payment findDataById(long id) {
        return paymentDao.findDataById(id);
    }
}
