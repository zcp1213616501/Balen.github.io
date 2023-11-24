package com.mashibing.cloudalibabaconsumer8084.service;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService{
    //当远程调用失败或者超时时的容错处理逻辑
    @Override
    public JsonResult<String> info(Long id) {
        return new JsonResult<String>(444L,"服务降级返回！");
    }
}
