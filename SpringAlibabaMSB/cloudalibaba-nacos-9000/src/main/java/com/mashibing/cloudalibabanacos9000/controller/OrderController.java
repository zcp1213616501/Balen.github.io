package com.mashibing.cloudalibabanacos9000.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    //服务提供者URL
    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @GetMapping("test")
    public String test(){
        return "Nacos客户端";
    }

    @GetMapping("msb/stock")
    public String stock(){
        String result = restTemplate
                .getForObject(SERVICE_URL+"/msb/get",String.class);
        //http://nacos-provider/msb/get
        return result;
    }
}
