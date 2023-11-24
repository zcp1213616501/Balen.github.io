package com.mashibing.cloudalibabaopenfeginconsumer8888.service;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * 此接口就是配合使用OpenFeign的接口，
 * 在此接口中添加@FeignClient注解，
 * 然后在此接口中标椎要远程调用的对应方法
 * 方法签名和调用方保持一致
 */
@Service
//表示远程调用的服务名称
@FeignClient("nacos-provider")
public interface OpenFeginService {
    /**
     * 此方法表示远程调用 info/{id}
     */
    @GetMapping("info/{id}")
    public JsonResult<String> msbSql(@PathVariable("id") Long id);

    @GetMapping("/timeout")
    public String timeOut();

}
