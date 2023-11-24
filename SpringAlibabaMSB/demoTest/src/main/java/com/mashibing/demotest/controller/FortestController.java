package com.mashibing.demotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Date: 2022年03月30日
 *
 * @auther xialin
 * @version: 1.0
 */
@RestController
@RequestMapping("/msb")
public class FortestController {
    @GetMapping("/test")
    public String list(){
        return "success";
    }
}
