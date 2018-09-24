package com.changhr.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Controller
 * @author changhr2013
 * @create 2018/9/22
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String concurrentTest(){
        return "test";
    }
}
