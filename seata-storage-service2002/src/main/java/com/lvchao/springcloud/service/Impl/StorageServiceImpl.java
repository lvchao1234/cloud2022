package com.lvchao.springcloud.service.Impl;

import com.lvchao.springcloud.dao.StorageDao;
import com.lvchao.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------------------->storage-service中扣减库存开始, productId: " + productId + ",count: " + count);
        storageDao.decrease(productId, count);
        log.info("------------------->storage-service中扣减库存结束");
    }
}
