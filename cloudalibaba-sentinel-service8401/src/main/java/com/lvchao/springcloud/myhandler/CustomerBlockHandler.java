package com.lvchao.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lvchao.springcloud.entity.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handleExcception(BlockException exception) {
        return new CommonResult(4444, "按客户自定义，global handlerException");
    }

    public static CommonResult handleExcception2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义，global handlerException");
    }
}
