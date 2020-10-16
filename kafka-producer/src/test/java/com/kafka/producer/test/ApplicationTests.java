package com.kafka.producer.test;

import com.kafka.producer.KafkaProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author eddie.lee
 * @projectName springboot-kafka
 * @package producer.test
 * @className ApplicationTests
 * @description
 * @date created in 2020-10-14 11:10
 * @modified by
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    /**
     * 包名必需和上面一直，不然会出现注入不成功
     * 错误例子： producer.test
     * 正确例子： com.kafka.producer.test
     */
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    public void send() throws InterruptedException {

        String topic = "topic02";
        for(int i=0; i < 1000; i ++) {
            kafkaProducerService.sendMessage(topic, "hello kafka" + i);
            Thread.sleep(5);
        }

        Thread.sleep(Integer.MAX_VALUE);

    }

}
