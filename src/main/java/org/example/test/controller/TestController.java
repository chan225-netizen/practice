package org.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 测试springboot环境
     * @return
     */
    @GetMapping("/hello")
    public String getName(){
        return "hello world ";
    }
}
