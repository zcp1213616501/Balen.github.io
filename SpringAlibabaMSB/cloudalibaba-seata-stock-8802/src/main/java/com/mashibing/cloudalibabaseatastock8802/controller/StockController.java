package com.mashibing.cloudalibabaseatastock8802.controller;

import com.mashibing.cloudalibabaseatastock8802.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StockController {
    @Resource
    private StockService stockService;

    @GetMapping("/stock/decr")
    public String decrement(){
        stockService.decr();
        return "库存-1";
    }

}
