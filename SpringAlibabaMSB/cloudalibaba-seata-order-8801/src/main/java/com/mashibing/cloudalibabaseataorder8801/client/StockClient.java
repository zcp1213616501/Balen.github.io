package com.mashibing.cloudalibabaseataorder8801.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "seata-stock")
public interface StockClient {
    @GetMapping("/stock/decr")
    String decrement();
}
