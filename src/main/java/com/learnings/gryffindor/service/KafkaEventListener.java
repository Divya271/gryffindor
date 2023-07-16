package com.learnings.gryffindor.service;

import com.learnings.gryffindor.utils.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaEventListener {


    private final PropertiesUtil propertiesUtil;

    public KafkaEventListener(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    @KafkaListener(topics = "#{propertiesUtil.kafkaTestTopic}", containerFactory = "testConsumerConfig", groupId = "testGroup")
    void testEventListener(ConsumerRecord<String, String> consumerRecord) {
        log.info("Consumer record: {}", consumerRecord.value());
    }

}
