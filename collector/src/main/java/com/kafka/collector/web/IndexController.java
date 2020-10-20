package com.kafka.collector.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eddie.lee
 * @projectName springboot-kafka
 * @package com.kafka.collector.web
 * @className IndexController
 * @description
 * @date created in 2020-10-19 11:42
 * @modified by
 */
@Slf4j
@RestController
public class IndexController {

    @RequestMapping(value = "/index")
    public String index() {

        log.info("我是一条 info 日志");

        log.warn("我是一条 warn 日志");

        log.error("我是一条 error 日志");

        return "index";
    }

}
