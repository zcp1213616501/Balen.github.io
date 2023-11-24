package com.mashibing.cloudalibabaseataorder8801.controller;

import com.mashibing.cloudalibabaseataorder8801.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public String create(){
        orderService.create();
        return "生成订单";
    }
}
