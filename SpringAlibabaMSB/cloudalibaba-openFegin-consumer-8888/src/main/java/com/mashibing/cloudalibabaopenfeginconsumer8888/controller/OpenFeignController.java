package com.mashibing.cloudalibabaopenfeginconsumer8888.controller;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import com.mashibing.cloudalibabaopenfeginconsumer8888.service.OpenFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignController {

    @Autowired
    private OpenFeginService openFeginService;

    @GetMapping("/getInfo/{id}")
    public JsonResult<String> getInfo(@PathVariable("id") Long id){
        return openFeginService.msbSql(id);
    }

    @GetMapping("testTimeout")
    public String TestTimeout(){
        return openFeginService.timeOut();
    }

}
