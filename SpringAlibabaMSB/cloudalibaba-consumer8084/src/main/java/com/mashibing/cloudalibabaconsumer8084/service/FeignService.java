package com.mashibing.cloudalibabaconsumer8084.service;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//当没有成功调用/info/{id}接口时会走fallback属性标注的类型的处理方法
@Service
@FeignClient(value = "nacos-provider",fallback = FeignServiceImpl.class)
public interface FeignService {
    @GetMapping("/info/{id}")
    public JsonResult<String> info(@PathVariable("id") Long id);
}
