package com.lvchao.springcloud.service.Impl;

import com.lvchao.springcloud.dao.AccountDao;
import com.lvchao.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
      log.info("---------------->account-service中扣减账户余额开始");
      try{
          TimeUnit.SECONDS.sleep(20);
      }catch (InterruptedException e) {
          e.printStackTrace();
      }
      accountDao.decrease(userId, money);
      log.info("---------------->account-service中扣减账户余额结束");
    }
}
