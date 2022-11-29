package com.lvchao.springcloud.service.Impl;

import com.lvchao.springcloud.dao.OrderDao;
import com.lvchao.springcloud.domain.Order;
import com.lvchao.springcloud.service.AccountService;
import com.lvchao.springcloud.service.OrderService;
import com.lvchao.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-------------------->开始新建订单");
        orderDao.create(order);

        log.info("-------------------->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------------------->订单微服务开始调用库存，做扣减end");

        log.info("-------------------->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------------------->订单微服务开始调用账户，做扣减end");

        //4.修改订单的状态 从0到1 1代表已经完成
        log.info("-------------------->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("-------------------->修改订单状态结束");

        log.info("-------------------->下订单结束，O(∩_∩)O~~");
    }
}
