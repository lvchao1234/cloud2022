package com.lvchao.springcloud.service.Impl;

import com.lvchao.springcloud.service.SnowflakeService;
import com.lvchao.springcloud.util.IdGeneratorSnowflake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class SnowflakeServiceImpl implements SnowflakeService {

    @Autowired
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Override
    public String getIDBySnowflake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 20; i++) {
            threadPool.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        threadPool.shutdown();

        return "hello snowflake";
    }

}
