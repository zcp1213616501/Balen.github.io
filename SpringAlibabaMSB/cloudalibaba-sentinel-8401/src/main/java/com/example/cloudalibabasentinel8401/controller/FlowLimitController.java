package com.example.cloudalibabasentinel8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.TimeUtil;
import com.example.cloudalibabasentinel8401.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
@RequestMapping("/msb")
public class FlowLimitController {
    @Autowired
    TestService testService;

    @GetMapping("/testA")
    public String testA(){
        //return testService.common();
        return "testA------测试";
    }

    @GetMapping("/testB")
    public String testB(){
        return testService.common();
    }

    @GetMapping("/testC")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------------testC";
    }

    // /testD?id>5
    @GetMapping("/testD")
    public String testD(Integer id){
        if(id !=null && id>1){
            throw new RuntimeException("异常比例测试");
        }
        return "------------testD";
    }

    @GetMapping("/testE")
    public String testE(Integer id){
        if(id !=null && id>1){
            throw new RuntimeException("异常数测试");
        }
        return "------------testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "handler_HotKey")
    public String testHotKey(@RequestParam(value = "hot1",required = false) String hot1,
                             @RequestParam(value = "hot2",required = false) String hot2,
                             @RequestParam(value = "hot3",required = false) String hot3){
        if("6".equals(hot1)){
            throw new RuntimeException("运行时异常");
        }
        return "-----testHotKey";
    }
    public String handler_HotKey(String hot1,String hot2,String hot3,BlockException exception){
        return "系统繁忙请稍后重试。。。";
    }

    @GetMapping("/testF")
    @SentinelResource(value = "testF")
    public String testF(){
        return "-----testF";
    }

}
