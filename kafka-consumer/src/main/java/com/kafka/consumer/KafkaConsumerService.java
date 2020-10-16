package com.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author eddie.lee
 * @projectName springboot-kafka
 * @package com.kafka.consumer
 * @className kafkaConsumerService
 * @description
 * @date created in 2020-10-14 10:58
 * @modified by
 */
@Slf4j
@Component
public class KafkaConsumerService {

    @KafkaListener(groupId = "group02", topics = "topic02")
    public void onMessage(ConsumerRecord<String, Object> record,
                          Acknowledgment acknowledgment,
                          Consumer<?, ?> consumer) {
        log.info("消费端接收消息：{}" , record.value());
        // 手工签收机制
        //acknowledgment.acknowledge();

        /**
         * # 查看 topics 历史
         * bash-4.4# kafka-topics.sh --zookeeper zookeeper:2181 --list
         * __consumer_offsets
         * test
         * topic
         *
         * # 创建 topics
         * bash-4.4# kafka-topics.sh --create --topic topic02 --partitions 2 --zookeeper zookeeper:2181 --replication-factor 1
         * Created topic topic02.
         *
         * # 消费者, 提示不存在，就启动本服务
         * bash-4.4# kafka-consumer-groups.sh --bootstrap-server kafka:9092 --describe --group group02
         * Error: Consumer group 'group02' does not exist.
         *
         */

    }
}
