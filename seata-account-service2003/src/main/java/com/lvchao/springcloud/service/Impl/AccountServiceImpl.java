package com.lvchao.springcloud.service.Impl;

import com.lvchao.springcloud.dao.AccountDao;
import com.lvchao.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
      log.info("---------------->account-service中扣减账户余额开始");
      accountDao.decrease(userId, money);
      log.info("---------------->account-service中扣减账户余额结束");
    }
}
