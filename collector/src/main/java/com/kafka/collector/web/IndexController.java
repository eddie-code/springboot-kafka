package com.kafka.collector.web;

import com.kafka.collector.util.InputMDC;
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

    /**
     * [%d{yyyy-MM-dd'T'HH:mm:ss.SSSZZ}] [%level{length=5}] [%thread-%tid] [%logger] [%X{hostName}] [%X{ip}] [%X{applicationName}] [%F,%L,%C,%M] [%m] ## '%ex'%n
     * <p>
     * [2020-10-20T13:51:37.282+08:00] [ERROR] [http-nio-8001-exec-1-34] [com.kafka.collector.web.IndexController] [LAPTOP-7SLCU8QK] [192.168.8.50] [collector] [IndexController.java,30,com.kafka.collector.web.IndexController,index] [我是一条 error 日志] ## ''
     */
    @RequestMapping(value = "/index")
    public String index() {

        InputMDC.putMDC();

        log.info("我是一条 info 日志");

        log.warn("我是一条 warn 日志");

        log.error("我是一条 error 日志");

        return "index";
    }

    @RequestMapping(value = "/err")
    public String err() {
        InputMDC.putMDC();
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            log.error("算术异常：", e);
        }
        return "err";
    }

}
