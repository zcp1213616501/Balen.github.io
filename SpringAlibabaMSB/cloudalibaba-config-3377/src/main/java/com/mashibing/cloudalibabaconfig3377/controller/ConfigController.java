package com.mashibing.cloudalibabaconfig3377.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//动态刷新
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    //通用
    @Value("${config.common}")
    private String common;

    //共享
    @Value("${redisip}")
    private String redisIp;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }

    //通用
    @GetMapping("/config/common")
    public String getConfigCommon(){
        return common;
    }

    //共享
    @GetMapping("/config/redisip")
    public String getRedisIp(){
        return redisIp;
    }
}
