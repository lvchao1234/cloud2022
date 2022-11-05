package com.lvchao.springcloud.dao;

import com.lvchao.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int insertData(Payment payment);

    Payment findDataById(@Param("id")long id);
}
